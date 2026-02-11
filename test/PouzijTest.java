import Command.Pouzij;
import Zaklad.Hra;
import Zaklad.Mistnost;
import Zaklad.Predmet;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
/**
 * Trida ktera testuje tridu Pouzij
 */
class PouzijTest {
    Predmet predmet;
    Pouzij pouzij;
    Hra hra;
    /**
     * Metoda ktera nastavi veci pred kazdym testem
     */
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        hra = new Hra();
       pouzij = new Pouzij();


    }
    /**
     * Metoda ktera otestuje nasledky pouziti cokolady lekarnicky vody a pacidla
     */
    @Test
    void vykonat() {
        hra.getCas().setZbyvajiciCas(50);
        predmet = hra.getData().najdiPredmet("cokolada");
        hra.getInventar().pridatPredmet(predmet);
        pouzij.vykonat(hra, "cokolada");
        assertEquals(60, hra.getCas().getZbyvajiciCas());
        assertFalse(hra.getInventar().getListPredmetu().contains(predmet));

        hra.getCas().setZbyvajiciCas(50);
        predmet = hra.getData().najdiPredmet("lekarnicka");
        hra.getInventar().pridatPredmet(predmet);
        pouzij.vykonat(hra, "lekarnicka");
        assertEquals(55, hra.getCas().getZbyvajiciCas());
        assertFalse(hra.getInventar().getListPredmetu().contains(predmet));
        assertTrue(hra.getCas().getTempoCasu().spocteniCasu(1) == 0);

        predmet = hra.getData().najdiPredmet("voda");
        hra.getInventar().pridatPredmet(predmet);
        pouzij.vykonat(hra, "voda");
        assertFalse(hra.getInventar().getListPredmetu().contains(predmet));

        predmet = hra.getData().najdiPredmet("pacidlo");
        hra.getInventar().pridatPredmet(predmet);
        Mistnost pomocna =hra.getData().najdiSousedaCoMa(hra.getData().najdiMistnost("hlavniHala"));
        pouzij.vykonat(hra, "pacidlo");

        assertFalse(pomocna.isJeZamcena());


    }
}