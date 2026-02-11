import Zaklad.Hra;
import Zaklad.Predmet;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
/**
 * Trida ktera testuje tridu inventar
 */
class InventarTest {
    Predmet predmet;
    Hra hra;
    /**
     * Metoda ktera nastavi veci pred kazdym testem
     */
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        hra = new Hra();
       predmet = new Predmet();
       predmet.setNazev("Kleste");
       hra.getData().predmety.add(predmet);
        hra.getInventar().getListPredmetu().add(predmet);

    }
    /**
     * Metoda ktera testuje metodu jestli se predmat odebrat
     */
    @Test
    void odebratPredmet() {
        hra.getInventar().odebratPredmet(predmet);
        assertFalse(hra.getInventar().getListPredmetu().contains(predmet));
    }
    /**
     * Metoda ktera testuje jestli se predmet prida
     */
    @Test
    void pridatPredmet() {
        hra.getInventar().getListPredmetu().clear();
        hra.getInventar().pridatPredmet(predmet);
        assertTrue(hra.getInventar().getListPredmetu().contains(predmet));
    }
    /**
     * Metoda ktera testuje jestli spravne funguje metoda na to jestli je predmet v inventari
     */
    @Test
    void predmetJeVInventari() {
        boolean odpoved = hra.getInventar().predmetJeVInventari(predmet);
        assertTrue(odpoved);
    }
}