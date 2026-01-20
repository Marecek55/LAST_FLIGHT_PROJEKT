package Zaklad;
import Postavy.NPC;
import java.util.ArrayList;

public  class Mistnost {
    private String nazev;
    private ArrayList<Predmet> predmetyVMistnosti;
    private ArrayList<NPC> npcVMistnosti;
    private ArrayList<String> dostupneVychody;
    private boolean jeTamTma;
    private String pribeh;
    private boolean jeZamcena;

    public Mistnost() {
    }

    public String getNazev() {
        return nazev;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    public ArrayList<String> getDostupneVychody() {
        return dostupneVychody;
    }

    public void setDostupneVychody(ArrayList<String> dostupneVychody) {
        this.dostupneVychody = dostupneVychody;
    }

    public ArrayList<Predmet> getPredmetyVMistnosti() {
        return predmetyVMistnosti;
    }

    public void setPredmetyVMistnosti(ArrayList<Predmet> predmetyVMistnosti) {
        this.predmetyVMistnosti = predmetyVMistnosti;
    }

    public ArrayList<NPC> getNpcVMistnosti() {
        return npcVMistnosti;
    }

    public void setNpcVMistnosti(ArrayList<NPC> npcVMistnosti) {
        this.npcVMistnosti = npcVMistnosti;
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
