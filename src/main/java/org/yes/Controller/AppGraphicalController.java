package org.yes.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import org.yes.Model.Dons;
import org.yes.Model.Facture;
import org.yes.Model.FacturesFactory;
import org.yes.Model.ModePaiements;

import java.text.DecimalFormat;
import java.util.*;
import java.util.regex.Pattern;

import static java.util.Map.entry;

/**
 * @Author Maek Lorman
 * Classe AppGraphicalController
 * cette classe s'occupe d'aller chercher des informations importantes pour la facture
 */
public class AppGraphicalController extends AppController{

    FacturesFactory facturesFactory = new FacturesFactory();
    Dons dons = new Dons();
    private static final DecimalFormat decfor = new DecimalFormat("0.00");

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
    private Text erreurModePaiement;
    @FXML
    private Text erreurNomAcheteur;
    @FXML
    private Text erreurMontantSansTaxes;
    @FXML
    private Text erreurTaxes;
    @FXML
    public TextField aidePlz;
    @FXML
    public TextArea aideDerien;


    private static Map<String, String> documentation = Map.ofEntries(// mots clés : texte de documentation envoyé au comptable
            entry("comment entrer un mode de paiement wtf hamburger argent cash money clams dabloons fric bread pain currency $$$$$$$$$$ happy contant content credit crédit débit debit", "À l'aide de votre dispositif de pointage virtuel, appuier sur le bouton principal présent (probablement du côté gauche) de ce dispositif vis-à-vis l'une des trois case à cochée dans la section 'Mode de Paiement' (ne pas appuier sur le X rouge dans ce cas) (voir documentation de la souris)"),
            entry("comment entrer le nom du client jar man j'arrive pas", "Dans la section 'Création d'une facture' > 'Nom de l'acheteur' entrer le nom de l'acheteur (doit contenir uniquement des lettres)"),
            entry("comment créer creer une facture creation popcorn félix blanchette je suis tanné omg c'est full long faire la doc ??????????????????????????????????????????????????????????", "Dans la section 'Création d'une facture' > tout en bas, appuier sur le bouton 'Créer', si tout les champs sont remplis, la facture se créera sans soucis"),
            entry("comment rafraichir l'application les champs trampoline tuer meurtrir données donnees", "Dans la section 'Création d'une facture' > tout en bas, appuier sur le bouton 'Rafraichir', cela videra tous les champs"),
            entry("comment quitter fermer exploser s'expulser détruire vendaliser manger immédiatement a l'aide je suis pris coincé pogner exil", "Appuier sur le 'X' rouge probablement en haut à droite, si vous êtes en mode plein écran, appuier sur la touche d'échapement de votre clavier (voir documentation du clavier pour l'emplacement)"),
            entry("je ne sais pas pourquoi utiliser la section aide", "Vous pouvez utiliser la section d'aide pour obtnir des informations sur l'application")
    );



    @FXML
    private void initialize() {

        //section aide
        aidePlz.setOnKeyReleased(event -> {
            aideDerien.textProperty().setValue(getDocumentation(aidePlz.textProperty().getValue()));
        });

        // afficher total
        montantSansTaxes.setOnKeyReleased(event -> afficherMontantTotal());
        taxes.setOnKeyReleased(event -> afficherMontantTotal());

        // bouton creer facture
        creer.setOnMouseClicked(event->{
            String nomAcheteur = getNomAcheteur();
            double montantSansTaxes = getMontantSansTaxes();
            double taxes = getMontantTaxes();
            ModePaiements modePaiement = getModePaiement();
            String erreurs = verificationChamps();

            // afficher les erreurs
            erreurNomAcheteur.textProperty().setValue(erreurs.contains("nom") ? "Le nom de l'acheteur est invalide" : "");
            erreurModePaiement.textProperty().setValue(erreurs.contains("modePaiement") ? "Le mode de paiement est invalide" : "");
            erreurMontantSansTaxes.textProperty().setValue(erreurs.contains("montantSansTaxes") ? "Le montant sans taxes est invalide" : "");
            erreurTaxes.textProperty().setValue(erreurs.contains("montantTaxes") ? "Le montant des taxes est invalide" : "");

            if (erreurs == "") {
                Facture facture = facturesFactory.build(nomAcheteur, montantSansTaxes, modePaiement, taxes); // création d'une facture
                afficherDons(dons.ajouterDons(montantSansTaxes+taxes, modePaiement)); // ajout et affichage des dons
                rafraichirPage();
                System.out.println("Nouvelle Facture Créée: "+facture.toString());
            }
        });

        // réinitialise tous les champs
        rafraichir.setOnMouseClicked(event -> rafraichirPage());
    }

    public String getDocumentation(String question) {
        String[] question_split = question.toLowerCase().split(" ");
        int question_length = question=="" ? 0 : question_split.length;
        Map<String, Integer> resultats = new HashMap<>();

        documentation.keySet().forEach(keywords->{// détermination des potentielles valeurs et de leur poids
            int valeur=0;
            for (int i = 0; i < question_length; i++) valeur = keywords.contains(question_split[i]) ? ++valeur : --valeur;
            resultats.put(keywords, valeur);
        });

        // traitements pour l'affichage affichage
        String retVal = resultats.entrySet().stream().sorted((v1, v2)->v2.getValue().compareTo(v1.getValue())).filter(x->x.getValue()>0).map(m->m.getKey()).reduce("", (a, b)-> a + documentation.get(b) + "\n\n");
        return (retVal == "" || question_length == 0) ? "Aucun résultat." : retVal;
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
            montantTotal.textProperty().setValue(
                    !verificationChamps().contains("montantTaxes") && !verificationChamps().contains("montantSansTaxes") ?
                            decfor.format(getMontantSansTaxes()+getMontantTaxes())+"$"
                            : "inconnu"
            );
    }

    private void rafraichirPage() {
        setNomAcheteur("");
        setMontantTaxes("0.00");
        setMontantSansTaxes("0.00");
        setModePaiement("");
        afficherMontantTotal();
        erreurNomAcheteur.textProperty().setValue("");
        erreurModePaiement.textProperty().setValue("");
        erreurMontantSansTaxes.textProperty().setValue("");
        erreurTaxes.textProperty().setValue("");
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
        return nom.matches("^[a-zA-ZÀ-ö -]+$") && nom.length() <= 75 ? nom : null;
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


    private void afficherDons(double montant) {
        montantDons.setText("Total: " + decfor.format(montant) + "$");
    }
}