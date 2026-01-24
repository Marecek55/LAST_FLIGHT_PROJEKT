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
    public void vykonat(Hra hra, String s) {
        if (hra.getUnosce().getAkce().equals(AkceUnosce.ODKRYTY)){
            System.out.println("Prastil jsi unosce primo do obliceje");
            hra.getUnosce().setZivoty(hra.getUnosce().getZivoty() - 10);
        }else if (hra.getUnosce().getAkce().equals(AkceUnosce.KRYTY)){
            System.out.println("Unosce byl " + hra.getUnosce().getAkce() + " nic jsi  mu nezpusobil");
        } else if (hra.getUnosce().getAkce().equals(AkceUnosce.UTOCICI)) {
            System.out.println("Unosce byl " + hra.getUnosce().getAkce() + " nic jsi  mu nezpusobil a dostavas penalizaci 10 minut");
            hra.getCas().setZbyvajiciCas(hra.getCas().getZbyvajiciCas() - 10);
        }

    }

}
