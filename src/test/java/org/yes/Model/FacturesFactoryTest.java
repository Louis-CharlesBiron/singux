package org.yes.Model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FacturesFactoryTest {

    FacturesFactory facturesFactory;

    @BeforeEach
    void setUp() {
        facturesFactory = new FacturesFactory();
    }

    @Test
    void etanDonneUtilisationDeLaFactoryPourCreerUneFacture_quandBuildDeFactureFactory_alorsRetourneUneFacture() {
        var factureTest = facturesFactory.build("nomRandom", 10, ModePaiements.DEBIT, 10);
        assertEquals(Facture.class, factureTest.getClass());
    }
}