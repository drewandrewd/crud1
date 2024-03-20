package com.example.testservice.service;

import com.example.testservice.model.Worker;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Slf4j
@Service
public class TestService {

    private final RestTemplate restTemplate;

    private final String url = "http://localhost:8080/api/v1";
    @PostConstruct
    public void init() {
        Worker worker = Worker.builder()
                .firstName("Andrei")
                .lastName("Melis")
                .build();

        log.info("Worker created: {}", worker);
        restTemplate.postForObject(url, worker, Void.class);
        worker = restTemplate.getForObject(url + "/" + 1L, Worker.class);
        log.info("Worker got: {}", worker);
        restTemplate.delete(url + "/" + 1L);
        worker = restTemplate.getForObject(url + "/" + 1L, Worker.class);
        log.info("Worker deleted: {}", worker);
    }
}
