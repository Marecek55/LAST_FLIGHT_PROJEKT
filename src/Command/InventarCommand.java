package Command;

import Zaklad.Hra;
import Zaklad.Predmet;

import java.util.Scanner;

public class InventarCommand implements Command {
    /**
     * Da na vyber uzivateli co chce delat s inventarem a bud odstrani nebo zobrazi veci
     * @param hra instance hry aby se dala ovladat aktualni mistnost
     * @param s Druha cast inputu uzivatele
     */
    @Override
    public void vykonat(Hra hra, String s) {
        Scanner sc = new Scanner(System.in);
        System.out.println("-----TOTO JE TVUJ INVENTAR-----");
        System.out.println("ZVOL AKCI\nZobrazeni\nOdstraneni\nNapis svoji volbu:");
        switch (sc.next().toLowerCase()) {
            case "zobrazeni":
                System.out.println("V inventari mas");
                hra.getInventar().zobrazeniInventare();
                break;
                case "odstraneni":
                    System.out.println("Co chces odstranit napis jmeno");
                    for (int i = 0; i < hra.getInventar().getListPredmetu().size(); i++) {
                        System.out.println(hra.getInventar().getListPredmetu().get(i).getNazev() + " jde vyhodit " + hra.getInventar().getListPredmetu().get(i).isJdeVyhoditText());
                    }
                    String odpoved = sc.next();
                    Predmet p = null;
                    for (int i = 0; i < hra.getData().predmety.size(); i++) {
                        if (hra.getData().predmety.get(i).getNazev().equals(odpoved.toLowerCase())) {
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
                            if (odpoved.toLowerCase().equals(hra.getInventar().getListPredmetu().get(i).getNazev())) {
                                hra.getInventar().odebratPredmet(p);
                                System.out.println("Vyhodil jsi " + p.getNazev());
                                if (p.isJeDulezity()) {
                                    System.out.println("VYHODIL JSI DULEZITY PREDMET MUZES HO SEBRAT V MISTNOSTI");

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
                    break;
                    default:
                        System.out.println("Neplatna volba");
                        break;


        }

    }


}
