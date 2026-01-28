package Command;

import Zaklad.Hra;

import java.util.Scanner;

public class Pomoc implements Command {
    /**
     * Vypise mu ze souboru navod na hru
     * @param hra instance hry aby se dala ovladat aktualni mistnost
     * @param s Druha cast inputu uzivatele
     */
    String zpravaReturnu  = "";
    @Override
    public String vykonat(Hra hra, String s) {
        zpravaReturnu = "POMOC NEBOLI NAVOD NA HRU ";
        zpravaReturnu = zpravaReturnu + hra.getData().nacteniRadkuSouboru("navodHry" ,"START", null).trim();
        return zpravaReturnu;
    }

}
