package com.dungeonsproject.controller;

import java.io.IOException;

import com.dungeonsproject.App;

import javafx.fxml.FXML;

public class dedController {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("gameplayTabs");
    }
}