package Command;

import Zaklad.Hra;
import Zaklad.Predmet;

import java.util.ArrayList;

public class Vezmi implements Command {
    /**
     * Vezme predmet z mistnosti do inventare
     * @param hra instance hry aby se dala ovladat aktualni mistnost
     * @param s Druha cast inputu uzivatele
     */
    @Override
    public String vykonat(Hra hra, String s) {
        ArrayList<Predmet> predmetyPomocne= hra.getAktualniMistnost().getPredmetyVMistnosti();
        if (hra.getAktualniMistnost().isJeProzkoumana()){
            Predmet p = null;
            for (int i = 0; i < predmetyPomocne.size(); i++) {
                if (predmetyPomocne.get(i).getNazev().toLowerCase().equals(s.toLowerCase())) {
                    p = predmetyPomocne.get(i);
                    break;
                }

            }
            if (p == null) {
                return hra.getCervena("Predmet neni v mistnosti");
            }else {
                if (hra.getInventar().getListPredmetu().size() >= hra.getInventar().getKapacita()) {
                    return hra.getCervena("MAS PLNOU KAPACITU! Musis nejdriv neco polozit");
                }
                hra.getInventar().pridatPredmet(p);
                System.out.println(hra.getCas().odecteniCasu(hra));
                predmetyPomocne.remove(p);
                return hra.getModra("Vzal jsi ") + p.getNazev();


            }
        }else {
            return "Nemas mistnost prozkoumanou";
        }
        }


}
