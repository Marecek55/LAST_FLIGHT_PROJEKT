package Zaklad;

import java.util.Scanner;

public class Konzole {
    private Hra hra;


    Scanner sc = new Scanner(System.in);

    /**
     * Rozdeli prikaz od uzivatele na dve casti a zavola ho
     */
    private void provadeniPrikazu() {
        System.out.print(">>");
        String prikaz = sc.nextLine();
        prikaz = prikaz.trim();
        String[] rozdeleni = prikaz.split(" ");
            String nazevPrikazu = rozdeleni[0].toLowerCase();
            String upresneniPrikazu = "";
            if (rozdeleni.length > 1) {
                upresneniPrikazu = rozdeleni[1];
                hra.setJesteVetsiUpresneni(rozdeleni[2]);
            }
            if (hra.getPrikazy().containsKey(nazevPrikazu)) {
                hra.getPrikazy().get(nazevPrikazu).vykonat(hra,upresneniPrikazu);

            } else {
                System.out.println(">> Nedefinovany prikaz");
            }
        }


    /**
     * spusti hru a jede v cyklu dokud neni konec nebo uzivatel nenapise prikaz konec
     */
    public void spusteni(){
        hra = new Hra();
            do {
                provadeniPrikazu();
            } while (!hra.isJeKonec());
    }

}
