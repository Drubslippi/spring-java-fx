package com.example.springjavafx.controller;

import com.example.springjavafx.SpringJavafxApplication;
import com.example.springjavafx.domain.EnvironmentsEnum;
import com.example.springjavafx.domain.UrlEntity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableMap;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;

import java.io.IOException;
import java.util.stream.Collectors;

public class AppStatusGUI {

    @FXML private Tab devTab;
    @FXML private Tab qaTab;
    @FXML private Tab uatTab;
    @FXML private Tab prdTab;

    private ObservableMap<String, UrlEntity> urlAvailabilityMap;

    public AppStatusGUI(ObservableMap<String, UrlEntity> urlAvailabilityMap) {
        this.urlAvailabilityMap = urlAvailabilityMap;
    }

    @FXML
    public void initialize() {
        setTabContent(devTab, new DevController(getUrlAvailabilityMapForEnv(EnvironmentsEnum.DEV)));
        setTabContent(qaTab, new QaController(getUrlAvailabilityMapForEnv(EnvironmentsEnum.QA)));
        setTabContent(uatTab, new UatController(getUrlAvailabilityMapForEnv(EnvironmentsEnum.UAT)));
        setTabContent(prdTab, new PrdController(getUrlAvailabilityMapForEnv(EnvironmentsEnum.PRD)));
    }

    private void setTabContent(Tab tab, TabContentController controller) {
        try {
            FXMLLoader loader = new FXMLLoader(SpringJavafxApplication.class.getResource("Content.fxml"));
            loader.setController(controller);
            tab.setContent(loader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private ObservableMap<String, UrlEntity> getUrlAvailabilityMapForEnv(EnvironmentsEnum env) {
        return FXCollections.observableMap(
                urlAvailabilityMap.entrySet()
                .stream()
                .filter(entry -> entry.getValue().getApplicationEnv().equals(env.getLabel()))
                .collect(Collectors.toMap(entry -> entry.getKey(), entry -> entry.getValue()))
        );
    }

}
