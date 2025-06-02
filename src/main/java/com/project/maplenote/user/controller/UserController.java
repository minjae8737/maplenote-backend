package com.project.maplenote.user.controller;

import com.project.maplenote.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/u")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    @GetMapping("/join")
    public String showJoinPage() {
        return "user/join";
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "user/login";
    }
}
