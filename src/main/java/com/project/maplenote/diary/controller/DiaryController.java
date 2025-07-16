package com.project.maplenote.diary.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/d")
@RequiredArgsConstructor
@Slf4j
public class DiaryController {

    @GetMapping("")
    public String showDiaryPage() {
        return "diary/diary";
    }

}
