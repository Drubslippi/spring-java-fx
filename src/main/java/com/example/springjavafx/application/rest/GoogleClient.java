package com.example.springjavafx.application.rest;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.HashMap;
import java.util.Map;

@Service
public class GoogleClient {

    private final WebClient webClient;
    private Map<String, Boolean> urlAvailabilityMap = new HashMap<>();

    private void startUrlAvailabilityMap() {
        urlAvailabilityMap.put("Google", false);
    }

    public Map<String, Boolean> getUrlAvailabilityMap() {
        return this.urlAvailabilityMap;
    }

    public GoogleClient(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://www.google.com/").build();
    }

    @Scheduled(fixedDelay = 10000)
    public String someRestCall() {
        var response = this.webClient.get().retrieve().bodyToMono(String.class);
        System.out.println(String.format("Response obtained: %s", response.block()));
        return response.block();
    }
}
