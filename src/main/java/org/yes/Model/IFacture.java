package org.yes.Model;

public interface IFacture {
    void build(String nomClient, String totalSansTaxes, String modePaiement, String montantTaxes);

}
