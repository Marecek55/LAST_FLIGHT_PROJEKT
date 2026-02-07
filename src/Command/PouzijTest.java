package Command;

import Zaklad.Hra;
import Zaklad.Mistnost;
import Zaklad.Predmet;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PouzijTest {
    Predmet predmet;
    Pouzij pouzij;
    Hra hra;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        hra = new Hra();
       pouzij = new Pouzij();


    }
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