package Cas;
/**
 * Interface strategie casu
 * @author MAREK KULHÁNEK
 */
public interface StrategieCasu {
    /**
     *  Urci kolik casu odecte podle toho v jake Strategii casu je zrovna hrac
     * @param zaklad je zbyvajici cas
     * @return vraci odecteny cas
     */
    public int spocteniCasu(int zaklad);

}
