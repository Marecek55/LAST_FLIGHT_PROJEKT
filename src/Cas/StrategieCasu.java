package Cas;
/**
 * Interface strategie casu
 */
public interface StrategieCasu {
    /**
     *  Urci kolik casu odecte podle toho v jake Strategii casu je zrovna hrac
     * @param zaklad
     * @return
     */
    public int spocteniCasu(int zaklad);

}
