package Command;

import Postavy.NPC;
import Zaklad.Hra;

/**
 * Trida ktera vykonava command Mluv
 */
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
            try {
                if (hra.getAktualniMistnost().getNpcVMistnosti().contains(hra.getData().najdiNPC(s.toLowerCase()))){
                    p = hra.getData().najdiNPC(s.toLowerCase());
                    if (p.isChceMluvit()) {
                        System.out.println(p.getTypMluveni().pozdrav());
                        hra.getKomunikace().komunikace(p, hra);
                        System.out.println(p.getTypMluveni().rozlouceni());
                        return hra.getCas().odecteniCasu(hra);
                    }
                    else {
                        return hra.getCervena("Tento clovek s tebou ted nechce mluvit");
                    }

                } else {
                    return hra.getCervena("Tento clovek neni v mistnosti");
                }
            }catch (Exception e){
                return hra.getCervena("Tento clovek neni v mistnosti");
            }



        }else {
            return hra.getModra("Nemas mistnost prozkoumanou");
        }

        }



}
