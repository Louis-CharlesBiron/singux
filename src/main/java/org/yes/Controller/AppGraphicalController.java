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

import java.text.DecimalFormat;

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
    private static final DecimalFormat decfor = new DecimalFormat("0.00");



    @FXML
    private void initialize() {

        nomAcheteur.setOnKeyPressed(event -> afficherMontantTotal());
        montantSansTaxes.setOnKeyPressed(event -> afficherMontantTotal());
        taxes.setOnKeyPressed(event -> afficherMontantTotal());
        argent.setOnMouseClicked(event -> afficherMontantTotal());
        debit.setOnMouseClicked(event -> afficherMontantTotal());
        credit.setOnMouseClicked(event -> afficherMontantTotal());


        // bouton creer facture
        creer.setOnMouseClicked(event->{
            String nomAcheteur = getNomAcheteur();
            double montantSansTaxes = getMontantSansTaxes();
            double taxes = getMontantTaxes();
            ModePaiements modePaiement = getModePaiement();

                    System.out.println("\nNom dew l'acheteur: " + nomAcheteur);// TODELETE
                    System.out.println("Montant sans taxes: " + montantSansTaxes);// TODELETE
                    System.out.println("Montant des taxes: " + taxes);// TODELETE
                    System.out.println("Mode de paiement: " + modePaiement);// TODELETE
                    System.out.println("Total des dons: " + dons.getTotalDons());// TODELETE

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

    private String verificationChamps() {
        String erreurs = "";
        if (getNomAcheteur() == null) erreurs += "nomAcheteur";
        if (getMontantTaxes() == -1) erreurs += "montantTaxes";
        if (getMontantSansTaxes() == -1) erreurs += "montantSansTaxes";
        if (getModePaiement() == null) erreurs += "modePaiement";
        return erreurs;
    }

    private void afficherMontantTotal() {
        System.out.println(verificationChamps());
            montantTotal.textProperty().setValue(
                    !verificationChamps().contains("montantTaxes") && !verificationChamps().contains("montantSansTaxes") ?
                            (getMontantSansTaxes()+getMontantTaxes())+"$"
                            : "inconnu"
            );
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
        return Facture.verificationFormatArgent(montantSansTaxes.textProperty().getValue());
    }

    /**
     * @return -> la valeur des taxes appliquées ou -1 si invalide
     */
    private double getMontantTaxes() {
        return Facture.verificationFormatArgent(taxes.textProperty().getValue());
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


    @FXML
    void afficherDons(double montant){
        montantDons.setText("Total: " + decfor.format(montant) + "$");
    }
}