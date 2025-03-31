package com.project.maplenote.global.config;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class WebClientConfig {

    @Value("${api.key}")
    private String API_KEY;

    @Value("${baseurl}")
    private String BASE_URL;

    private final int CODECS_SIZE = 100 * 1024 * 1024; // 100MB

    @Bean
    public WebClient webClient() {
        return WebClient.builder()
                .baseUrl(BASE_URL) // 기본 API URL 설정
                .defaultHeader("x-nxopen-api-key", API_KEY)
                .codecs(config -> config.defaultCodecs().maxInMemorySize(CODECS_SIZE))
                .build();
    }

}
