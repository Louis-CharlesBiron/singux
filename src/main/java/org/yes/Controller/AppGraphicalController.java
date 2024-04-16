package org.yes.Controller;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import org.yes.Model.ModePaiements;

/**
 * @Author Maek Lorman
 * Classe AppGraphicalController
 * cette classe s'occupe d'aller chercher des informations importantes pour la facture
 */
public class AppGraphicalController {

    @FXML
    private TextField nomAcheteur;
    @FXML
    private TextField montantSansTaxe;
    @FXML
    private TextField montantTaxes;
    @FXML
    private RadioButton radioDebit;
    @FXML
    private RadioButton radioCredit;
    @FXML
    private RadioButton radioArgent;
    @FXML
    private Button creer;
    @FXML
    private Button annuler;


    @FXML
    private void initialize() {





        // Création facture
        creer.setOnMouseClicked(event->{
            System.out.println(getNomAcheteur());
            System.out.println("CRÉER FACTURE FACOTREY LOLOLOLOLOLOLLOLOLOLOLOLOLLOLOLOLOLOLOLLOLOLOLOLOLOLLOLOLOLOLOLOLLOLOLOLOLOLOLLOLOLOLOLOLOLLOLOLOLOLOLOLLOLOLOLOLOLOLLOLOLOLOLOLOLLOLOLOLOLOLOLLOLOLOLOLOLOLLOLOLOLOLOLOLLOLOLOLOLOLOLLOLOLOLOLOLOLLOLOLOLOLOLOLLOLOLOLOLOLOLLOLOLOLOLOLOLLOLOLOLOLOLOLLOLOLOLOLOLOLLOLOLOLOLOLOLLOLOLOLOLOLOLLOLOLOLOLOLOLLOLOLOLOLOLOLLOLOLOLOLOLOLLOLOLOLOLOLOLLOLOLOLOLOLOLLOLOLOLOLOLOLLOLOLOLOLOLOLLOLOLOLOLOLOLLOLOLOLOLOLOLLOLOLOLOLOLOLLOLOLOLOLOLOLLOLOLOLOLOLOLLOLOLOLOLOLOLLOLOLOLOLOLOLLOLOLOLOLOLOLLOLOLOLOLOLOLLOLOLOLOLOLOLLOLOLOLOLOLOLLOLOLOLOLOLOLLOLOLOLOLOLOLLOLOLOLOLOLOLLOLOLOLOLOLOLLOLOLOLOLOLOLLOLOLOLOLOLOLLOLOLOLOLOLOLLOLOLOLOLOLOLLOLOLOLOLOLOLLOLOLOLOLOLOLLOLOLOLOLOLOLLOLOLOLOLOLOLLOLOLOLOLOLOLLOLOLOLOLOLOLLOLOLOLOLOLOLLOLOLOLOLOLOLLOLOLOLOLOLOLLOLOLOLOLOLOLLOLOLOLOLOLOLLOLOLOLOLOLOLLOLOLOLOLOLOLLOLOLOLOLOLOLLOLOLOLOLOLOLLOLOLOLOLOLOLLOLOLOLOLOLOLLOLOLOLOLOLOLLOLOLOLOLOLOLLOLOLOLOLOLOLLOLOLOLOLOLOLLOLOLOLOLOLOLLOLOLOLOLOLOLLOLOLOLOLOLOLLOLOLOLOLOLOLLOLOLOLOLOLOLLOLOLOLOLOLOLLOLOLOLOLOLOLLOLOLOLOLOLOLLOLOLOLOLOLOLLOLOLOLOLOLOLLOLOLOLOLOLOLLOLOLOLOLOLOLLOLOLOLOLOLOLLOLOLOLOLOLOLLOLOLOLOLOLOLLOLOLOLOLOLOLLOLOLOLOLOLOLLOLOLOLOLOLOLLOLOLOLOLOLOLLOLOLOLOLOLOLLOLOLOLOLOLOLLOLOLOLOLOLOLLOLOLOLOLOLOLLOLOLOLOLOLOLLOLOLOLOLOLOLLOLOLOLOLOLOLLOLOLOLOLOLOLLOLOLOLOLOLOLLOLOLOLOLOLOLLOLOLOLOLOLOLLOLOLOLOLOLOLLOLOLOLOLOLOLLOLOLOLOLOLOLLOLOLOLOLOLOLLOLOLOLOLOLOLLOLOLOLOLOLOLLOLOLOLOLOLOLLOLOLOLOLOLOLLOLOLOLOLOLOLLOLOLOLOLOLOLLOLOLOLOLOLOLLOLOLOLOLOLOLLOLOLOLOLOLOLLOLOLOLOLOLOL");

        });

        // Annuler facture jar?? (on devrait pt plus faire jar reset)
        annuler.setOnMouseClicked(event -> {

        });


    }


    /**
     * @return le nom de l'acheteur
     */
    private String getNomAcheteur() {
        return nomAcheteur.textProperty().getValue();
    }

    /**
     * @return -> le montant de l'achat sans les taxes et dons
     */
    private int getMontant() {
        return 10001000;
    }

    /**
     * va chercher le mode de paiement coché par l'utilisateur
     */
    private ModePaiements getModePaiement() {
        if (radioArgent) ;
        radioCredit;
        radioDebit;
        return radioArgent.getEffectiveNodeOrientation() ? ModePaiements.ARGENT : radioCredit.getChildrenUnmodifiable() ? ModePaiements.CREDIT : radioDebit.getViewOrder();
    }

    /**
     * @return -> la valeur des taxes appliquées
     */
    private String getTaxes() {
        return //////////////
    }
}