package Command;

import Zaklad.Hra;
/**
 * Trida ktera vykonava commandy
 * @author MAREK KULHÁNEK
 */
public interface Command {
    /**
     * Vykona command
     * @param hra instance hry aby se dala ovladat aktualni mistnost
     * @param s Druha cast inputu uzivatele
     * @return vypis
     */
    public String vykonat(Hra hra , String s);

}
