package Postavy;

import Zaklad.Inventar;

public class Alex extends Postava {
    private boolean jeZraneny;


    public Alex(String jmeno) {
        super(jmeno);
    }

    public boolean isJeZraneny() {
        return jeZraneny;
    }

    public void setJeZraneny(boolean jeZraneny) {
        this.jeZraneny = jeZraneny;
    }
}
