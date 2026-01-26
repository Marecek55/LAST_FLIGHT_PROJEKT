package Zaklad;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Souboj {
    private boolean vyhra;
    private AkceUnosce akceUnosce;
    Random rd = new Random();
    ArrayList<AkceUnosce> akce  =new ArrayList<>();

    boolean vyhralHrac;
    boolean vyhralUnosce;
    AkceUnosce aktualniAkce;
    Scanner sc = new Scanner(System.in);

    /**
     * Spousti souboj
     */
    public void souboj(Hra hra) {
        akce.add(AkceUnosce.KRYTY);
        akce.add(AkceUnosce.UTOCICI);
        akce.add(AkceUnosce.ODKRYTY);
        System.out.print(hra.getData().nacteniRadkuSouboru("Souboj" , 0, 5));
        while (!vyhralUnosce&&!vyhralHrac){
            if (hra.getUnosce().getZivoty()==0) {
                vyhralHrac = true;
            }
            if (hra.getCas().getZbyvajiciCas()<=0){
                vyhralUnosce = true;
            }
            aktualniAkce = akce.get(rd.nextInt(0,4));

            hra.getUnosce().setAkce(aktualniAkce);
            System.out.println("Akce unosc je " + aktualniAkce);
            System.out.print(">>");
            String prikaz = sc.nextLine();
            prikaz = prikaz.trim();
            if (prikaz.toLowerCase().equals("uhni")){
                hra.getPrikazy().get(prikaz).vykonat(hra, "");
                return;
            }else if (prikaz.toLowerCase().equals("utok")){
                hra.getPrikazy().get(prikaz).vykonat(hra, "");
                return;

            }else {
                if (aktualniAkce.toString().toLowerCase().equals("utocici")){
                    System.out.println("Nevyhovujici prikaz unosce te prastil ztratil jsi 10 minut");
                    hra.getCas().setZbyvajiciCas(hra.getCas().getZbyvajiciCas()-10);
                }else{
                    System.out.println("Spatny prikaz ale utocici nastesti neutocil");
                }

            }
        }




    }
}
