package Zaklad;

import Command.Command;
import Command.Jdi;
import Command.Konec;
import Postavy.NPC;

import java.util.HashMap;

public class Hra {
    private StavKonce stavKonce;
    private String nazev;
    private Mistnost aktualniMistnost;
    private HashMap<String, Command> prikazy;
    private NacitaniZeSouboru data;
    private boolean jeKonec;

    /**
     * V konstruktoru hry se vola nacitani hry nastavi se aktualni mistnost na prvni mistnost a nastavi se typ mluveni u npc
     * taky se nactou pomoci metod data do mistnosti a pribeh mistnosti a dialogy npc
     */

    public Hra() {

        this.prikazy = new HashMap<>();
        data = NacitaniZeSouboru.nactiDataZeSlozky("/dataHry.json");
        aktualniMistnost = data.najdiMistnost("hlavnihala");
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
        for (int i = 0; i < data.npc.size(); i++) {
            data.nacteniPribehuPostavAMistnosti(data.npc.get(i).getJmeno(), true );
        }
        for (int i = 0; i < data.mistnosti.size(); i++) {
            data.nacteniPribehuPostavAMistnosti(data.mistnosti.get(i).getNazev(), false);
        }

        System.out.println("Predmetu je : " + data.predmety.size());
        System.out.println("NPC je nactenych: " + data.npc.size());
        System.out.println("Mistnosti je : " + data.mistnosti.size());
        pridaniPrikazu();
    }

    /**
     * pridaji se prikazy ktere muze hrac napsat do mapy prikazu
     */
    public void pridaniPrikazu() {
        prikazy.put("jdi" ,new Jdi());
        prikazy.put("konec", new Konec());
    }

    public void setData(NacitaniZeSouboru data) {
        this.data = data;
    }

    public boolean isJeKonec() {
        return jeKonec;
    }

    public void setJeKonec(boolean jeKonec) {
        this.jeKonec = jeKonec;
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
