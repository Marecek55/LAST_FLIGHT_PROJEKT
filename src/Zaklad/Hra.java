package Zaklad;

import Cas.Cas;
import Command.Command;
import Command.Jdi;
import Command.Konec;
import Command.Napoveda;
import Command.Dej;
import Command.Mluv;
import Command.Poloz;
import Command.Pouzij;
import Command.Prozkoumej;
import Command.Uhni;
import Command.Utok;
import Command.InventarCommand;
import Command.Vezmi;
import Cas.NormalniCas;
import Command.Pomoc;
import Postavy.Alex;
import Postavy.Unosce;


import java.util.HashMap;

public class Hra {
    private StavKonce stavKonce;
    private String nazev;
    private Mistnost aktualniMistnost;
    private HashMap<String, Command> prikazy;
    private NacitaniZeSouboru data;
    private boolean jeKonec;
    private String tretiCastPrikazu;
    private Inventar inventar;
    private Cas cas;
    private Unosce unosce;
    private Souboj souboj;
    private Bludiste bludiste;
    private Komunikace komunikace;
    private Alex alex;
    private Konzole konzole;
    /**
     * V konstruktoru hry se vola nacitani hry nastavi se aktualni mistnost na prvni mistnost a nastavi se typ mluveni u npc
     * taky se nactou pomoci metod data do mistnosti a pribeh mistnosti a dialogy npc a vytvari se instance pro tridy ktere
     * do hry patri aby k nim commandy meli pristup
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
        data.nasypDoMistnostiPredmety(new String[] {"pasy"}, new String[] {"stariManzele" , "sara"}, "hlavniHala" );
        data.nasypDoMistnostiPredmety(new String[] {"kleste"}, new String[] {}, "schodiste" );
        data.nasypDoMistnostiPredmety(new String[] {"pacidlo"}, new String[] {}, "garaze" );
        data.nasypDoMistnostiPredmety(new String[] {}, new String[] {}, "sluzebniChodba" );
        data.nasypDoMistnostiPredmety(new String[] {"baterka"}, new String[] {"mechanik"}, "technickaMistnost" );
        data.nasypDoMistnostiPredmety(new String[] {"voda"}, new String[] {"prodavacka"}, "lekarna" );
        data.nasypDoMistnostiPredmety(new String[] {"lekarnicka"}, new String[] {}, "sklad" );
        data.nasypDoMistnostiPredmety(new String[] {}, new String[] {"zlodej"}, "dutyFreeShop" );
        data.nasypDoMistnostiPredmety(new String[] {""}, new String[] {"vojak"}, "checkpoint" );
        for (int i = 0; i < data.mistnosti.size(); i++) {
            data.mistnosti.get(i).setPribeh(data.nacteniRadkuSouboru(data.mistnosti.get(i).getNazev(), "ZACATEKMISTNOSTI", true));
        }
        System.out.println("Predmetu je : " + data.predmety.size());
        System.out.println("NPC je nactenych: " + data.npc.size());
        System.out.println("Mistnosti je : " + data.mistnosti.size());
        inventar = new Inventar(4);
        inventar.pridatPredmet(data.najdiPredmet("inzulin"));
        cas = new Cas(new NormalniCas());
        unosce  = new Unosce("Unosce", 3);
        pridaniPrikazu();
        souboj = new Souboj();
        bludiste = new Bludiste();
        komunikace = new Komunikace();
        alex = new Alex("Alex");
        konzole = new Konzole();
        System.out.print(aktualniMistnost.getPribeh());
        aktualniMistnost.setBylVNi(true);

//        setAktualniMistnost(getData().najdiMistnost("checkpoint"));
//        getInventar().pridatPredmet(getData().najdiPredmet("pasy"));

    }

    /**
     * pridaji se prikazy ktere muze hrac napsat do mapy prikazu
     */
    public void pridaniPrikazu() {
        prikazy.put("jdi" ,new Jdi());
        prikazy.put("dej" ,new Dej());
        prikazy.put("konec", new Konec());
        prikazy.put("napoveda" , new Napoveda());
        prikazy.put("inventar", new InventarCommand());
        prikazy.put("mluv", new Mluv());
        prikazy.put("poloz", new Poloz());
        prikazy.put("pouzij", new Pouzij());
        prikazy.put("prozkoumej", new Prozkoumej());
        prikazy.put("uhni", new Uhni());
        prikazy.put("utok", new Utok());
        prikazy.put("vezmi", new Vezmi());
        prikazy.put("pomoc", new Pomoc());

    }

    public Alex getAlex() {
        return alex;
    }

    public void setAlex(Alex alex) {
        this.alex = alex;
    }

    public Komunikace getKomunikace() {
        return komunikace;
    }

    public void setKomunikace(Komunikace komunikace) {
        this.komunikace = komunikace;
    }

    public Bludiste getBludiste() {
        return bludiste;
    }

    public void setBludiste(Bludiste bludiste) {
        this.bludiste = bludiste;
    }

    public Cas getCas() {
        return cas;
    }

    public void setCas(Cas cas) {
        this.cas = cas;
    }

    public void setData(NacitaniZeSouboru data) {
        this.data = data;
    }

    public boolean isJeKonec() {
        return jeKonec;
    }

    public String getTretiCastPrikazu() {
        return tretiCastPrikazu;
    }

    public void setTretiCastPrikazu(String tretiCastPrikazu) {
        this.tretiCastPrikazu = tretiCastPrikazu;
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

    public Konzole getKonzole() {
        return konzole;
    }

    public void setKonzole(Konzole konzole) {
        this.konzole = konzole;
    }

    public void konec(StavKonce stavKonce) {
    }

    public Inventar getInventar() {
        return inventar;
    }

    public void setInventar(Inventar inventar) {
        this.inventar = inventar;
    }

    public Mistnost getAktualniMistnost() {
        return aktualniMistnost;
    }

    public void setAktualniMistnost(Mistnost novaMistnost) {
        this.aktualniMistnost = novaMistnost;
    }

    public Unosce getUnosce() {
        return unosce;
    }

    public void setUnosce(Unosce unosce) {
        this.unosce = unosce;
    }

    public Souboj getSouboj() {
        return souboj;
    }

    public void setSouboj(Souboj souboj) {
        this.souboj = souboj;
    }
}
