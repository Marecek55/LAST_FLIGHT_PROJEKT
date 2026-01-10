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
    public Mistnost vstupDoDalsiMistnosti(String nazev) {}

    public Mistnost(String nazev, ArrayList<Predmet> predmetyVMistnosti, HashMap<String, Mistnost> dostupneVychody, boolean jeTamTma, boolean jeZamcena) {
        this.nazev = nazev;
        this.predmetyVMistnosti = predmetyVMistnosti;
        this.dostupneVychody = dostupneVychody;
        this.jeTamTma = jeTamTma;
        this.pribeh = null;
        this.jeZamcena = jeZamcena;
    }
}
