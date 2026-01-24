package Command;

import Zaklad.Hra;

public class Prozkoumej implements Command {
    /**
     * Prozkouma mistnost a ukaze mu predmety a lidi v ni
     * @param hra instance hry aby se dala ovladat aktualni mistnost
     * @param s Druha cast inputu uzivatele
     */
    @Override
    public void vykonat(Hra hra, String s) {
        System.out.println("----PROZKOUMAVANI----");
        System.out.println("Lide v mistnosti:");
        if (hra.getAktualniMistnost().getNpcVMistnosti().size()>0){
            for (int i = 0; i < hra.getAktualniMistnost().getNpcVMistnosti().size(); i++) {
                System.out.println(hra.getAktualniMistnost().getNpcVMistnosti().get(i).getJmeno());
            }
            hra.getCas().odecteniCasu();
        }else {
            System.out.println("Nikdo v mistnosti neni");
        }
        if (hra.getAktualniMistnost().getPredmetyVMistnosti().size()>0){
            System.out.println("Predmety v mistnosti");
            for (int i = 0; i < hra.getAktualniMistnost().getPredmetyVMistnosti().size(); i++) {
                System.out.println(hra.getAktualniMistnost().getPredmetyVMistnosti().get(i).getNazev());
            }
            hra.getCas().odecteniCasu();
        }else {
            System.out.println("Zadny predmet v mistnosti neni");
        }



    }

}
