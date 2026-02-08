package Zaklad;

import Postavy.NPC;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
/**
 * Trida ktera testuje tridu nacitani ze souboru
 */
class NacitaniZeSouboruTest {
    Hra hra;
    /**
     * Metoda ktera nastavi veci pred kazdym testem
     */
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        hra = new Hra();

    }
    /**
     * Metoda ktera testuje ze se spravne nasypou data do mistnosti
     */

    @Test
    void nasypDoMistnostiPredmety() {
        hra.getData().nasypDoMistnostiPredmety(new String[] {"pacidlo"}, new String[] {"vojak"} , "schodiste");
        assertEquals(hra.getData().najdiPredmet("pacidlo"), hra.getData().najdiMistnost("schodiste").getPredmetyVMistnosti().get(0));
        assertEquals(hra.getData().najdiNPC("vojak"), hra.getData().najdiMistnost("schodiste").getNpcVMistnosti().get(0));
    }
    /**
     * Metoda ktera kotroluje ze se spravne nastavi pozadovany predmet
     */
    @Test
    void nactiPozadovanyPredmet() {
        hra.getData().nactiPozadovanyPredmet("vojak", "kleste");
        assertTrue(hra.getData().najdiNPC("vojak").getOcekavanyPredmet()!=null);
    }
}