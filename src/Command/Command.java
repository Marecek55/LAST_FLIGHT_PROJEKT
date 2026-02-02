package Command;

import Zaklad.Hra;

public interface Command {
    /**
     * Vykona command
     * @param hra
     * @param s
     * @return
     */
    public String vykonat(Hra hra , String s);

}
