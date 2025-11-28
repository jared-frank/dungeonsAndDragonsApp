package com.dungeonsproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import com.dungeonsproject.characterdata.CharacterSheet;
import com.dungeonsproject.characterdata.CharacterStorage;

public class App extends Application {

    private static Scene scene;

    private static CharacterSheet sheet;

    private static CharacterStorage characterStorage = new CharacterStorage();

    @Override
    public void start(Stage stage) throws IOException { 
        if (characterStorage.characterFileExists()) {
            initializeCharacterSheet();
            scene = new Scene(loadFXML("characterSheet"), 640, 480);
            stage.setScene(scene);
            stage.show();
        } else {
            scene = new Scene(loadFXML("characterCreation"), 640, 480);
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

    public void initializeCharacterSheet() throws IOException {
        CharacterSheet loadedSheet = characterStorage.loadStats();
        sheet = loadedSheet;
    }

    public static void setCharacterSheet(CharacterSheet characterSheet) {
        sheet = characterSheet;
    }

    public static CharacterSheet getCharacterSheet() {
        return sheet;
    }

}