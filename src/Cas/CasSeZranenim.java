package Cas;
/**
 * Trida ktera urcuje odecitani casu zraneni
 */
public class CasSeZranenim implements StrategieCasu{
    /**
     *  Odecte tolik casu v jake situaci je zrovna hrac
     * @param zaklad
     * @return
     */
    @Override
    public int spocteniCasu(int zaklad) {
        return zaklad-3;
    }
}
