package org.yes.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class AppGraphicalController {

    @FXML
    private TextField test;

    @FXML
    private Label test2;
    @FXML
    private Label pt;

    // private Mot mot = new Mot("mamburg");
    // private Joueur singe = new Joueur();


    @FXML
    void clickTest(MouseEvent event) {
        System.out.println("SINGE!!!!+sd+as+");

    }

    @FXML
    private void initialize() {

        test.setOnKeyPressed(event -> {

        });

        test.textProperty().addListener((o, oldV, newV) -> {


        });


    }

    private String getAcheteur() {
        return "Bobby Joe!";
    }

    private int getMontant() {
        return 10001000;
    }

    private void getModePaiement() {

    }

    private double getTaxes() {
        return 10001000;
    }
}