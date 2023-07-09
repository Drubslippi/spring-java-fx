package com.example.springjavafx;

import com.example.springjavafx.application.UIApplication;
import javafx.application.Application;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class SpringJavafxApplication {

    public static void main(String[] args) {
        Application.launch(UIApplication.class, args);
    }

}
