package com.project.maplenote.diary.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class DailyRecord {

    private LocalDateTime date;
    private String userId;
    private List<GrindLog> grindLogs;
    private List<BossLog> bossLogs;

}
