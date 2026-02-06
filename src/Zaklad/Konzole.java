package Zaklad;

import java.util.Scanner;
/**
 * Trida Konzole spousti hru a rozdeluje prikazy
 */
public class Konzole {
    private Hra hra;


     private Scanner sc;

    public Konzole() {
        sc= new Scanner(System.in);
    }

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
            }
            if (rozdeleni.length > 2) {
                hra.setTretiCastPrikazu(rozdeleni[2]);
            }
            if (hra.getPrikazy().containsKey(nazevPrikazu)) {
                System.out.println(hra.getPrikazy().get(nazevPrikazu).vykonat(hra,upresneniPrikazu));

            } else {
                System.out.println(hra.getCervena(">> Nedefinovany prikaz"));
            }
        }


    /**
     * spusti hru a jede v cyklu dokud neni konec nebo uzivatel nenapise prikaz konec
     */
    public void spusteni(){
        hra = new Hra();
            do {
                provadeniPrikazu();
                System.out.println("----------------------------------------------------------------------------------------------------------------");

            } while (!hra.isJeKonec());
    }

    public Scanner getSc() {
        return sc;
    }

    public void setSc(Scanner sc) {
        this.sc = sc;
    }
}
