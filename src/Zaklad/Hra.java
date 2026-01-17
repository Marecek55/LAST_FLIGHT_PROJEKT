package Zaklad;

import Command.Command;

import java.util.HashMap;

public class Hra {
    private StavKonce stavKonce;
    private String nazev;
    private Mistnost aktualniMistnost;
    private HashMap<String, Command> prikazy;
    private HashMap<String, Mistnost> celaHra;

    public Hra() {
        celaHra = NacitaniZeSouboru.nactiSouborHry();
            for (Mistnost mistnost : celaHra.values()) {
                mistnost.propojeniMistnosti(celaHra);
            }
            aktualniMistnost = celaHra.get("hlavniHala");
            this.prikazy = new HashMap<>();
            pridaniPrikazu();
    }

    public void pridaniPrikazu() {

    }

    public void konec(StavKonce stavKonce) {
        this.stavKonce = stavKonce;
    }

    public Mistnost getAktualniMistnost() {
        return aktualniMistnost;
    }

    public void setAktualniMistnost(Mistnost novaMistnost) {
        this.aktualniMistnost = novaMistnost;
    }
}
