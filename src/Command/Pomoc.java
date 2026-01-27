package Command;

import Zaklad.Hra;

import java.util.Scanner;

public class Pomoc implements Command {
    /**
     * Vypise mu ze souboru navod na hru
     * @param hra instance hry aby se dala ovladat aktualni mistnost
     * @param s Druha cast inputu uzivatele
     */
    @Override
    public void vykonat(Hra hra, String s) {
        System.out.print("POMOC NEBOLI NAVOD NA HRU \n");
        System.out.print(hra.getData().nacteniRadkuSouboru("NavodHry" ,"START", false));
    }

}
