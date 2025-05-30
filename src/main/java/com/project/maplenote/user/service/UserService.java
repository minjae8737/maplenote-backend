package com.project.maplenote.user.service;

import com.project.maplenote.user.domain.LoginDto;
import com.project.maplenote.user.domain.User;
import com.project.maplenote.user.domain.UserResponseDto;
import com.project.maplenote.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    public Mono<ResponseEntity<UserResponseDto>> join(LoginDto loginDto) {
        return userRepository.save(new User(loginDto))
                .doOnSuccess(user -> log.info("### Success Join " + user.toString()))
                .map(user -> ResponseEntity.ok(new UserResponseDto(user.getEmail())))
                .onErrorResume(error -> {
                    log.info("### Fail Join" + error.getMessage());
                    return Mono.just(ResponseEntity
                            .badRequest()
                            .body(new UserResponseDto("가입 실패: " + error.getMessage())));
                });
    }


}
