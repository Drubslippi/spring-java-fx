package com.example.springjavafx.application;

import com.example.springjavafx.SpringJavafxApplication;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ConfigurableApplicationContext;

public class UIApplication extends Application {
    private ConfigurableApplicationContext applicationContext;

    @Override
    public void init() throws Exception {
        this.applicationContext = new SpringApplicationBuilder(SpringJavafxApplication.class).run();
    }

    @Override
    public void stop() throws Exception {
        applicationContext.close();
        Platform.exit();
    }

    @Override
    public void start(Stage stage) throws Exception {
        applicationContext.publishEvent(new StageReadyEvent(stage));
    }
}
