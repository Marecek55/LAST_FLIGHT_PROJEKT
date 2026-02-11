package Zaklad;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
/**
 * Trida ktera spousit souboj
 * @author MAREK KULHÁNEK
 */
public class Souboj {
    private boolean vyhra;
    private AkceUnosce akceUnosce;
    Random rd = new Random();
    ArrayList<AkceUnosce> akce  =new ArrayList<>();

    boolean vyhralHrac = false;
    boolean vyhralUnosce= false;
    AkceUnosce aktualniAkce;


    /**
     * Spousti souboj a celou jeho logiku. Probiha po kolech
     * a jsou tam 3 varianty akce unosce na ktere musi hrac
     * spravne zareagovat
     * @param hra instance hry aby mela metoda pristup ke hre
     * @return vraci vysledek souboje
     */
    public String souboj(Hra hra) {
        akce.add(AkceUnosce.KRYTY);
        akce.add(AkceUnosce.UTOCICI);
        akce.add(AkceUnosce.ODKRYTY);
        System.out.print(hra.getData().nacteniRadkuSouboru("Souboj" , "SOUBOJ", null));
        while (!vyhralUnosce&&!vyhralHrac){

            aktualniAkce = akce.get(rd.nextInt(akce.size()));

            hra.getUnosce().setAkce(aktualniAkce);
            System.out.println(hra.getFialova("Akce unosce je ") + aktualniAkce);
            System.out.print(">>");
            String prikaz = hra.getKonzole().getSc().nextLine();
            prikaz = prikaz.trim();
            if (prikaz.toLowerCase().equals("uhni")){
                System.out.println(hra.getPrikazy().get(prikaz).vykonat(hra, ""));

            }else if (prikaz.toLowerCase().equals("utok")){
                System.out.println(hra.getPrikazy().get(prikaz).vykonat(hra, ""));


            }else {
                if (aktualniAkce.toString().toLowerCase().equals("utocici")){

                    hra.getCas().setZbyvajiciCas(hra.getCas().getZbyvajiciCas()-10);
                    System.out.println(hra.getCervena("Nevyhovujici prikaz unosce te prastil ztratil jsi 10 minut"));
                }else{
                    System.out.println(hra.getZluta("Spatny prikaz ale utocici nastesti neutocil"));

                }

            }
            if (hra.getUnosce().getZivoty()<=0) {
                vyhralHrac = true;
            }
            if (hra.getCas().getZbyvajiciCas()<=0){
                vyhralUnosce = true;
            }
            if (!vyhralHrac && !vyhralUnosce) {
                System.out.println("Zivoty unosce " + hra.getUnosce().getZivoty());
                System.out.println(hra.getCas().odecteniCasu(hra));
            }
        }
        if (vyhralHrac) {
            return hra.getZelena("VYHRA UTIKEJ ZA RODINOU!");
        } else {
            hra.setJeKonec(true);
            return hra.getCervena("DOSEL TI CAS UNOSCE TE ZMLATIL.");
        }




    }
}
