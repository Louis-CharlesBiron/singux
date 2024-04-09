package org.yes.Model;

public class Facture {
    private String nom;
    private double totalSansTaxes;
    private Enum modePaiement; // TODO

    private Taxes taxes;

    public Facture(String nom, double totalSansTaxes, Enum modePaiement, Taxes taxes) {
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

    public Taxes getTaxes() {
        return taxes;
    }
}
