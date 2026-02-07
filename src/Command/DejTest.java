package Command;

import Postavy.NPC;
import Zaklad.Hra;
import Zaklad.Mistnost;
import Zaklad.Predmet;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DejTest {
    NPC npc = new NPC("StariManzele");
    Predmet predmet = new Predmet();
    Hra hra = new Hra();
    Dej dej = new Dej();

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        npc.setJmeno("StariManzele");
        predmet.setNazev("cokolada");
        npc.setOcekavanyPredmet(predmet);
        hra.getInventar().pridatPredmet(predmet);
        hra.getData().predmety.clear();
        hra.getData().predmety.add(predmet);
        hra.getData().npc.add(npc);
        hra.getAktualniMistnost().getNpcVMistnosti().add(npc);
        hra.getAktualniMistnost().setJeProzkoumana(true);
        hra.setTretiCastPrikazu("cokolada");

    }


    @org.junit.jupiter.api.Test
    void vykonat() {
        String vypis = dej.vykonat(hra, npc.getJmeno());
        assertFalse(hra.getInventar().predmetJeVInventari(predmet));
        assertTrue(npc.isDostalToCoChtel());
        assertEquals(hra.getTyrkysova("Dal jsi ruku zpet"), vypis);
    }
}