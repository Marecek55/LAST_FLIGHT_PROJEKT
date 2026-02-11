package Command;

import Postavy.NPC;
import Zaklad.Hra;
import Zaklad.Predmet;

import java.util.ArrayList;

/**
 * Trida ktera vykonava command Dej
 * @author MAREK KULHÁNEK
 */
public class Dej implements Command {
    /**
     * Poda predmet npc z mistnosti a metoda kontroluje i vsechny mozne chyby uzivatele
     * @param hra instance hry aby se dala ovladat aktualni mistnost
     * @param s Druha cast inputu uzivatele
     * @return vypis
     */

    @Override
    public String vykonat(Hra hra, String s) {
        if (hra.getAktualniMistnost().isJeProzkoumana()){
            NPC cilovaPostava = null;
            Predmet cilovyPredmet = null;
            ArrayList <NPC>npcVMistnosti = hra.getAktualniMistnost().getNpcVMistnosti();
            for (int i = 0; i < npcVMistnosti.size(); i++) {
                if (npcVMistnosti.get(i).getJmeno().toLowerCase().equals(s.toLowerCase())) {
                    cilovaPostava = npcVMistnosti.get(i);
                }
            }
            if (cilovaPostava == null) {
                return hra.getCervena("Postava neni v mistnosti");
            }
            if (hra.getTretiCastPrikazu()== null){
                return hra.getCervena("Musis zadat predmet ktery chces dat");
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
                    System.out.println(cilovaPostava.prijmutiPredmetu(cilovyPredmet, hra));
                    return hra.getTyrkysova("Dal jsi ruku zpet");

                } else {
                    return hra.getCervena("Predmet nemas v inventari");
                }
            }else {

                return  hra.getCervena("Zadal jsi neexistujici predmet");
            }
        }else {

            return hra.getCervena("Nemas mistnost prozkoumanou");
        }







    }


}
