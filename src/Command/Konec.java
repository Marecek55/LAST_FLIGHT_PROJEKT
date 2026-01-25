package Command;

import Zaklad.Hra;
import Zaklad.StavKonce;

public class Konec implements Command {
    /**
     * Ukonci hru
     * @param hra hra
     * @param s druha cast inputu uzivatele
     */
    @Override
    public void vykonat(Hra hra, String s) {
        System.out.print("Hra se vypina...");
        hra.setStavKonce(StavKonce.NEROZHODNUTO);
        hra.setJeKonec(true);


    }


}
