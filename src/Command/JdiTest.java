package Command;

import Postavy.Alex;
import Postavy.Postava;
import Zaklad.Hra;
import Zaklad.Mistnost;
import Zaklad.NacitaniZeSouboru;
import Zaklad.Predmet;

import java.util.ArrayList;
/**
 * Trida ktera testuje tricu Jdi
 */
import static org.junit.jupiter.api.Assertions.*;
class JdiTest {
    public ArrayList<Mistnost> mistnosti = new ArrayList<>();
    Hra hra = new Hra();
    Mistnost mistnost;
    Mistnost cilova;
    Jdi jdi;
    /**
     * Metoda ktera nastavi veci pred kazdym testem
     */
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        ArrayList<String> sousedi =  new ArrayList<>();
        sousedi.add("b");
        hra.getData().mistnosti.clear();
        hra.getData().mistnosti.add(mistnost = new Mistnost("a"));
        mistnost.setNazev("a");
        mistnost.setPribeh("pribeh");
        hra.getData().mistnosti.add(cilova = new Mistnost("b"));
        cilova.setNazev("b");
        cilova.setPribeh("pribeh");
        hra.getData().mistnosti.get(0).setDostupneVychody(sousedi);
        jdi = new Jdi();
        hra.setAktualniMistnost(mistnost);
    }

    /**
     * Metoda ktera testuje jestli spravne presel do dalsi mistnosti
     */
    @org.junit.jupiter.api.Test
    void vykonat() {
        jdi.vykonat(hra, "b");
        assertEquals(cilova, hra.getAktualniMistnost());

    }
}