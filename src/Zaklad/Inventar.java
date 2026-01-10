package Zaklad;

import java.util.ArrayList;

public class Inventar {
    private int kapacita;
    private boolean jePlny;
    private ArrayList<Predmet> listPredmetu;
    public void odebratPredmet(Predmet p) {}
    public void pridatPredmet(Predmet p) {}
    public void predmetJeVInventari(String nazev){}
    public void zobrazeniInventare(){}

    public Inventar(int kapacita) {
        this.kapacita = kapacita;
        this.jePlny = false;
        this.listPredmetu = null;
    }
}
