package org.yes.Model;

import java.util.regex.Pattern;

/**
 * Représente une facture d'un client, peut être modifiée, accèdée et contient :
 * - le nom du client
 * - le total avant taxes (0.00$)
 * - le montant de taxes ajouté au total (0.00$)
 * - le mode de paiement employé (argent|débit|crédit)
 */
public class Facture {
    private String nomClient;
    private double totalSansTaxes;
    private ModePaiements modePaiement;
    private double montantTaxes;


    public Facture(String nomClient, double totalSansTaxes, ModePaiements modePaiement, double montantTaxes) {
        this.nomClient = nomClient;
        this.totalSansTaxes = totalSansTaxes;
        this.modePaiement = modePaiement;
        this.montantTaxes = montantTaxes;
    }

    public void setNomClient(String nomClient) {

        this.nomClient = nomClient;
    }

    public void setTotalSansTaxes(String totalSansTaxes) {
        if (Pattern.compile("^[0-9]*[.][0-9]{2}$").matcher(totalSansTaxes).find())
            this.totalSansTaxes = Double.parseDouble(totalSansTaxes);
        else throw new IllegalArgumentException("Format: 'total sans taxes' invalide");
    }

    public void setModePaiement(String modePaiement) {
        this.modePaiement = ModePaiements.valueOf(modePaiement);
    }

    public void setTaxes(String montantTaxes) {
        if (Pattern.compile("^[0-9]+[.][0-9]{2}$").matcher(montantTaxes).find())
            this.montantTaxes = Double.parseDouble(montantTaxes);
        else throw new IllegalArgumentException("Format: 'montant taxes' invalide");
    }

    public String getnomClient() {
        return nomClient;
    }

    public double getTotalSansTaxes() {
        return totalSansTaxes;
    }

    public ModePaiements getModePaiement() {
        return modePaiement;
    }

    public double getTaxes() {
        return montantTaxes;
    }
}
