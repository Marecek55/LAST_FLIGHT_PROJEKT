package Cas;

import Zaklad.Hra;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CasTest {
    Hra hra;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        hra = new Hra();
       hra.getCas().setZbyvajiciCas(0);

    }

    @Test
    void odecteniCasu() {
        hra.getCas().odecteniCasu(hra);
        assertTrue(hra.isJeKonec());
    }
}