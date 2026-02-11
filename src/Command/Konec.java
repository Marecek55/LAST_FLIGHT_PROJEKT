package Command;

import Zaklad.Hra;
import Zaklad.StavKonce;
/**
 * Trida ktera vykonava command Konec
 * @author MAREK KULHÁNEK
 */
public class Konec implements Command {
    /**
     * Ukonci hru
     * @param hra hra
     * @param s druha cast inputu uzivatele
     * @return vypis
     */
    @Override
    public String vykonat(Hra hra, String s) {
        hra.setStavKonce(StavKonce.NEROZHODNUTO);
        hra.setJeKonec(true);
        return hra.getCervena("Hra se vypina...");


    }


}
