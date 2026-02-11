import Command.Vezmi;
import Zaklad.Hra;
import Zaklad.Predmet;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
/**
 * Trida ktera testuje tridu vezmi
 */
class VezmiTest {
    Hra hra;
    Vezmi vezmi;
    Predmet predmet;
    /**
     * Metoda ktera nastavi veci pred kazdym testem
     */
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        hra = new Hra();
        vezmi = new Vezmi();
        predmet = hra.getData().najdiPredmet("kleste");
        hra.setAktualniMistnost(hra.getData().najdiMistnost("schodiste"));
        hra.getAktualniMistnost().setJeProzkoumana(true);



    }
    /**
     * Metoda ktera kontroluje ze se predmet prida do inventare
     */
    @Test
    void vykonat() {
        vezmi.vykonat(hra, "kleste");
        assertTrue(hra.getInventar().getListPredmetu().contains(predmet));
    }
}