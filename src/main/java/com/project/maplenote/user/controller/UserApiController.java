package com.project.maplenote.user.controller;


import com.project.maplenote.user.domain.LoginDto;
import com.project.maplenote.user.domain.UserResponseDto;
import com.project.maplenote.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
@Slf4j
public class UserApiController {

    private final UserService userService;


    @PostMapping("/join")
    public Mono<ResponseEntity<UserResponseDto>> join(LoginDto loginDto) {
        return userService.join(loginDto);
    }

}
