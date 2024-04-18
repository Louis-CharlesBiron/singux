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


    public Facture(String nomClient, double totalSansTaxes, ModePaiements modePaiement, double taxes) {
        this.nomClient = nomClient;
        this.totalSansTaxes = totalSansTaxes;
        this.modePaiement = modePaiement;
        this.montantTaxes = taxes;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public void setTotalSansTaxes(String totalSansTaxes) {
        double valeurSansTaxes = verificationFormatArgent(totalSansTaxes);
        if (valeurSansTaxes != -1) this.totalSansTaxes = valeurSansTaxes;
        else throw new IllegalArgumentException("Format: 'montant sans taxes' invalide");
    }

    public void setModePaiement(String modePaiement) {
        this.modePaiement = ModePaiements.valueOf(modePaiement);
    }

    public void setTaxes(String montantTaxes) {
        double valeurTaxes = verificationFormatArgent(montantTaxes);
        if (valeurTaxes != -1) this.montantTaxes = valeurTaxes;
        else throw new IllegalArgumentException("Format: 'taxes' invalide");
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


    public static double verificationFormatArgent(String montant) {
        return Pattern.compile("^[0-9]+[.][0-9]{2}$").matcher(montant).find() ? Double.parseDouble(montant) : -1;
    }

    @Override
    public String toString() {
        return "Facture{" +
                "nomClient='" + nomClient + '\'' +
                ", totalSansTaxes=" + totalSansTaxes +
                ", modePaiement=" + modePaiement +
                ", montantTaxes=" + montantTaxes +
                '}';
    }
}
