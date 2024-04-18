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
    Dons dons = new Dons();
    @FXML
    public Text montantDons;
    @FXML
    private TextField nomAcheteur;
    @FXML
    private TextField montantSansTaxes;
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

        nomAcheteur.setOnKeyPressed(event -> {});
        montantSansTaxes.setOnKeyPressed(event -> {});
        taxes.setOnKeyPressed(event -> {});
        argent.setOnMouseClicked(event -> {});
        debit.setOnMouseClicked(event -> {});
        credit.setOnMouseClicked(event -> {});


        // boutton creer facture
        creer.setOnMouseClicked(event->{
            String nomAcheteur = getNomAcheteur();
            double montantSansTaxes = getMontantSansTaxes();
            double taxes = getMontantTaxes();
            ModePaiements modePaiement = getModePaiement();

                    System.out.println(nomAcheteur);// TODELETE
                    System.out.println(montantSansTaxes);// TODELETE
                    System.out.println(taxes);// TODELETE
                    System.out.println(modePaiement);// TODELETE
                    System.out.println(dons.getTotalDons());// TODELETE

            if (nomAcheteur == null) {
                System.out.println("display erreur nomAcheteur invalide");
            }
            if (modePaiement == null) {
                System.out.println("display erreur modePaiement invalide");
            }
            if (montantSansTaxes == -1) {
                System.out.println("display erreur montantSansTaxes invalide");
            }
            if (taxes == -1) {
                System.out.println("display erreur taxes invalide");

            }

            if (nomAcheteur != null && modePaiement != null && montantSansTaxes != -1 && taxes != -1) {
                facturesFactory.build(nomAcheteur, montantSansTaxes, modePaiement, taxes); // création d'une facture
                afficherDons(dons.ajouterDons(montantSansTaxes+taxes, modePaiement)); // ajout et affichage des dons
            }
        });

        // réinitialise tous les champs
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
        montantSansTaxes.textProperty().setValue(montant);
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
        return nom.matches("^[a-zA-ZÀ-ö -]+$") ? nom : null;
    }

    /**
     * @return -> le montant de l'achat sans les taxes et dons ou -1 si invalide
     */
    private double getMontantSansTaxes() {
        return Facture.verificationTotalSansTaxes(montantSansTaxes.textProperty().getValue());
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

    private void afficherMontantTotal() {
        montantTotal.textProperty().setValue("");
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
    void afficherDons(double montant){
        montantDons.setText("Total: " + montant + "$");
    }
}