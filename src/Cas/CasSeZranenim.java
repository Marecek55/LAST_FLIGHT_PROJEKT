package Cas;
/**
 * Trida ktera urcuje odecitani casu zraneni
 * @author MAREK KULHÁNEK
 */
public class CasSeZranenim implements StrategieCasu{
    /**
     *  Odecte tolik casu v jake situaci je zrovna hrac
     * @param zaklad je zbyvajici cas
     * @return vraci odecteny cas
     */
    @Override
    public int spocteniCasu(int zaklad) {
        return zaklad-3;
    }
}
