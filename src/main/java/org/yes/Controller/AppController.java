package org.yes.Controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class AppController extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("DIE");
        stage.setAlwaysOnTop(true);
        stage.setOpacity(0.3);
        stage.setFullScreenExitHint("singe LOLOL");
        stage.setScene(new Scene(new FXMLLoader(getClass().getResource("/View/index.fxml")).load(), 5000, 400));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}