package Zaklad;

import java.util.ArrayList;

public class Inventar {
    private int kapacita;
    private boolean jePlny;
    private ArrayList<Predmet> listPredmetu;
    public void odebratPredmet(Predmet p) {}
    public void pridatPredmet(Predmet p) {
        listPredmetu.add(p);
    }
    public boolean predmetJeVInventari(Predmet predmet){
        if (listPredmetu.contains(predmet)){
            return true;
        }else {
            return false;
        }

    }

    public int getKapacita() {
        return kapacita;
    }

    public void setKapacita(int kapacita) {
        this.kapacita = kapacita;
    }

    public boolean isJePlny() {
        return jePlny;
    }

    public void setJePlny(boolean jePlny) {
        this.jePlny = jePlny;
    }

    public ArrayList<Predmet> getListPredmetu() {
        return listPredmetu;
    }

    public void setListPredmetu(ArrayList<Predmet> listPredmetu) {
        this.listPredmetu = listPredmetu;
    }

    public void zobrazeniInventare(){}

    public Inventar(int kapacita) {
        this.kapacita = kapacita;
        this.jePlny = false;
        this.listPredmetu = null;
        this.listPredmetu = new ArrayList<>();
    }
}
