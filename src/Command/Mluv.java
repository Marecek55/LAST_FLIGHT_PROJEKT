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
    public void vykonat(Hra hra, String s) {
        if (hra.getAktualniMistnost().isJeProzkoumana()){
            NPC p = null;
            boolean nasel = false;
            for (int i = 0; i < hra.getAktualniMistnost().getNpcVMistnosti().size(); i++) {
                if (hra.getAktualniMistnost().getNpcVMistnosti().get(i).getJmeno().toLowerCase().equals(s.toLowerCase())) {
                    p = hra.getAktualniMistnost().getNpcVMistnosti().get(i);
//                    hra.getData().nacteniPribehuPostavAMistnosti(s, true );
                    if (p.isChceMluvit()){
                        System.out.println(p.getTypMluveni().pozdrav());
                        hra.getKomunikace().komunikace(p,hra);
                        System.out.println(p.getTypMluveni().rozlouceni());
                        hra.getCas().odecteniCasu();
                        nasel = true;
                        break;
                    }else {
                        System.out.println("Tento clovek s tebou ted nechce mluvit");
                        return;
                    }

                }
            }
            if (!nasel) {
                System.out.println("Tento clovek neni v mistnosti");
                return;
            }

        }else {
            System.out.println("Nemas mistnost prozkoumanou");
            return;
        }
        }


}
