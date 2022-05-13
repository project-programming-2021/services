package com.onegin.language.client;

import com.onegin.language.client.dictionary.DictionaryService;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;

@SpringBootApplication
public class Application extends javafx.application.Application {

    public static DictionaryService dictionaryService;

    private static ConfigurableApplicationContext context;


    @Override
    public void start(Stage stage) throws IOException {

        context = SpringApplication.run(Application.class);
        dictionaryService = context.getBean(DictionaryService.class);

        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("gui/dictionary.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Ежовый толковый словарь");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        context.close();
    }

    public static void main(String[] args) {
        launch();
    }
}