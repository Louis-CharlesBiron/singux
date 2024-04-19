package org.yes.Model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FacturesFactoryTest {

    FacturesFactory facturesFactory;

    Facture testFacture;

    @BeforeEach
    void setUp() {
        facturesFactory = new FacturesFactory();
    }

    @Test
    void etanDonneUtilisationDeLaFactoryPourCreerUneFacture_quandBuildDeFactureFactory_alorsRetourneUneFacture() {
        var factureTest = facturesFactory.build("nomRandom", 10, ModePaiements.DEBIT, 10);
        assertEquals(Facture.class, factureTest.getClass());
    }

    @Test
    void etantDonneUtilisationFactoryCreerFacture_quandBuildDeFactureFactory_alorsMemeDonneDeCreationDansFacture() {
        String nomClient = "Maek";
        double totalSansTaxes = 12.55;
        ModePaiements modePaiements = ModePaiements.ARGENT;
        double montantTaxes = 1.23;
        testFacture = facturesFactory.build(nomClient, totalSansTaxes, modePaiements, montantTaxes);

        assertEquals(nomClient, testFacture.getnomClient());
        assertEquals(totalSansTaxes, testFacture.getTotalSansTaxes());
        assertEquals(modePaiements, testFacture.getModePaiement());
        assertEquals(montantTaxes, testFacture.getTaxes());
    }
}