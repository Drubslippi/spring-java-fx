package com.example.springjavafx.controller;

import com.example.springjavafx.application.rest.GoogleClient;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.Map;

public class UIController {

    private Map<String, HttpStatus> urlAvailabilityMap;

    @FXML
    private Label welcomeText;

    @FXML
    private Button helloButton;

    @FXML
    public void initialize() {
        System.out.println("initializing");
    }

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText(String.format("Googles' status: %s", urlAvailabilityMap.get("Google")));
        helloButton.setText("I was pressed!");
    }

    public void setUrlAvailabilityMap(Map<String, HttpStatus> urlAvailabilityMap) {
        this.urlAvailabilityMap = urlAvailabilityMap;
    }
}
