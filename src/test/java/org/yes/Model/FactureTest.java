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
    void etantDonneMontantSansTaxeValide_quandCréerOuModifierFacture_alorsBien(String montantValide) {// ACTEUR
        //ACTION
        facture1.setTotalSansTaxes(montantValide);

        //ASSERTION
        assertEquals(Double.parseDouble(montantValide), facture1.getTotalSansTaxes());
    }

    @Test
    void etantDonneNomClientValide_quandCréerOuModifierFacture_alorsBien(){

        //Mock d'un input utilisateur
        String nomCompletLegal = "Bob Léponge";

        // Vérification que le nom contiens seulement des lettres
        assertTrue(testContiensSeulementLettres(nomCompletLegal));

    }

    /** Cette méthode permet de vérifier si le nom rentré par l'utilisateur ne contient que des lettres.
     * L'acheteur va rentrer des noms légal(légaux) dans ce champs et d'après la vitrine linguistique,
     * il ne peut pas y avoir de chiffre.
     * @param nomComplet
     * @return Vrai si le nom contient seulement des lettres et Faux si d'autres symboles sont détecter
     */
    private boolean testContiensSeulementLettres(String nomComplet){

        //création d'un expression pouvant contenir que des lettres
        String nomSeulementLettres = "^[a-zA-ZÀ-ö\\s]+$";

        //Retourne Vrai si le nom n'a seulement que des lettres inclus dans le String plus haut
        return nomComplet.matches(nomSeulementLettres);
    }


}