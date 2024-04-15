package org.yes.Model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DonsTest {
    Dons don;

    @Test
    void ModePaiementArgent_AjouterDons() {
        //Acteur
        don = new Dons();
        double resultat;
        double attendu = 2;
        //Action
        don.ajouterDons(100, ModePaiements.ARGENT);
        resultat = don.getTotalDons();
        //Assertion
        assertEquals(resultat, attendu);
    }

    @Test
    void ModePaiementDebit_AjouterDons() {
        //Acteur
        don = new Dons();
        double resultat;
        double attendu = 1.98;
        //Action
        don.ajouterDons(100, ModePaiements.DEBIT);
        resultat = don.getTotalDons();
        //Assertion
        assertEquals(resultat, attendu);
    }

    @Test
    void ModePaiementCredit_AjouterDons() {
        //Acteur
        don = new Dons();
        double resultat;
        double attendu = 1.94;
        //Action
        don.ajouterDons(100, ModePaiements.CREDIT);
        resultat = don.getTotalDons();
        //Assertion
        assertEquals(resultat, attendu);
    }
}