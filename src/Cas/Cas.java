package Cas;

public class Cas {
    private int zbyvajiciCas = 50;
    private StrategieCasu tempoCasu;
    public void odecteniCasu() {
        zbyvajiciCas = tempoCasu.spocteniCasu(zbyvajiciCas);
        System.out.println("Zbyvajici cas: " + zbyvajiciCas + " minut.");
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

    public StrategieCasu getTempoCasu() {
        return tempoCasu;
    }

    public void setTempoCasu(StrategieCasu tempoCasu) {
        this.tempoCasu = tempoCasu;
    }
}
