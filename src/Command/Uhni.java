package Command;

import Postavy.Unosce;
import Zaklad.AkceUnosce;
import Zaklad.Hra;
/**
 * Pokud unosce utoci uhne utoku
 * @param hra instance hry aby se dala ovladat aktualni mistnost
 * @param s Druha cast inputu uzivatele
 */

public class Uhni implements Command {
    @Override
    public void vykonat(Hra hra, String s) {
        if (hra.getUnosce().getAkce().equals(AkceUnosce.UTOCICI)) {
            System.out.println("Uhnul jsi utoku");
        }else {
            System.out.println("Utocici zrovna neutocil MAS PENALIZACI 10 minut");
            hra.getCas().setZbyvajiciCas(hra.getCas().getZbyvajiciCas() - 10);
        }
    }


}
