package org.yes.Model;

public class Facture {
    private String nom;
    private double totalSansTaxes;
    private Enum modePaiement; // TODO

    private double taxes;

    public Facture(String nom, double totalSansTaxes, Enum modePaiement, double taxes) {
        this.nom = nom;
        this.totalSansTaxes = totalSansTaxes;
        this.modePaiement = modePaiement;
        this.taxes = taxes;
    }

    public String getNom() {
        return nom;
    }

    public double getTotalSansTaxes() {
        return totalSansTaxes;
    }

    public Enum getModePaiement() {
        return modePaiement;
    }

    public double getTaxes() {
        return taxes;
    }
}
