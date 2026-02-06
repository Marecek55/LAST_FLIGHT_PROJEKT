package Command;

import Zaklad.Hra;
/**
 * Trida ktera vykonava commandy
 */
public interface Command {
    /**
     * Vykona command
     * @param hra
     * @param s
     * @return
     */
    public String vykonat(Hra hra , String s);

}
