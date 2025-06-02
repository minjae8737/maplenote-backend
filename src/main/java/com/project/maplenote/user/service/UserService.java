package com.project.maplenote.user.service;

import com.project.maplenote.global.domain.ApiResponse;
import com.project.maplenote.user.domain.JoinDto;
import com.project.maplenote.user.domain.LoginDto;
import com.project.maplenote.user.domain.User;
import com.project.maplenote.user.domain.UserResponseDto;
import com.project.maplenote.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

//FIXME 나중에 시큐리티적용
@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    public Mono<ApiResponse<UserResponseDto>> join(JoinDto joinDto) {
        return userRepository.existsUserByEmail(joinDto.getEmail())
                .flatMap(isExists -> {
                    if (isExists) {
                        return Mono.just(ApiResponse.<UserResponseDto>builder()
                                .success(false)
                                .message("이미 존재하는 이메일 입니다")
                                .statusCode(400)
                                .build());
                    }

                    User user = User.builder()
                            .email(joinDto.getEmail())
                            .password(joinDto.getPassword())
                            .build();

                    return userRepository.save(user)
                            .map(savedUser -> ApiResponse.<UserResponseDto>builder()
                                    .success(true)
                                    .message("회원가입 성공")
                                    .data(new UserResponseDto(savedUser.getEmail()))
                                    .statusCode(200)
                                    .build())
                            .onErrorResume(error -> {
                                log.info("### Fail Join" + error.getMessage());
                                return Mono.just(ApiResponse.<UserResponseDto>builder()
                                        .success(false)
                                        .message("회원 가입에 실패하였습니다.")
                                        .statusCode(500)
                                        .build());
                            });
                });
    }

    public Mono<ApiResponse<UserResponseDto>> login(LoginDto loginDto) {
        return userRepository.existsUserByEmail(loginDto.getEmail())
                .flatMap(isExists -> {
                    if (!isExists) {
                        return Mono.just(ApiResponse.<UserResponseDto>builder()
                                .success(false)
                                .message("아이디 또는 비밀번호가 올바르지 않습니다.")
                                .statusCode(500)
                                .build());
                    }

                    return userRepository.findByEmailAndPassword(loginDto.getEmail(), loginDto.getPassword())
                            .flatMap(user -> {
                                if (user == null) {
                                    return Mono.just(ApiResponse.<UserResponseDto>builder()
                                            .success(false)
                                            .message("아이디 또는 비밀번호가 올바르지 않습니다.")
                                            .statusCode(401)
                                            .build());
                                }

                                return Mono.just(ApiResponse.<UserResponseDto>builder()
                                        .success(true)
                                        .data(new UserResponseDto(user.getEmail()))
                                        .message("로그인 성공")
                                        .statusCode(200)
                                        .build());
                            })
                            .switchIfEmpty(Mono.just(ApiResponse.<UserResponseDto>builder()
                                    .success(false)
                                    .message("아이디 또는 비밀번호가 올바르지 않습니다.")
                                    .statusCode(401)
                                    .build()))
                            .onErrorResume(e -> {
                                log.error("### 로그인 중 오류 발생: {}", e.getMessage());
                                return Mono.just(ApiResponse.<UserResponseDto>builder()
                                        .success(false)
                                        .message("로그인 처리 중 오류가 발생했습니다.")
                                        .statusCode(500)
                                        .build());
                            });

                });
    }

}