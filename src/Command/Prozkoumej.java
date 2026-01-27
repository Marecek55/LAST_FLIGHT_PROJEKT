package Command;

import Zaklad.Hra;

public class Prozkoumej implements Command {
    boolean mistnostUzJednouProzkoumal = false;
    /**
     * Prozkouma mistnost a ukaze mu predmety a lidi v ni
     * @param hra instance hry aby se dala ovladat aktualni mistnost
     * @param s Druha cast inputu uzivatele
     */
    @Override
    public void vykonat(Hra hra, String s) {
//        if (!mistnostUzJednouProzkoumal){
            System.out.println("----PROZKOUMAVANI----");

            boolean jsouTamLidi = false;
            boolean jsouTamPredmety = false;

            if (hra.getAktualniMistnost().getNpcVMistnosti().size()>0){
                System.out.println("Lide v mistnosti:");
                for (int i = 0; i < hra.getAktualniMistnost().getNpcVMistnosti().size(); i++) {
                    System.out.println(hra.getAktualniMistnost().getNpcVMistnosti().get(i).getJmeno());
                }
                hra.getAktualniMistnost().setJeProzkoumana(true);

                jsouTamLidi = true;
            }else {
                System.out.println("Nikdo v mistnosti neni");
            }
            if (hra.getAktualniMistnost().getPredmetyVMistnosti().size()>0){
                System.out.println("Predmety v mistnosti");
                for (int i = 0; i < hra.getAktualniMistnost().getPredmetyVMistnosti().size(); i++) {
                    System.out.println(hra.getAktualniMistnost().getPredmetyVMistnosti().get(i).getNazev());
                }
                hra.getAktualniMistnost().setJeProzkoumana(true);

                jsouTamPredmety = true;

            }else {
                System.out.println("Zadny predmet v mistnosti neni");

            }
            if (hra.getAktualniMistnost().getDostupneVychody().size()>0) {
            System.out.println("Dostupne vychody");
            for (int i = 0; i < hra.getAktualniMistnost().getDostupneVychody().size(); i++) {
                System.out.println(hra.getAktualniMistnost().getDostupneVychody().get(i));
            }
        }
            if (jsouTamLidi && jsouTamPredmety){
                hra.getCas().odecteniCasu();

            }else if (jsouTamLidi&& !jsouTamPredmety){
                hra.getCas().odecteniCasu();

            }else if (jsouTamPredmety && !jsouTamLidi){
                hra.getCas().odecteniCasu();
            }
            mistnostUzJednouProzkoumal = true;


    }

}
