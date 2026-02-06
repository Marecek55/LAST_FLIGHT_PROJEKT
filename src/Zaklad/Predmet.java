package Zaklad;
/**
 * Trida Predmet nastavuje vsechny vlastnosti predmetu
 */
public class Predmet {
    private String nazev;
    private boolean jdeVyhodit;
    private boolean jeDulezity;
    private boolean jdePouzit;

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

    public boolean isJdePouzit() {
        return jdePouzit;
    }

    public void setJdePouzit(boolean jdePouzit) {
        this.jdePouzit = jdePouzit;
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

    @Override
    public String toString() {
        return "Predmet{" +
                "nazev='" + nazev + '\'' +
                ", jdeVyhodit=" + jdeVyhodit +
                ", jeDulezity=" + jeDulezity +
                '}';
    }
}
