package org.yes.Controller;


import org.yes.Model.ModePaiements;

/**
 * @Author Maek Lorman
 * Classe AppGraphicalController
 * cette classe s'occupe d'aller chercher des informations importantes pour la facture
 */
public class AppGraphicalController {


    /**
     * @return le nom de l'acheteur
     */
    private String getAcheteur() {
        return "Bobby Joe!";
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
        return ModePaiements.DEBIT;
    }

    /**
     * @return -> la valeur des taxes appliquées
     */
    private double getTaxes() {
        return 10001000;
    }
}