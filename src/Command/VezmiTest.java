package Command;

import Zaklad.Hra;
import Zaklad.Predmet;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VezmiTest {
    Hra hra;
    Vezmi vezmi;
    Predmet predmet;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        hra = new Hra();
        vezmi = new Vezmi();
        predmet = hra.getData().najdiPredmet("kleste");
        hra.setAktualniMistnost(hra.getData().najdiMistnost("schodiste"));
        hra.getAktualniMistnost().setJeProzkoumana(true);



    }

    @Test
    void vykonat() {
        vezmi.vykonat(hra, "kleste");
        assertTrue(hra.getInventar().getListPredmetu().contains(predmet));
    }
}