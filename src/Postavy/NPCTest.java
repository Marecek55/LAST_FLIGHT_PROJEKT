package Postavy;

import Command.Vezmi;
import Mluveni.PrijemneMluveni;
import Zaklad.Hra;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NPCTest {
    Hra hra;
    String text;
    NPC npc;
    PrijemneMluveni pm;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        hra = new Hra();
        text = "prijemne";
        npc = new NPC("Testovaci");
        pm = new PrijemneMluveni();
    }

    @Test
    void setTypMluveni() {
        npc.setTypMluveni(text);
        assertEquals(pm.pozdrav(), npc.getTypMluveni().pozdrav());
    }
}