package com.example.springjavafx.controller;

import com.example.springjavafx.domain.UrlEntity;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.Map;

public class UIControllerNew {

    @FXML
    private SplitPane splitPane;

    @FXML
    private GridPane nameColumnGrid;

    private ObservableMap<String, UrlEntity> urlAvailabilityMap;

    public UIControllerNew(ObservableMap<String, UrlEntity> urlAvailabilityMap) {
        this.urlAvailabilityMap = urlAvailabilityMap;
    }

    @FXML
    public void initialize() {

        System.out.println("initializing");

        int i = 0;
        for (Map.Entry entry : urlAvailabilityMap.entrySet()) {
            var urlValue = new Text(((UrlEntity) entry.getValue()).getUrlValue());
            var urlStatus = new Text(((UrlEntity) entry.getValue()).getUrlStatus());

            urlStatus.textProperty().bind(((UrlEntity) entry.getValue()).urlStatusProperty());

            nameColumnGrid.add(urlValue, 0, i);
            nameColumnGrid.add(urlStatus, 1, i);
            i++;
        }
    }

}
