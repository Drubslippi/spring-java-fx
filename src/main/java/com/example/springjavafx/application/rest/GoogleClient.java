package com.example.springjavafx.application.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class GoogleClient {

    private final WebClient webClient;
    private Map<String, HttpStatus> urlAvailabilityMap = new HashMap<>();

    private void startUrlAvailabilityMap() {
        urlAvailabilityMap.put("Google", HttpStatus.NOT_FOUND);
    }

    public Map<String, HttpStatus> getUrlAvailabilityMap() {
        return this.urlAvailabilityMap;
    }

    public GoogleClient(WebClient.Builder webClientBuilder) {
        startUrlAvailabilityMap();
        this.webClient = webClientBuilder.baseUrl("https://www.google.com/").build();
    }

    @Scheduled(initialDelay = 10000, fixedDelay = 60000)
    public String someRestCall() {
        var response = this.webClient.get().retrieve().toBodilessEntity();
        var responseStatusCode = Objects.requireNonNull(response.block()).getStatusCode().value();
        System.out.println(String.format("Response obtained: %s", responseStatusCode));
        urlAvailabilityMap.put("Google", HttpStatus.valueOf(responseStatusCode));
        return String.valueOf(responseStatusCode);
    }
}
