package com.project.maplenote.user.repository;

import com.project.maplenote.user.domain.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface UserRepository extends ReactiveMongoRepository<User, String> {
    Mono<Boolean> existsUserByEmail(String email);

    Mono<User> findByEmailAndPassword(String email, String password);
}
