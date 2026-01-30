package Command;

import Zaklad.AkceUnosce;
import Zaklad.Hra;

public class Utok implements Command {
    /**
     * Pokud je unosce odkryty ubere  mu zivoty
     * @param hra instance hry aby se dala ovladat aktualni mistnost
     * @param s Druha cast inputu uzivatele
     */
    @Override
    public String vykonat(Hra hra, String s) {
        if (hra.getUnosce().getAkce() != null){
            AkceUnosce akce = hra.getUnosce().getAkce();
            if (akce.equals(AkceUnosce.ODKRYTY)){
                hra.getUnosce().setZivoty(hra.getUnosce().getZivoty() - 1);
                return hra.getZelena("Prastil jsi unosce primo do obliceje");

            }else if (akce.equals(AkceUnosce.KRYTY)){
                return hra.getZluta("Unosce byl " + akce + " nic jsi  mu nezpusobil");
            } else if (akce.equals(AkceUnosce.UTOCICI)) {
                hra.getCas().setZbyvajiciCas(hra.getCas().getZbyvajiciCas() - 10);
                return hra.getCervena("Unosce byl " + akce + " nic jsi  mu nezpusobil a dostavas penalizaci 10 minut");
            }else {
                return hra.getCervena("Zadna akce");
            }

        }else {
            return hra.getCervena("Nejsi v souboji");
        }
        }


}
