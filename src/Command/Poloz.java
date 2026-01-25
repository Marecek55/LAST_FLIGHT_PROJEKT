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
    public void vykonat(Hra hra, String s) {
        Predmet p = null;
        for (int i = 0; i < hra.getData().predmety.size(); i++) {
            if (hra.getData().predmety.get(i).getNazev().equals(s.toLowerCase())) {
                p = hra.getData().predmety.get(i);
            }
        }
        if (p == null) {
            System.out.println("Takovy predmet neni");
            return;
        }
        boolean nasel = false;
        if (p.isJdeVyhodit()){
            for (int i = 0; i < hra.getInventar().getListPredmetu().size(); i++) {
                if (s.toLowerCase().equals(hra.getInventar().getListPredmetu().get(i).getNazev())) {
                    hra.getInventar().odebratPredmet(p);
                    System.out.println("Vyhodil jsi " + p.getNazev());
                    if (p.isJeDulezity()) {
                        System.out.println("VYHODIL JSI DULEZITY PREDMET MUZES");

                    }
                    hra.getAktualniMistnost().pridatPredmetDoMistnosti(p);
                    hra.getCas().odecteniCasu();
                    nasel = true;
                }
            }
            if (!nasel){
                System.out.println("Predmet neni v inventari");
            }
        }else {
            System.out.println("Tento predmet nejde vyhodit");
        }

    }


}
