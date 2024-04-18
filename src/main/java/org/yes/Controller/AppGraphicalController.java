package org.yes.Controller;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import org.yes.Model.Dons;
import org.yes.Model.Facture;
import org.yes.Model.FacturesFactory;
import org.yes.Model.ModePaiements;

/**
 * @Author Maek Lorman
 * Classe AppGraphicalController
 * cette classe s'occupe d'aller chercher des informations importantes pour la facture
 */
public class AppGraphicalController extends AppController{

    FacturesFactory facturesFactory = new FacturesFactory();
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
    private Button rafraichir;
    @FXML
    private Text montantTotal;



    @FXML
    private void initialize() {
        // Création facture
        creer.setOnMouseClicked(event->{
            String nomAcheteur = getNomAcheteur();
            double montantSansTaxes = getMontantSansTaxes(),
                   montantTaxes = getMontantTaxes();
            ModePaiements modePaiement = getModePaiement();
                    System.out.println(nomAcheteur);
                    System.out.println(montantSansTaxes);
                    System.out.println(montantTaxes);
                    System.out.println(modePaiement);
                    System.out.println(getMontantDons());

            if (nomAcheteur == null) {
                System.out.println("display erreur nomAcheteur invalide");
            }
            if (modePaiement == null) {
                System.out.println("display erreur modePaiement invalide");
            }
            if (montantSansTaxes == -1) {
                System.out.println("display erreur montantSansTaxes invalide");
            }
            if (montantTaxes == -1) {
                System.out.println("display erreur montantTaxes invalide");

            }

            if (nomAcheteur != null && modePaiement != null && montantSansTaxes != -1 && montantTaxes != -1) facturesFactory.build(nomAcheteur, montantSansTaxes, modePaiement, montantTaxes);
        });

        rafraichir.setOnMouseClicked(event -> {
            setNomAcheteur("");
            setMontantTaxes("");
            setMontantSansTaxes("");
            setModePaiement("");
        });
    }


    private void setNomAcheteur(String nom) {
        nomAcheteur.textProperty().setValue(nom);
    }

    private void setMontantSansTaxes(String montant) {
        montantSansTaxe.textProperty().setValue(montant);
    }

    private void setMontantTaxes(String montant) {
        taxes.textProperty().setValue(montant);
    }

    private void setModePaiement(String modePaiement) {
        if (modePaiement == "argent") argent.setSelected(true);
        else if (modePaiement == "credit") credit.setSelected(true);
        else if (modePaiement == "debit") debit.setSelected(true);
        else {
            argent.setSelected(false);
            credit.setSelected(false);
            debit.setSelected(false);
        }
    }

    /**
     * @return le nom de l'acheteur ou null si invalide
     */
    private String getNomAcheteur() {
        String nom = nomAcheteur.textProperty().getValue();
        return nom.matches("^[a-zA-ZÀ-ö\s]+$") ? nom : null;
    }

    /**
     * @return -> le montant de l'achat sans les taxes et dons ou -1 si invalide
     */
    private double getMontantSansTaxes() {
        return Facture.verificationTotalSansTaxes(montantSansTaxe.textProperty().getValue());
    }

    /**
     * va chercher le mode de paiement coché par l'utilisateur ou null si invalide
     */
    private ModePaiements getModePaiement() {
        ModePaiements modePaiement;
        try {
            modePaiement = ModePaiements.valueOf(argent.isSelected() ? argent.getId() : credit.isSelected() ? credit.getId() : debit.isSelected() ? debit.getId() : "");
        } catch (Exception e) {
            modePaiement = null;
        }
        return modePaiement;
    }

    /**
     * @return -> la valeur des taxes appliquées ou -1 si invalide
     */
    private double getMontantTaxes() {
        return Facture.verificationTotalSansTaxes(taxes.textProperty().getValue());
    }
    private String getMontantDons() {// PAS BON
        return montantDons.textProperty().getValue();
    }

    private void setMontantTotal() {

    }

    //private void setMontantTotal() {
    //    String montantString;
    //    Double montantDouble;
    //    montantDouble = Double.valueOf(getMontantSansTaxes() + getTaxes());
    //    montantString = String.valueOf(montantDouble);
//
    //    this.montantTotal.setText(montantString);
//
    //    // montantTotal.setOnKeyPressed(keyEvent -> this.montantTotal.setText(montantString));
    //}
    //private boolean textRempliPourMontantTotal(){
    //    boolean taxesRempli = false;
    //    boolean nomAcheteurRempli = false;
    //    boolean montantSansTaxesRempli = false;
//
    //    if (getNomAcheteur() != null){
    //        nomAcheteurRempli = true;
    //    }
    //    if (getTaxes() != null){
    //        taxesRempli = true;
    //    }
    //    if (getMontantSansTaxes() != null){
    //        montantSansTaxesRempli = true;
    //    }
//
    //    if (nomAcheteurRempli && taxesRempli && montantSansTaxesRempli == true){
    //        return true;
    //    }
    //    return false;
//
    //}

    @FXML
    void AfficherDons(double montant){// PAS BON
        montantDons.setText("Total: " + montant + "$");
    }
}