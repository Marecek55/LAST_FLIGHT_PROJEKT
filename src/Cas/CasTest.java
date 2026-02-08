package Cas;

import Zaklad.Hra;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Trida ktera testuje cas
 */
class CasTest {
    Hra hra;


    /**
     * Metoda ktera nastavi veci pred kazdym testem
     */
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        hra = new Hra();
       hra.getCas().setZbyvajiciCas(0);

    }

    /**
     * Testuje jestli se sprvane skonci hra kdyz dojde cas
     */

    @Test
    void odecteniCasu() {
        hra.getCas().odecteniCasu(hra);
        assertTrue(hra.isJeKonec());
    }
}