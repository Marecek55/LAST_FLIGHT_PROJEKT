package Command;

import Zaklad.Hra;

/**
 * Trida ktera vykonava command Pomoc
 * @author MAREK KULHÁNEK
 */
public class Pomoc implements Command {

    String zpravaReturnu  = "";
    /**
     * Vypise mu ze souboru navod na hru
     * @param hra instance hry aby se dala ovladat aktualni mistnost
     * @param s Druha cast inputu uzivatele
     * @return vypis
     */
    @Override
    public String vykonat(Hra hra, String s) {
        zpravaReturnu = hra.getFialova("POMOC NEBOLI NAVOD NA HRU")+"\n";
        zpravaReturnu = zpravaReturnu + hra.getData().nacteniRadkuSouboru("navodHry" ,"START", null).trim();
        return zpravaReturnu;
    }

}
