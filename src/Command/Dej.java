package Command;

import Postavy.NPC;
import Zaklad.Hra;
import Zaklad.Predmet;


public class Dej implements Command {
    /**
     * Poda predmet npc z mistnosti a metoda kontroluje i vsechny mozne chyby uzivatele
     * @param hra instance hry aby se dala ovladat aktualni mistnost
     * @param s Druha cast inputu uzivatele
     */
    @Override
    public void vykonat(Hra hra, String s) {
        if (hra.getAktualniMistnost().isJeProzkoumana()){
            NPC cilovaPostava = null;
            Predmet cilovyPredmet = null;
            for (int i = 0; i < hra.getAktualniMistnost().getNpcVMistnosti().size(); i++) {
                if (hra.getAktualniMistnost().getNpcVMistnosti().get(i).getJmeno().toLowerCase().equals(s.toLowerCase())) {
                    cilovaPostava = hra.getAktualniMistnost().getNpcVMistnosti().get(i);
                }
            }
            if (cilovaPostava == null) {
                System.out.println("Postava neni v mistnosti");
                return;
            }
            if (hra.getTretiCastPrikazu()== null){
                System.out.println("Musis zadat predmet ktery chces dat");
                return;
            }
            boolean zadalSpravnePredmet = false;
            for (int i = 0; i < hra.getData().predmety.size(); i++) {
                if (hra.getData().predmety.get(i).getNazev().toLowerCase().equals(hra.getTretiCastPrikazu().toLowerCase())) {
                    zadalSpravnePredmet = true;
                }
            }
            if (zadalSpravnePredmet) {
                cilovyPredmet = hra.getData().najdiPredmet(hra.getTretiCastPrikazu());
                if (hra.getInventar().predmetJeVInventari(cilovyPredmet)) {
                    if (cilovyPredmet.equals(cilovaPostava.getOcekavanyPredmet())) {
                        cilovaPostava.setDostalToCoChtel(true);
                        hra.getInventar().odebratPredmet(cilovyPredmet);
                        System.out.println("Dal jsi " + cilovyPredmet.getNazev() + " tomuto cloveku " + cilovaPostava.getJmeno());
                        hra.getCas().odecteniCasu();
                    } else {
                        System.out.println("Tento predmet " + cilovyPredmet.getNazev() + " dana postava " + cilovaPostava.getJmeno() + " nechce");
                    }
                } else {
                    System.out.println("Predmet nemas v inventari");
                }
            }else {
                System.out.println("Zadal jsi neexistujici predmet");
            }
        }else {
            System.out.println("Nemas mistnost prozkoumanou");
            return;
        }






    }


}
