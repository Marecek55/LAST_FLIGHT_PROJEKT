package Cas;

import Zaklad.Hra;

/**
 * V teto tride se hlida a odecita cas
 */
public class Cas {
    private int zbyvajiciCas = 50;
    private StrategieCasu tempoCasu;

    /**
     * odecita cas podle tempa
     */
    public String odecteniCasu(Hra hra) {
        zbyvajiciCas = tempoCasu.spocteniCasu(zbyvajiciCas);
        if (zbyvajiciCas>= 0){
            return "Zbyvajici "+hra.getCervena("cas")+" je " + zbyvajiciCas + " minut";
        }else {
            System.out.println(hra.getCervena("Dosel ti cas letadlo odletelo"));
            hra.setJeKonec(true);
        }
        return "";

    }

    public Cas(StrategieCasu tempoCasu) {
        this.tempoCasu = tempoCasu;
    }

    public int getZbyvajiciCas() {
        return zbyvajiciCas;
    }

    public void setZbyvajiciCas(int zbyvajiciCas) {
        this.zbyvajiciCas = zbyvajiciCas;
    }


    public void setTempoCasu(StrategieCasu tempoCasu) {
        this.tempoCasu = tempoCasu;
    }
}
