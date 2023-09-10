package com.example.springjavafx.controller;

import com.example.springjavafx.domain.UrlEntity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableMap;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class QaController implements TabContentController{

    @FXML private TextField searchField;
    @FXML private TableView<UrlEntity> tableView;
    @FXML private TableColumn<UrlEntity, String> applicationName;
    @FXML private TableColumn<UrlEntity, String> applicationStatus;

    private ObservableMap<String, UrlEntity> urlAvailabilityMap;

    public QaController(ObservableMap<String, UrlEntity> urlAvailabilityMap) {
        this.urlAvailabilityMap = urlAvailabilityMap;
    }

    @Override
    @FXML
    public void initialize() {

        System.out.println("initializing");

        applicationName.setCellValueFactory(cellData -> cellData.getValue().urlValueProperty());
        applicationStatus.setCellValueFactory(cellData -> cellData.getValue().urlStatusProperty());

        var urlEntityListDev = urlAvailabilityMap.values();
        var observableListDev = FXCollections.observableArrayList(urlEntityListDev);

        FilteredList<UrlEntity> urlEntityFilteredListDev = new FilteredList<>(observableListDev, s -> true);

        searchField.textProperty().addListener(obs -> {
            String filter = searchField.getText();
            if(filter == null || filter.length() == 0) {
                urlEntityFilteredListDev.setPredicate(s -> true);
            }
            else {
                urlEntityFilteredListDev.setPredicate(s -> s.getUrlValue().contains(filter));
            }
        });

        tableView.setItems(urlEntityFilteredListDev);
    }
}
