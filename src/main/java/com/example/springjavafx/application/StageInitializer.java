package com.example.springjavafx.application;

import com.example.springjavafx.SpringJavafxApplication;
import com.example.springjavafx.application.rest.GoogleClient;
import com.example.springjavafx.controller.UIController;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class StageInitializer implements ApplicationListener<StageReadyEvent> {

    private final GoogleClient googleClient;

    public StageInitializer(GoogleClient googleClient) {
        this.googleClient = googleClient;
    }

    @SneakyThrows
    @Override
    public void onApplicationEvent(StageReadyEvent event)  {
        FXMLLoader fxmlLoader = new FXMLLoader(SpringJavafxApplication.class.getResource("UIController.fxml"));
        Stage stage = event.stage;
        stage.setScene(new Scene(fxmlLoader.load(), 320, 240));

        UIController uiController = fxmlLoader.getController();
        uiController.setUrlAvailabilityMap(googleClient.getUrlAvailabilityMap());

        StringProperty textProperty = new SimpleStringProperty("Hello, World!");
        stage.titleProperty().bind(textProperty);
        stage.show();
        textProperty.setValue(String.valueOf(googleClient.getUrlAvailabilityMap().get("Google")));
    }
}
