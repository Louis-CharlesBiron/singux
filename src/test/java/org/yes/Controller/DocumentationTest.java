package org.yes.Controller;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;
public class DocumentationTest {

    @Test// question == "" (→question_length == 0) vide
    public void etantDonneQuestionVide_quandEssayerDeRecevoirDocumentation_alorsRetourneAucunResultat() {
        // ACTEUR
        AppGraphicalController appGraphicalController = new AppGraphicalController();
        String quesitonUtilisateur = "";

        // ACTION
        String reponseDocumentation = appGraphicalController.demanderDocumentation(quesitonUtilisateur);

        // ASSERTION
        assertEquals("Aucun résultat.", reponseDocumentation);
    }

    @Test // retVal == "" correct aucun
    public void etantDonneQuestionInconnnue_quandEssayerDeRecevoirDocumentation_alorsRetourneAucunResultat() {
        // ACTEUR
        AppGraphicalController appGraphicalController = new AppGraphicalController();
        String quesitonUtilisateur = "Comment faire en sorte que jar, tu fais sa pis ensuite, ya oui jar, pis bin ouin?";

        // ACTION
        String reponseDocumentation = appGraphicalController.demanderDocumentation(quesitonUtilisateur);

        // ASSERTION
        assertEquals("Aucun résultat.", reponseDocumentation);
    }

    @Test// question !== "" correct plusieurs
    public void etantDonneQuestionPeuComplete_quandEssayerDeRecevoirDocumentation_alorsRetournePlusieursResultatsPertinents() {
        // ACTEUR
        AppGraphicalController appGraphicalController = new AppGraphicalController();
        String quesitonUtilisateur = "comment entrer";

        // ACTION
        String reponseDocumentation = appGraphicalController.demanderDocumentation(quesitonUtilisateur);

        // ASSERTION
        assertEquals(
                "Dans la section 'Création d'une facture' > 'Nom de l'acheteur' entrer le nom de l'acheteur (doit contenir uniquement des lettres)\n\n" +
                "À l'aide de votre dispositif de pointage virtuel, appuier sur le bouton principal présent (probablement du côté gauche) de ce dispositif vis-à-vis l'une des trois case à cochée dans la section 'Mode de Paiement' (ne pas appuier sur le X rouge dans ce cas) (voir documentation de la souris)\n\n",
                reponseDocumentation);
    }

    @Test// question !== "" correct 1
    public void etantDonneQuestionTrèsComplete_quandEssayerDeRecevoirDocumentation_alorsRetourneUnResultatPertinent() {
        // ACTEUR
        AppGraphicalController appGraphicalController = new AppGraphicalController();
        String quesitonUtilisateur = "comment créer creer une facture ????????????";

        // ACTION
        String reponseDocumentation = appGraphicalController.demanderDocumentation(quesitonUtilisateur);

        // ASSERTION
        assertEquals("Dans la section 'Création d'une facture' > tout en bas, appuier sur le bouton 'Créer', si tout les champs sont remplis, la facture se créera sans soucis\n\n", reponseDocumentation);
    }

    @Test// question !== "" correct 1
    public void etantDonneQuestionExtrêmementEtTotalementCompleteAvecUneCaseÉtrange_quandEssayerDeRecevoirDocumentation_alorsRetourneUnResultatPertinent() {
        // ACTEUR
        AppGraphicalController appGraphicalController = new AppGraphicalController();
        String quesitonUtilisateur = "coMmenT enTREr UN mOde dE pAIemeNt haMBurgEr argent casH moNeY cLAms DaBLoonS fRic bread pAIn cUrreNcY $$$$$$$$$$ hAppy ContAnt COntent crEDit créDiT débiT DebIt";

        // ACTION
        String reponseDocumentation = appGraphicalController.demanderDocumentation(quesitonUtilisateur);

        // ASSERTION
        assertEquals("À l'aide de votre dispositif de pointage virtuel, appuier sur le bouton principal présent (probablement du côté gauche) de ce dispositif vis-à-vis l'une des trois case à cochée dans la section 'Mode de Paiement' (ne pas appuier sur le X rouge dans ce cas) (voir documentation de la souris)\n\n", reponseDocumentation);
    }

}