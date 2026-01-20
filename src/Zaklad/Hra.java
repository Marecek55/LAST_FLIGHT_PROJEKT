package Zaklad;

import Command.Command;
import Command.Jdi;
import Postavy.NPC;

import java.util.HashMap;

public class Hra {
    private StavKonce stavKonce;
    private String nazev;
    private Mistnost aktualniMistnost;
    private HashMap<String, Command> prikazy;
    private NacitaniZeSouboru data;

    public Hra() {

        this.prikazy = new HashMap<>();
        data = NacitaniZeSouboru.nactiDataZeSlozky("/dataHry.json");
        aktualniMistnost = data.najdiMistnost("hlavniHala");
        for (int i = 0; i < data.npc.size(); i++) {
            data.npc.get(i).setTypMluveni(data.npc.get(i).getTypMluveniText());
        }
        data.nactiPozadovanyPredmet("mechanik", "kleste");
        data.nactiPozadovanyPredmet("vojak", "pasy");
        data.nactiPozadovanyPredmet("prodavacka", "voda");
        data.nasypDoMistnostiPredmety(new String[] {"pasy", "cokolada", "inzulin"}, new String[] {"stariManzele" , "sara"}, "hlavniHala" );
        data.nasypDoMistnostiPredmety(new String[] {"kleste"}, new String[] {}, "schodiste" );
        data.nasypDoMistnostiPredmety(new String[] {"pacidlo"}, new String[] {}, "garaze" );
        data.nasypDoMistnostiPredmety(new String[] {}, new String[] {}, "sluzebniChodba" );
        data.nasypDoMistnostiPredmety(new String[] {"baterka"}, new String[] {"mechanik"}, "technickaMistnost" );
        data.nasypDoMistnostiPredmety(new String[] {"voda"}, new String[] {"prodavacka"}, "lekarna" );
        data.nasypDoMistnostiPredmety(new String[] {"lekarnicka"}, new String[] {}, "sklad" );
        data.nasypDoMistnostiPredmety(new String[] {}, new String[] {"zlodej"}, "dutyFreeShop" );
        data.nasypDoMistnostiPredmety(new String[] {""}, new String[] {"vojak"}, "checkpoint" );
        System.out.println("Items: " + data.predmety.size());
        System.out.println("Characters: " + data.npc.size());
        System.out.println("Locations: " + data.mistnosti.size());
        for (int i = 0; i < data.mistnosti.size(); i++) {
            System.out.println(data.mistnosti.get(i).getNpcVMistnosti());
            System.out.println(data.mistnosti.get(i).getPredmetyVMistnosti());
        };
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
