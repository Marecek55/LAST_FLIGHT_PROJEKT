package Zaklad;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InventarTest {
    Predmet predmet;
    Hra hra;
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        hra = new Hra();
       predmet = new Predmet();
       predmet.setNazev("Kleste");
       hra.getData().predmety.add(predmet);
        hra.getInventar().getListPredmetu().add(predmet);

    }
    @Test
    void odebratPredmet() {
        hra.getInventar().odebratPredmet(predmet);
        assertFalse(hra.getInventar().getListPredmetu().contains(predmet));
    }

    @Test
    void pridatPredmet() {
        hra.getInventar().getListPredmetu().clear();
        hra.getInventar().pridatPredmet(predmet);
        assertTrue(hra.getInventar().getListPredmetu().contains(predmet));
    }

    @Test
    void predmetJeVInventari() {
        boolean odpoved = hra.getInventar().predmetJeVInventari(predmet);
        assertTrue(odpoved);
    }
}