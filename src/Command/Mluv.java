package Command;

import Postavy.NPC;
import Postavy.Postava;
import Zaklad.Hra;

import java.util.Scanner;

public class Mluv implements Command {
    /**
     * Mluvi s postavou v dane mistnosti
     * @param hra instance hry aby se dala ovladat aktualni mistnost
     * @param s Druha cast inputu uzivatele
     */
    @Override
    public String vykonat(Hra hra, String s) {
        if (hra.getAktualniMistnost().isJeProzkoumana()){
            NPC p = null;
                if (hra.getAktualniMistnost().getNpcVMistnosti().contains(hra.getData().najdiNPC(s.toLowerCase()))){
                    p = hra.getData().najdiNPC(s.toLowerCase());
                    if (p.isChceMluvit()) {
                        System.out.println(p.getTypMluveni().pozdrav());
                        hra.getKomunikace().komunikace(p, hra);
                        System.out.println(p.getTypMluveni().rozlouceni());
                        hra.getCas().odecteniCasu();
                        return "Odchazis";
                }
                    else {
                        return "Tento clovek s tebou ted nechce mluvit";
                    }

        } else {
                    return "Tento clovek neni v mistnosti";
                }


        }else {
            return "Nemas mistnost prozkoumanou";
        }

        }



}
