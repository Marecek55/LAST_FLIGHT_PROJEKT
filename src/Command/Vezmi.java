package Command;

import Zaklad.Hra;
import Zaklad.Predmet;

public class Vezmi implements Command {
    /**
     * Vezme predmet z mistnosti do inventare
     * @param hra instance hry aby se dala ovladat aktualni mistnost
     * @param s Druha cast inputu uzivatele
     */
    @Override
    public void vykonat(Hra hra, String s) {
        Predmet p = null;
        for (int i = 0; i < hra.getAktualniMistnost().getPredmetyVMistnosti().size(); i++) {
            if (hra.getAktualniMistnost().getPredmetyVMistnosti().get(i).getNazev().toLowerCase().equals(s.toLowerCase())) {
                p = hra.getAktualniMistnost().getPredmetyVMistnosti().get(i);
                break;
            }
        }
        if (p == null) {
            System.out.println("Predmet neni v mistnosti");
            return;
        }else {
            System.out.println("Vzal jsi " + p.getNazev());
            hra.getInventar().pridatPredmet(p);


        }
    }

}
