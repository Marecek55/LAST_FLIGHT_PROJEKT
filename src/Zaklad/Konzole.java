package Zaklad;

import java.util.Scanner;

public class Konzole {
    private Hra hra;

    Scanner sc = new Scanner(System.in);
    private boolean  exit= false;

    private void proved() {
        System.out.print(">>");
        String prikaz = sc.nextLine();
        prikaz = prikaz.trim();
        String[] rozdeleni = prikaz.split(" ");

            String nazevPrikazu = rozdeleni[0].toLowerCase();
            String upresneniPrikazu = "";
            if (rozdeleni.length > 1) {
                upresneniPrikazu = rozdeleni[1];
            }
        if (prikaz.toLowerCase().trim().equals("konec")) {

            exit = true;
        }
            if (hra.getPrikazy().containsKey(nazevPrikazu)) {
                hra.getPrikazy().get(nazevPrikazu).vykonat(hra,upresneniPrikazu);

            } else {
                System.out.println(">> Nedefinovany prikaz");
            }
        }




    public void spusteni(){
        hra = new Hra();
        proved();
            do {
                proved();
            } while (!exit);
    }

}
