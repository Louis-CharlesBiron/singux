package org.yes.Model;

public interface IFacture {
    Facture build(String nomClient, double totalSansTaxes, ModePaiements modePaiement, double montantTaxes);

}
