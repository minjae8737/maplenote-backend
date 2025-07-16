package com.project.maplenote.diary.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/diary/")
@RequiredArgsConstructor
@Slf4j
public class DiaryApiController {

    @PostMapping("/")
    public void saveGridingData() {

    }


}
