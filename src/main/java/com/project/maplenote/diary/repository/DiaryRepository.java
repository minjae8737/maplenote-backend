package com.project.maplenote.diary.repository;

import com.project.maplenote.diary.domain.DailyRecord;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiaryRepository extends ReactiveMongoRepository<DailyRecord, String> {
}
