package Zaklad;

import Postavy.NPC;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class NacitaniZeSouboruTest {
    Hra hra;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        hra = new Hra();

    }

    @Test
    void nasypDoMistnostiPredmety() {
        hra.getData().nasypDoMistnostiPredmety(new String[] {"pacidlo"}, new String[] {"vojak"} , "schodiste");
        assertEquals(hra.getData().najdiPredmet("pacidlo"), hra.getData().najdiMistnost("schodiste").getPredmetyVMistnosti().get(0));
        assertEquals(hra.getData().najdiNPC("vojak"), hra.getData().najdiMistnost("schodiste").getNpcVMistnosti().get(0));
    }

    @Test
    void nactiPozadovanyPredmet() {
        hra.getData().nactiPozadovanyPredmet("vojak", "kleste");
        assertTrue(hra.getData().najdiNPC("vojak").getOcekavanyPredmet()!=null);
    }
}