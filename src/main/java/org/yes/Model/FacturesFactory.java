package org.yes.Model;

public class FacturesFactory implements IFacture {


    @Override
    public Facture build(String nomClient, double totalSansTaxes, ModePaiements modePaiement, double montantTaxes) {
        return new Facture(nomClient, totalSansTaxes, modePaiement, montantTaxes);
    }
}
