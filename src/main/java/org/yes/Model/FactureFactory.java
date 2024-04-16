package org.yes.Model;

public class FactureFactory extends FacturesFactory {
    @Override
    public IFacture createFacture() {
        return new Facture();
    }
}
