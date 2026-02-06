package Cas;

/**
 * Trida ktera urcuje odecitani casu bloudeni
 */
public class CasBloudeni implements StrategieCasu{
    /**
     *  Odecte tolik casu v jake situaci je zrovna hrac
     * @param zaklad
     * @return
     */
    @Override
    public int spocteniCasu(int zaklad) {
        return zaklad-5;
    }
}
