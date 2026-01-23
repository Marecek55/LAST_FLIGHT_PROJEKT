package Postavy;

import Zaklad.Inventar;

public class Alex extends Postava {
    private boolean jeZraneny;


    public Alex(String jmeno, boolean jeZraneny) {
        super(jmeno);
        this.jeZraneny = jeZraneny;
    }

}
