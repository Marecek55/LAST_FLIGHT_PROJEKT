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
        System.out.println("-----TOTO JE TVUJ INVENTAR-----");

                System.out.println("V inventari mas");
                hra.getInventar().zobrazeniInventare();
                return "Zaviras inventar";

    }


}
