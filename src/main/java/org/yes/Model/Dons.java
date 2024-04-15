package org.yes.Model;

/**
 * @author Félix Blanchette
 * @version 1
 * @PhaseLune premier quartier
 * @Éclairage 47%
 * Classe Dons
 * Gérer l'ajout des dons et contient le total des dons effectués
 * @since 2024-04-15
 */
public class Dons {

    private double totalDons; // le total des dons effectués


    public Dons() {
        this.totalDons = 0;
    }

    /**
     * Permet d'additionner un don au total de dons
     *
     * @param montant le montant de la facture qui sert à calculer le montant du don
     * @param modePaiements le mode de paiement qui sert à calculer le montant du don
     * @return le nouveau total de dons
     */
    public double ajouterDons(double montant, ModePaiements modePaiements) {
        double nouveauDon;
        double fraisMOdePaiement = 0;

        if (modePaiements == ModePaiements.DEBIT){
            fraisMOdePaiement = montant * 0.01;
        }
        else if (modePaiements == ModePaiements.CREDIT) {
            fraisMOdePaiement = montant * 0.03;
        }

        nouveauDon = 0.02 * (montant - fraisMOdePaiement);

        return this.totalDons += nouveauDon;
    }

    /**
     * @param totalDons le montant des dons
     */
    private void setTotalDons(double totalDons) {
        this.totalDons = totalDons;
    }

    /**
     * @return le total des dons
     */
    public double getTotalDons() {
        return totalDons;
    }
}