package Zaklad;

public class Predmet {
    private String nazev;
    private boolean jdeVyhodit;
    private boolean jeDulezity;

    public Predmet() {
    }

    public String getNazev() {
        return nazev;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    public boolean isJdeVyhodit() {
        return jdeVyhodit;
    }

    public void setJdeVyhodit(boolean jdeVyhodit) {
        this.jdeVyhodit = jdeVyhodit;
    }

    public boolean isJeDulezity() {
        return jeDulezity;
    }

    public void setJeDulezity(boolean jeDulezity) {
        this.jeDulezity = jeDulezity;
    }
}
