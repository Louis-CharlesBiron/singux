package org.yes.Model;

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

    public Facture(String nomClient, double totalSansTaxes, Enum modePaiement, double montantTaxes) {
        this.nomClient = nomClient;
        this.totalSansTaxes = totalSansTaxes;
        this.modePaiement = modePaiement;
        this.montantTaxes = montantTaxes;
    }

    public void setnomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public void setTotalSansTaxes(double totalSansTaxes) {
        this.totalSansTaxes = totalSansTaxes;
    }

    public void setModePaiement(Enum modePaiement) {
        this.modePaiement = modePaiement;
    }

    public void setTaxes(double montantTaxes) {
        this.montantTaxes = montantTaxes;
    }

    public String getnomClient() {
        return nomClient;
    }

    public double getTotalSansTaxes() {
        return totalSansTaxes;
    }

    public Enum getModePaiement() {
        return modePaiement;
    }

    public double getTaxes() {
        return montantTaxes;
    }
}
