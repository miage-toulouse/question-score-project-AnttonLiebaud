package miagem1;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class QuestionAChoixMultipleTest {

    private QuestionAChoixMultiple uneQuestion;

    @Before
    public void setUp() throws Exception {

        uneQuestion = new QuestionAChoixMultiple("un énoncé", new ArrayList<Integer>(Arrays.asList(2,3)), 3);

    }

    @Test
    public void testGetEnonce() {
        // when : on demande l'énoncé à la question
        String resEnonce = uneQuestion.getEnonce();
        // then : l'énoncé est non null
        assertNotNull(resEnonce);
        //and : l'énoncé est bien celui fourni à la construction
        assertEquals(resEnonce, "un énoncé");
    }

    @Test
    public void testGetScoreForIndice() {
        //when : un étudiant fourni l'indice correspondant à la bonne réponse
        int indiceEtudiant = 2;
        // and : on demande le calcule du score
        Float resScore = uneQuestion.getScoreForIndice(indiceEtudiant);
        // then : le score obtenu est 50
        assertEquals(new Float(100f/(float)2), resScore);
        // when : un Etudiant fourni l'indice correspondant à une mauvaise réponse
        indiceEtudiant = 1;
        resScore = uneQuestion.getScoreForIndice(indiceEtudiant);
        // then : le score obtenu est 0
        assertEquals(new Float(-100), resScore);
    }
}