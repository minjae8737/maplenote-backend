package com.project.maplenote.character.service;

import reactor.core.Disposable;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.*;

class CharacterServiceTest {


    public void testMono() {
        Mono<String> stringMono = Mono.just("a");
        Disposable subscribe = stringMono.subscribe();
    }

}