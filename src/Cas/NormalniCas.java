package Cas;
/**
 * Trida ktera urcuje odecitani normalniho casu
 * @author MAREK KULHÁNEK
 */
public class NormalniCas implements StrategieCasu{
    /**
     *  Odecte tolik casu v jake situaci je zrovna hrac
     * @param zaklad je zbyvajici cas
     * @return vraci odecteny cas
     */
    @Override
    public int spocteniCasu(int zaklad) {
        return zaklad-1;
    }
}
