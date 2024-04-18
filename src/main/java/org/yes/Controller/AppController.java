package org.yes.Controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

/*
La classe AppController permet de controller les informations reçus par
le modèle graphique ainsi que les actions qui seront disponibles sur L'application.
*/
public class AppController extends Application {

    /**
     * Cette méthode permet de créer le stage de l'application. Cela permet de bien construire, avec l'aide de
     * AppGraphicalController, le visuelle de l'applications et les variables nécessaire a celui-ci.
     *
     * @param stage primaire de cette application, sur laquelle
     *              La scène de l’application peut être définie.
     *              Les applications peuvent créer d’autres stages, si nécessaire, mais elles ne seront pas des
     *              stages primaires.
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Shiné");
        stage.setAlwaysOnTop(true);
        stage.setScene(new Scene(new FXMLLoader(getClass().getResource("/View/creationFacture.fxml")).load()));
        stage.show();
    }

    /**
     * Cette méthode permet le lancement du controller de l'application.
     * Elle permet un contrôle concrèt et éfficace de l'application et permet donc un
     * donctionnement sans accros.
     *
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }

}