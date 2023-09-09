package com.example.springjavafx.controller;

import com.example.springjavafx.domain.UrlEntity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableMap;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;

import java.io.IOException;

public class AppStatusGUI {

    @FXML private Tab devTab;
    @FXML private Tab qaTab;
    @FXML private Tab uatTab;
    @FXML private Tab prdTab;

    private ObservableMap<String, UrlEntity> urlAvailabilityMapDev;
    private ObservableMap<String, UrlEntity> urlAvailabilityMapQa;

    public AppStatusGUI(ObservableMap<String, UrlEntity> urlAvailabilityMapDev,
                        ObservableMap<String, UrlEntity> urlAvailabilityMapQa) {
        this.urlAvailabilityMapDev = urlAvailabilityMapDev;
        this.urlAvailabilityMapQa = urlAvailabilityMapQa;
    }

    @FXML
    public void initialize() {
        setTabContent(devTab, new DevController());
    }

    private void setTabContent(Tab tab, TabContentController controller) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Content.fxml"));
            loader.setController(controller);
            tab.setContent(loader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
