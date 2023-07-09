package com.example.springjavafx;

import com.example.springjavafx.application.UIApplication;
import javafx.application.Application;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class SpringJavafxApplication {

    public static void main(String[] args) {
        Application.launch(UIApplication.class, args);
    }

}
