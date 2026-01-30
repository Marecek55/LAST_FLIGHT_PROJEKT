package Command;

import Zaklad.Hra;
import Zaklad.Predmet;

import java.util.Scanner;

public class InventarCommand implements Command {
    /**
     * Zobrazi inventar a veci v mem
     * @param hra instance hry aby se dala ovladat aktualni mistnost
     * @param s Druha cast inputu uzivatele
     */
    @Override
    public String vykonat(Hra hra, String s) {
        System.out.println(hra.getFialova("-----TOTO JE TVUJ INVENTAR-----"));
                hra.getInventar().zobrazeniInventare();
                System.out.println("Zbyva ti " + hra.getCas().getZbyvajiciCas() +  " minut");
                return hra.getTyrkysova("Zaviras inventar");

    }


}
