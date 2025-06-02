package com.project.maplenote.user.controller;


import com.project.maplenote.global.domain.ApiResponse;
import com.project.maplenote.user.domain.JoinDto;
import com.project.maplenote.user.domain.LoginDto;
import com.project.maplenote.user.domain.UserResponseDto;
import com.project.maplenote.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
@Slf4j
public class UserApiController {

    private final UserService userService;


    @PostMapping("/join")
    public Mono<ApiResponse<UserResponseDto>> join(@ModelAttribute JoinDto joinDto) {
        return userService.join(joinDto);
    }

    @PostMapping("/login")
    public Mono<ApiResponse<UserResponseDto>> join(@ModelAttribute LoginDto loginDto) {
//        log.info("email:{} pass:{}", loginDto.getEmail(), loginDto.getPassword());
        return userService.login(loginDto);
    }

}
