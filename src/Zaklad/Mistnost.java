package Zaklad;

import Postavy.NPC;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public  class Mistnost {
    private String nazev;
    private ArrayList<Predmet> predmetyvmistnosti;//TODO
    private ArrayList<NPC> npcvmistnosti;//TODO
    private HashMap<String,String> dostupneVychody;
    private boolean jeTamTma;
    private String pribeh;
    private boolean jeZamcena;
    private HashMap<String, Mistnost> propojeneVychody = new HashMap<>();
//    public Mistnost vstupDoDalsiMistnosti(String nazev) {
//        return Hra;
//    }
public void propojVychody(HashMap<String, Mistnost> celySvet) {
    for (String klic : dostupneVychody.keySet()) {
        String nazevCile = dostupneVychody.get(klic);
        Mistnost cil = celySvet.get(nazevCile);
        if (cil != null) {
            propojeneVychody.put(klic, cil);
        }
    }
    //TODO
}


    public ArrayList<NPC> getnpcvmistnosti() {
        return npcvmistnosti;
    }

    public void setnpcvmistnosti(ArrayList<NPC> npcvmistnosti) {
        this.npcvmistnosti = npcvmistnosti;
    }

    public Mistnost() {
    }

    public String getNazev() {
        return nazev;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    public ArrayList<Predmet> getpredmetyvmistnosti() {
        return predmetyvmistnosti;
    }

    public void setpredmetyvmistnosti(ArrayList<Predmet> predmetyvmistnosti) {
        this.predmetyvmistnosti = predmetyvmistnosti;
    }

    public HashMap<String, String> getDostupneVychody() {
        return dostupneVychody;
    }

    public void setDostupneVychody(HashMap<String, String> dostupneVychody) {
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
