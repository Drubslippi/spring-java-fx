package com.example.springjavafx.application;

import com.example.springjavafx.SpringJavafxApplication;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lombok.SneakyThrows;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class StageInitializer implements ApplicationListener<StageReadyEvent> {

    @SneakyThrows
    @Override
    public void onApplicationEvent(StageReadyEvent event)  {
        FXMLLoader fxmlLoader = new FXMLLoader(SpringJavafxApplication.class.getResource("UIController.fxml"));
        Stage stage = event.stage;
        stage.setScene(new Scene(fxmlLoader.load(), 320, 240));
        stage.setTitle("Hello!");
        stage.show();
    }
}
