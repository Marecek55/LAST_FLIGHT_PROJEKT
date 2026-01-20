package Command;

import Zaklad.Hra;
import Zaklad.Mistnost;
import Zaklad.NacitaniZeSouboru;

public class Jdi implements Command {
    @Override
    public void vykonat(Hra hra, String s) {
        if (hra.getAktualniMistnost().getDostupneVychody().contains(s)){
            Mistnost cilova = hra.getData().najdiMistnost(s);
            if (!cilova.isJeZamcena()){
                hra.setAktualniMistnost(cilova);
                System.out.println(cilova.getPribeh());
            }else {
                System.out.println("Mistnost je zamcena");
            }

            }else {
            System.out.println("Mistnost neni sousedni");
        }
        }
    }


