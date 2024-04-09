package org.yes.Model;

public class Dons {
    private double total = 0;

    public Dons() {
        this.total = 0;
    }
    public Dons(double total) {
        this.total = total;
    }

    public double ajouterDons(double totalNoob) {
        return this.total+=totalNoob;
    }

    public double getTotal() {
        return total;
    }
}