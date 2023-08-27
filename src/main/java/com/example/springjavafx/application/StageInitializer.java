package com.example.springjavafx.application;

import com.example.springjavafx.SpringJavafxApplication;
import com.example.springjavafx.application.rest.ClientService;
import com.example.springjavafx.controller.AppStatusGUI;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lombok.SneakyThrows;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class StageInitializer implements ApplicationListener<StageReadyEvent> {

    private final ClientService clientService;

    public StageInitializer(ClientService clientService) {
        this.clientService = clientService;
    }

    @SneakyThrows
    @Override
    public void onApplicationEvent(StageReadyEvent event)  {
        FXMLLoader fxmlLoader = new FXMLLoader(SpringJavafxApplication.class.getResource("UIController_new.fxml"));

        AppStatusGUI controller = new AppStatusGUI(clientService.getUrlAvailabilityMap());
        fxmlLoader.setController(controller);
        Stage stage = event.stage;
        stage.setScene(new Scene(fxmlLoader.load(), 600, 480));

        StringProperty textProperty = new SimpleStringProperty("Hello, World!");
        stage.titleProperty().bind(textProperty);
        stage.show();
    }
}
