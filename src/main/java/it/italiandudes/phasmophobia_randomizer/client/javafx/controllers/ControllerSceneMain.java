package it.italiandudes.phasmophobia_randomizer.client.javafx.controllers;

import it.italiandudes.phasmophobia_randomizer.client.javafx.Client;
import javafx.fxml.FXML;

public final class ControllerSceneMain {

    //Initialize
    @FXML
    private void initialize() {
        Client.getStage().setFullScreen(false);
        Client.getStage().setMaximized(false);
        Client.getStage().setResizable(false);
    }

    // EDT
}