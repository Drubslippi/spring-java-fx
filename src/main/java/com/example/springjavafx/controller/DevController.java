package com.example.springjavafx.controller;

import com.example.springjavafx.domain.UrlEntity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableMap;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class DevController implements TabContentController{

    @FXML private TextField searchFieldDev;
    @FXML private TableView<UrlEntity> tableViewDev;
    @FXML private TableColumn<UrlEntity, String> applicationNameDev;
    @FXML private TableColumn<UrlEntity, String> applicationStatusDev;

    private ObservableMap<String, UrlEntity> urlAvailabilityMapDev;

    @Override
    @FXML
    public void initialize() {

        System.out.println("initializing");

        applicationNameDev.setCellValueFactory(cellData -> cellData.getValue().urlValueProperty());
        applicationStatusDev.setCellValueFactory(cellData -> cellData.getValue().urlStatusProperty());

        var urlEntityListDev = urlAvailabilityMapDev.values();
        var observableListDev = FXCollections.observableArrayList(urlEntityListDev);

        FilteredList<UrlEntity> urlEntityFilteredListDev = new FilteredList<>(observableListDev, s -> true);

        searchFieldDev.textProperty().addListener(obs -> {
            String filter = searchFieldDev.getText();
            if(filter == null || filter.length() == 0) {
                urlEntityFilteredListDev.setPredicate(s -> true);
            }
            else {
                urlEntityFilteredListDev.setPredicate(s -> s.getUrlValue().contains(filter));
            }
        });

        tableViewDev.setItems(urlEntityFilteredListDev);
    }
}
