package org.yes.Model;

import static org.junit.jupiter.api.Assertions.*;

class FactureTest {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.Test
    void setTotalSansTaxes() {
    }

    @org.junit.jupiter.api.Test
    void setNomClient(){

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
        String nomSeulementLettres = "^[a-zA-Z\\s]+$";

        //Retourne Vrai si le nom n'a seulement que des lettres inclus dans le String plus haut
        return nomComplet.matches(nomSeulementLettres);
    }
}