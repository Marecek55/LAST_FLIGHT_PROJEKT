package Command;

import Postavy.NPC;
import Zaklad.Hra;
import Zaklad.Predmet;

import java.util.ArrayList;


public class Dej implements Command {
    /**
     * Poda predmet npc z mistnosti a metoda kontroluje i vsechny mozne chyby uzivatele
     * @param hra instance hry aby se dala ovladat aktualni mistnost
     * @param s Druha cast inputu uzivatele
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
                return "Postava neni v mistnosti";
            }
            if (hra.getTretiCastPrikazu()== null){
                return "Musis zadat predmet ktery chces dat";
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
                    cilovaPostava.prijmutiPredmetu(cilovyPredmet, hra);
                    return "prijmul predmet";
                } else {
                    return "Predmet nemas v inventari";
                }
            }else {
                return "Zadal jsi neexistujici predmet";
            }
        }else {
            return "Nemas mistnost prozkoumanou";
        }






    }


}
