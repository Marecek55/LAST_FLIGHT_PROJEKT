package Zaklad;

import Command.Command;
import Postavy.NPC;
import Command.Jdi;
import java.util.HashMap;
import java.util.Scanner;

public class Hra {
    private StavKonce stavKonce;
    private String nazev;
    private Mistnost aktualniMistnost;
    private HashMap<String, Command> prikazy;
    private NacitaniZeSouboru data;
//    private HashMap<String, Mistnost> celaHra;

    public Hra() {
//        celaHra = NacitaniZeSouboru.nactiSouborHry();
//            for (Mistnost mistnost : celaHra.values()) {
//                mistnost.propojeniMistnosti(celaHra);
//            }
//            aktualniMistnost = celaHra.get("hlavniHala");
//            this.prikazy = new HashMap<>();
//            pridaniPrikazu();
        //Zkouška, zdali načtení proběhlo v pořádku
        this.prikazy = new HashMap<>();
        data = NacitaniZeSouboru.nactiDataZeSlozky("/dataHry.json");
        aktualniMistnost = data.najdiMistnost("hlavniHala");
        System.out.println("Items: " + data.predmety.size());
        System.out.println("Characters: " + data.npc.size());
        System.out.println("Locations: " + data.mistnosti.size());
        pridaniPrikazu();
    }
    public void pridaniPrikazu() {
        prikazy.put("jdi" ,new Jdi());
    }


    public NacitaniZeSouboru getData() {
        return data;
    }

    public StavKonce getStavKonce() {
        return stavKonce;
    }

    public void setStavKonce(StavKonce stavKonce) {
        this.stavKonce = stavKonce;
    }

    public String getNazev() {
        return nazev;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    public HashMap<String, Command> getPrikazy() {
        return prikazy;
    }

    public void setPrikazy(HashMap<String, Command> prikazy) {
        this.prikazy = prikazy;
    }


    public void konec(StavKonce stavKonce) {
    }

    public Mistnost getAktualniMistnost() {
        return aktualniMistnost;
    }

    public void setAktualniMistnost(Mistnost novaMistnost) {
        this.aktualniMistnost = novaMistnost;
    }
}
