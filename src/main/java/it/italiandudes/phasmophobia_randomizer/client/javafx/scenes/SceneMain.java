package it.italiandudes.phasmophobia_randomizer.client.javafx.scenes;

import it.italiandudes.idl.common.Logger;
import it.italiandudes.phasmophobia_randomizer.client.javafx.components.SceneController;
import it.italiandudes.phasmophobia_randomizer.client.javafx.controllers.ControllerSceneMain;
import it.italiandudes.phasmophobia_randomizer.client.javafx.utils.JFXDefs;
import it.italiandudes.phasmophobia_randomizer.utils.Defs;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public final class SceneMain {

    // Scene Generator
    @NotNull
    public static SceneController getScene() {
        try {
            FXMLLoader loader = new FXMLLoader(Defs.Resources.get(JFXDefs.Resources.FXML.FXML_MAIN));
            Parent root = loader.load();
            ControllerSceneMain controller = loader.getController();
            return new SceneController(root, controller);
        } catch (IOException e) {
            Logger.log(e);
            System.exit(-1);
            return null;
        }
    }
}
