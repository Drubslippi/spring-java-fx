package com.example.springjavafx.application;

import com.example.springjavafx.controller.UIController;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lombok.SneakyThrows;
import net.rgielen.fxweaver.core.FxWeaver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class StageInitializer implements ApplicationListener<StageReadyEvent> {
    private final FxWeaver fxWeaver;

    @Autowired
    public StageInitializer(FxWeaver fxWeaver) {
        this.fxWeaver = fxWeaver;
    }

    @SneakyThrows
    @Override
    public void onApplicationEvent(StageReadyEvent event)  {
        Stage stage = event.stage;
        stage.setScene(new Scene(fxWeaver.loadView(UIController.class), 320, 240));
        stage.setTitle("Hello!");
        stage.show();
    }
}
