package com.example.springjavafx.application.rest;

import com.example.springjavafx.domain.UrlEntity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableMap;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.*;

import static com.example.springjavafx.domain.MappedUrls.*;

@Service
public class ClientService {

    private final WebClient webClient;

    private Map<String, UrlEntity> urlAvailabilityMap = new HashMap<>();

    private ObservableMap<String, UrlEntity> observableMap = FXCollections.observableMap(urlAvailabilityMap);

    private void startUrlAvailabilityList() {
        for (Map.Entry entry : getMappedUrls().entrySet()) {
            observableMap.put(
                    (String) entry.getKey(),
                    (UrlEntity) entry.getValue()
            );
        }
    }

    public ObservableMap<String, UrlEntity> getUrlAvailabilityMap() {
        return this.observableMap;
    }

    public ClientService(WebClient.Builder webClientBuilder) {
        startUrlAvailabilityList();
        this.webClient = webClientBuilder.build();
    }

    @Scheduled(initialDelay = 10000, fixedDelay = 60000)
    public String statusUpdate() {
        for (Map.Entry entry : getMappedUrls().entrySet()) {
            var url = ((UrlEntity) entry.getValue()).getUrlValue();

            var response = this.webClient.get().uri(url).retrieve().toBodilessEntity();
            var responseStatusCode = Objects.requireNonNull(response.block()).getStatusCode().value();

            System.out.println(String.format("Response obtained: %s", responseStatusCode));
            observableMap.get((String) entry.getKey()).setUrlStatus(String.valueOf(responseStatusCode));
        }

        return "success";
    }
}
