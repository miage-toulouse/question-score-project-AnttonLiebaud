package miagem1;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ScoreCalculateurTest {

    private QuestionAChoixMultiple uneQuestion;
    private ScoreCalculateur calculateur;

    @Before
    public void setUp() throws Exception {
        uneQuestion = new QuestionAChoixMultiple("q1",new ArrayList<Integer>(Arrays.asList(2,3,5)), 5);
        calculateur = new ScoreCalculateur();
    }

    // ERREUR DE COMMIT ! Précédent commit fix #2 correspond au fix #3

    @Test
    public void testCalculeScore() {
        //when : un étudiant fourni une liste d'indice correspondant à des bonnes réponses
        List<Integer> indiceEtudiant = new ArrayList<Integer>();
        indiceEtudiant.add(2);
        indiceEtudiant.add(3);
        // and : on demande le calcule du score
        Float resScore = calculateur.calculeScore(indiceEtudiant,uneQuestion);
        // then : le score obtenu est 66,66
        assertEquals(new Float((100f/(float)3)*2), resScore);
        // when : un Etudiant fourni une liste d'indice correspondant à toutes les bonnes réponses
        indiceEtudiant.clear();
        indiceEtudiant.add(2);
        indiceEtudiant.add(3);
        indiceEtudiant.add(5);
        resScore = calculateur.calculeScore(indiceEtudiant,uneQuestion);
        // then : le score obtenu est 100
        assertEquals(new Float(100), resScore);
        // when : un Etudiant fourni une liste d'indice correspondant à des mauvaises réponses
        indiceEtudiant.clear();
        indiceEtudiant.add(1);
        indiceEtudiant.add(4);
        resScore = calculateur.calculeScore(indiceEtudiant,uneQuestion);
        // then : le score obtenu est 0
        assertEquals(new Float(0f), resScore);
        // when : un Etudiant fourni une liste d'indice correspondant à des bonnes réponses avec des mauvaises réponses
        indiceEtudiant.clear();
        indiceEtudiant.add(1);
        indiceEtudiant.add(3);
        indiceEtudiant.add(4);
        resScore = calculateur.calculeScore(indiceEtudiant,uneQuestion);
        // then : le score obtenu est 0
        assertEquals(new Float(0f), resScore);

        // when : un Etudiant fourni une liste d'indice contenant toutes les réponses possibles
        indiceEtudiant.clear();
        indiceEtudiant.add(1);
        indiceEtudiant.add(2);
        indiceEtudiant.add(3);
        indiceEtudiant.add(4);
        indiceEtudiant.add(5);
        resScore = calculateur.calculeScore(indiceEtudiant,uneQuestion);
        // then : le score obtenu est 0
        assertEquals(new Float(0), resScore);

        // when : un Etudiant fourni une liste d'indice contenant 1,2,3
        indiceEtudiant.clear();
        indiceEtudiant.add(1);
        indiceEtudiant.add(2);
        indiceEtudiant.add(3);

        resScore = calculateur.calculeScore(indiceEtudiant,uneQuestion);
        // then : le score obtenu est environ 16,66
        assertEquals(new Float((100f/(float)3)*2 - 50f), resScore);


    }
}