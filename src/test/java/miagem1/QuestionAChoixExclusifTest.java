package miagem1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class QuestionAChoixExclusifTest {

    private QuestionAChoixExclusif uneQuestion;

    @Before
    public void setUp() throws Exception {
        // given : un objet de type QuestionAChoixExclusif
        uneQuestion = new QuestionAChoixExclusif("un énoncé", 2);
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
        // then : le score obtenu est 100
        assertEquals(new Float(100f), resScore);
        // when : un Etudiant fourni l'indice correspondant à une mauvaise réponse
        indiceEtudiant = 3;
        resScore = uneQuestion.getScoreForIndice(indiceEtudiant);
        // then : le score obtenu est 100
        assertEquals(new Float(0f), resScore);
    }
}