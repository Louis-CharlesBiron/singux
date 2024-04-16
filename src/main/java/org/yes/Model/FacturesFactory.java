package org.yes.Model;

public abstract class FacturesFactory {
    public IFacture create(String nomClient, String totalSansTaxes, String modePaiement, String montantTaxes) {
        IFacture facture = createFacture();
        facture.build(nomClient, totalSansTaxes, modePaiement, montantTaxes);
        return facture;
    }
    public abstract IFacture createFacture();
}
