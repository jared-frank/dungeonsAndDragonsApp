package com.dungeonsproject;

import java.io.IOException;
import javafx.fxml.FXML;

public class dedController {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("characterSheet");
    }
}