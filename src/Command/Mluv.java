package Command;

import Postavy.NPC;
import Postavy.Postava;
import Zaklad.Hra;

public class Mluv implements Command {
    @Override
    public void vykonat(Hra hra, String s) {
        NPC p = null;
        boolean nasel = false;
        for (int i = 0; i < hra.getAktualniMistnost().getNpcVMistnosti().size(); i++) {
            if (hra.getAktualniMistnost().getNpcVMistnosti().get(i).getJmeno().toLowerCase().equals(s.toLowerCase())) {
                 p = hra.getAktualniMistnost().getNpcVMistnosti().get(i);
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
