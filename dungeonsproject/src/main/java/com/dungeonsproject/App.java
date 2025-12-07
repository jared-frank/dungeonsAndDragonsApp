package com.dungeonsproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import com.dungeonsproject.characterdata.CharacterStorage;
import com.dungeonsproject.gamecontext.GameContext;

public class App extends Application {

    private static Scene scene;

    private static CharacterStorage characterStorage = new CharacterStorage();

    GameContext context = GameContext.getInstance();

    @Override
    public void start(Stage stage) throws IOException { 
        if (characterStorage.characterFileExists()) {
            scene = new Scene(loadFXML("characterSelect"), 1280, 960);
            stage.setScene(scene);
            stage.show();
        } else {
            scene = new Scene(loadFXML("characterCreation"), 1280, 960);
            stage.setScene(scene);
            stage.show();
        }
        
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

   
}