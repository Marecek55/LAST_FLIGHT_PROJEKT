package Command;

import Zaklad.Hra;
import Zaklad.Predmet;

public class Poloz implements Command {
    /**
     * Polozi predmet do mistnosti ve ktere je
     * @param hra instance hry aby se dala ovladat aktualni mistnost
     * @param s Druha cast inputu uzivatel
     */
    @Override
    public String vykonat(Hra hra, String s) {
        Predmet p = null;
        for (int i = 0; i < hra.getData().predmety.size(); i++) {
            if (hra.getData().predmety.get(i).getNazev().equals(s.toLowerCase())) {
                p = hra.getData().predmety.get(i);
            }
        }
        if (p == null) {
            return "Takovy predmet neni";
        }
        boolean nasel = false;
        if (p.isJdeVyhodit()){
            for (int i = 0; i < hra.getInventar().getListPredmetu().size(); i++) {
                if (s.toLowerCase().equals(hra.getInventar().getListPredmetu().get(i).getNazev())) {
                    hra.getInventar().odebratPredmet(p);
                    String zpravaReturnu = "Vyhodil jsi " + p.getNazev();
                    if (p.isJeDulezity()) {
                        zpravaReturnu = zpravaReturnu + "\nVYHODIL JSI DULEZITY PREDMET MUZES";
                    }
                    hra.getAktualniMistnost().pridatPredmetDoMistnosti(p);
                    System.out.println(hra.getCas().odecteniCasu());
                    nasel = true;
                    return zpravaReturnu;
                }
            }
            if (!nasel){
                return "Predmet neni v inventari";
            }
        }else {
            return "Tento predmet nejde vyhodit";
        }
        return "Takovy predmet neni";

    }


}
