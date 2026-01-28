package Command;

import Postavy.Unosce;
import Zaklad.AkceUnosce;
import Zaklad.Hra;

public class Uhni implements Command {
    /**
     * Pokud unosce utoci uhne utoku
     * @param hra instance hry aby se dala ovladat aktualni mistnost
     * @param s Druha cast inputu uzivatele
     */

    @Override
    public String vykonat(Hra hra, String s) {

        if (hra.getUnosce().getAkce() != null){
            AkceUnosce akce = hra.getUnosce().getAkce();
            if (akce.equals(AkceUnosce.UTOCICI)) {
                return "Uhnul jsi utoku";
            }else if (akce.equals(AkceUnosce.KRYTY)){
                return "Uhnul jsi krytemu unosci nic se nestalo";
            } else {
                hra.getCas().setZbyvajiciCas(hra.getCas().getZbyvajiciCas() - 10);
                return "Utocici zrovna neutocil MAS PENALIZACI 10 minut";
            }
        }else {
            return "Nejsi v souboji";

        }
    }


}
