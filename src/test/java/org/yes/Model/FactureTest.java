package org.yes.Model;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import javax.swing.*;
// en francais
// nom var significatif
// séparation acteur, action et assertion
// etantDonneMontantSansTaxe_quand_alors
//

class FactureTest {


    Facture facture1;

    @BeforeEach
    void setUp() {
        facture1 = new Facture();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1000", "0.000", "10.0", "-10.00", "-100"})
    void etantDonneMontantSansTaxeMauvaisFormat_quandCréerOuModifierFacture_alorsErreur(String montantInvalide) {// ACTEUR
        //ACTION + ASSERTON
        assertThrows(IllegalArgumentException.class, ()->{
            facture1.setTotalSansTaxes(montantInvalide);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"1000sadad", "0.000---", "10.0e", "-10,00", "--100", "+100", "", "lol"})
    void etantDonneMontantSansTaxeMauvaisCharactèresInvalides_quandCréerOuModifierFacture_alorsErreur(String montantInvalide) {// ACTEUR
        //ACTION + ASSERTON
        assertThrows(IllegalArgumentException.class, ()->{
            facture1.setTotalSansTaxes(montantInvalide);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"10.00", "1000.00", ".99", "0.00"})
    void etantDonneMontantSansTaxeValie_quandCréerOuModifierFacture_alorsErreur(String montantValide) {// ACTEUR
        //ACTION
        facture1.setTotalSansTaxes(montantValide);

        //ASSERTION
        assertEquals(Double.parseDouble(montantValide), facture1.getTotalSansTaxes());
    }


}