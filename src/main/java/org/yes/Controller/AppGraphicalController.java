package org.yes.Controller;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import org.yes.Model.ModePaiements;

/**
 * @Author Maek Lorman
 * Classe AppGraphicalController
 * cette classe s'occupe d'aller chercher des informations importantes pour la facture
 */
public class AppGraphicalController extends AppController{
    @FXML
    public Text montantDons;
    @FXML
    private TextField nomAcheteur;
    @FXML
    private TextField montantSansTaxe;
    @FXML
    private TextField taxes;
    @FXML
    private RadioButton debit;
    @FXML
    private RadioButton credit;
    @FXML
    private RadioButton argent;
    @FXML
    private Button creer;
    @FXML
    private Button annuler;
    @FXML
    private Text montantTotal;



    @FXML
    private void initialize() {
        // Création facture
        creer.setOnMouseClicked(event->{
            System.out.println(getNomAcheteur());
            System.out.println(getMontantSansTaxes());
            System.out.println(getTaxes());
            System.out.println(getModePaiement());
            System.out.println(getMontantDons());
            System.out.println("CRÉER FACTURE FACOTREY");

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
    private String getMontantSansTaxes() {
        return montantSansTaxe.textProperty().getValue();
    }

    /**
     * va chercher le mode de paiement coché par l'utilisateur
     */
    private String getModePaiement() {
        return argent.isSelected() ? argent.getId() : credit.isSelected() ? credit.getId() : debit.isSelected() ? debit.getId() : "";
    }

    /**
     * @return -> la valeur des taxes appliquées
     */
    private String getTaxes() {
        return taxes.textProperty().getValue();
    }
    private String getMontantDons() {
        return montantDons.textProperty().getValue();
    }
    private void setMontantTotal(){
        String montant;
        montantTotal.textProperty().setValue(getTaxes() + getMontantSansTaxes());
        montantTotal.textProperty().getValue();

        double d = 100;
        montant = "" + d;
        //montantTotal.setOnKeyPressed(keyEvent -> );
    }
}