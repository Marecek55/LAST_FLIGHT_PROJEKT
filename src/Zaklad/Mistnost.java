package Zaklad;

import Postavy.NPC;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public  class Mistnost {
    private String nazev;
    private ArrayList<Predmet> predmetyVMistnosti;
    private ArrayList<NPC> npcVMistnosti;
    /**
     * dostupneVychody json tam hodi data mistnsoti kam muze jit z nej jen jako text
     */
    private HashMap<String,String> dostupneVychody;
    private boolean jeTamTma;
    private String pribeh;
    private boolean jeZamcena;
    /**
     * propojeneVychody jsou prevedene string z dostupneVychody na objekty Mistnost
     */
    private HashMap<String, Mistnost> propojeneMistnosti = new HashMap<>();
    /**
     * vstupDoDalsiMistnosti podiva se do propojeneMistnosti a najde nazev a mistnosti jestli je soused a vrati ji
     */
    public Mistnost vstupDoDalsiMistnosti(String nazev) {
        Mistnost cilova  = propojeneMistnosti.get(nazev) ;
        return cilova;
    }


    /**
     * propojeniMistnosti prevedou string na mistnost a ulozi se do propojenych vychodu
     */
public void propojeniMistnosti(HashMap<String, Mistnost> celaHra) {
    for (String nazev : dostupneVychody.keySet()) {
        String cil = dostupneVychody.get(nazev);
        Mistnost cilova = celaHra.get(cil);
        propojeneMistnosti.put(nazev, cilova);
    }

}
    public Mistnost() {
    }

    public String getNazev() {
        return nazev;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }
    public HashMap<String, Mistnost> getPropojeneMistnosti() {
        return propojeneMistnosti;
    }

    public void setPropojeneMistnosti(HashMap<String, Mistnost> propojeneMistnosti) {
        this.propojeneMistnosti = propojeneMistnosti;
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
