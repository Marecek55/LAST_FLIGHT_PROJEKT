package Command;

import Postavy.NPC;
import Zaklad.Hra;
import Zaklad.Predmet;

public class Dej implements Command {
    @Override
    public void vykonat(Hra hra, String s) {
        NPC cilovaPostava = null;
        Predmet cilovyPredmet = null;
        for (int i = 0; i < hra.getAktualniMistnost().getNpcVMistnosti().size(); i++) {
             if (hra.getAktualniMistnost().getNpcVMistnosti().get(i).getJmeno().equals(s)){
                 cilovaPostava = hra.getAktualniMistnost().getNpcVMistnosti().get(i);
             }
        }
        cilovyPredmet = hra.getData().najdiPredmet(hra.getJesteVetsiUpresneni());
        if (hra.getInventar().predmetJeVInventari(cilovyPredmet)){
            if (cilovaPostava.getOcekavanyPredmet().equals(cilovyPredmet)){
                cilovaPostava.setDostalToCoChtel(true);
                System.out.println("DOstal to ");
            }else {
                System.out.println("Toto "+ cilovyPredmet +" dana postava" + cilovaPostava+" nechce");
            }
        }else {
            System.out.println("Predmet nemas v inventari");
        }



    }


}
