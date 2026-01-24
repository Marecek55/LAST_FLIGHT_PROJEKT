package Command;

import Postavy.NPC;
import Postavy.Postava;
import Zaklad.Hra;

public class Mluv implements Command {
    /**
     * Mluvi s postavou v dane mistnosti
     * @param hra instance hry aby se dala ovladat aktualni mistnost
     * @param s Druha cast inputu uzivatele
     */
    @Override
    public void vykonat(Hra hra, String s) {
        NPC p = null;
        boolean nasel = false;
        for (int i = 0; i < hra.getAktualniMistnost().getNpcVMistnosti().size(); i++) {
            if (hra.getAktualniMistnost().getNpcVMistnosti().get(i).getJmeno().toLowerCase().equals(s.toLowerCase())) {
                 p = hra.getAktualniMistnost().getNpcVMistnosti().get(i);
                 hra.getData().nacteniPribehuPostavAMistnosti(s, true );
                System.out.println(p.getDialog());

                 hra.getCas().odecteniCasu();
                 nasel = true;
                 break;
            }
        }
        if (!nasel) {
            System.out.println("Tento clovek neni v mistnosti");
            return;
        }
        p.getDialog();



    }

}
