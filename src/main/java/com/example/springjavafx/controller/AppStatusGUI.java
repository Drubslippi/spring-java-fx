package com.example.springjavafx.controller;

import com.example.springjavafx.domain.UrlEntity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AppStatusGUI {


    @FXML private TextField searchField;
    @FXML private TableView<UrlEntity> tableView;
    @FXML private TableColumn<UrlEntity, String> applicationName;
    @FXML private TableColumn<UrlEntity, String> applicationStatus;

    private ObservableMap<String, UrlEntity> urlAvailabilityMap;

    public AppStatusGUI(ObservableMap<String, UrlEntity> urlAvailabilityMap) {
        this.urlAvailabilityMap = urlAvailabilityMap;
    }

    @FXML
    public void initialize() {

        System.out.println("initializing");

        applicationName.setCellValueFactory(cellData -> cellData.getValue().urlValueProperty());
        applicationStatus.setCellValueFactory(cellData -> cellData.getValue().urlStatusProperty());

        var urlEntityList = urlAvailabilityMap.values();
        var observableList = FXCollections.observableArrayList(urlEntityList);

        FilteredList<UrlEntity> urlEntityFilteredList = new FilteredList<>(observableList, s -> true);

        searchField.textProperty().addListener(obs -> {
            String filter = searchField.getText();
            if(filter == null || filter.length() == 0) {
                urlEntityFilteredList.setPredicate(s -> true);
            }
            else {
                urlEntityFilteredList.setPredicate(s -> s.getUrlValue().contains(filter));
            }
        });

        tableView.setItems(urlEntityFilteredList);
    }

}
