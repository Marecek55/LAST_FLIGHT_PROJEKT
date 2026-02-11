package Postavy;

import Zaklad.Inventar;
/**
 * Trida Alexe hlavni postavy upravuje jeho stav zraneni
 * @author MAREK KULHÁNEK
 */
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
