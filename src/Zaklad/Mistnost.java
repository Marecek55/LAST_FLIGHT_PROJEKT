package Zaklad;

import java.util.ArrayList;
import java.util.HashMap;

public  class Mistnost {
    private String nazev;
    private ArrayList<Predmet> predmetyVMistnosti;
    private HashMap<String,Mistnost> dostupneVychody;
    private boolean jeTamTma;
    private String pribeh;
    private boolean jeZamcena;
//    public Mistnost vstupDoDalsiMistnosti(String nazev) {
//        return Hra;
//    }


    public Mistnost() {
    }

    public String getNazev() {
        return nazev;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    public ArrayList<Predmet> getPredmetyVMistnosti() {
        return predmetyVMistnosti;
    }

    public void setPredmetyVMistnosti(ArrayList<Predmet> predmetyVMistnosti) {
        this.predmetyVMistnosti = predmetyVMistnosti;
    }

    public HashMap<String, Mistnost> getDostupneVychody() {
        return dostupneVychody;
    }

    public void setDostupneVychody(HashMap<String, Mistnost> dostupneVychody) {
        this.dostupneVychody = dostupneVychody;
    }

    public boolean isJeTamTma() {
        return jeTamTma;
    }

    public void setJeTamTma(boolean jeTamTma) {
        this.jeTamTma = jeTamTma;
    }

    public String getPribeh() {
        return pribeh;
    }

    public void setPribeh(String pribeh) {
        this.pribeh = pribeh;
    }

    public boolean isJeZamcena() {
        return jeZamcena;
    }

    public void setJeZamcena(boolean jeZamcena) {
        this.jeZamcena = jeZamcena;
    }
}
