package Zaklad;

import Cas.CasBloudeni;
import Cas.NormalniCas;

import java.util.Scanner;

public class Bludiste {
    Scanner sc = new Scanner(System.in);
    int urovenBludiste = 1;
    boolean vyselZbludiste = false;
    String zpravaReturnu = "";
    public String bludiste(Hra hra ){

        System.out.print(hra.getData().nacteniRadkuSouboru("Bludiste", "START",false));
        while (!vyselZbludiste) {
            String odpoved = sc.nextLine();
            switch(odpoved){
                case "doleva":
                    if (urovenBludiste == 1){
                        zpravaReturnu = hra.getData().nacteniRadkuSouboru("Bludiste", "DOLEVA1",false);
                        zpravaReturnu = zpravaReturnu+ "\n"+hra.getCas().odecteniCasu();
                        urovenBludiste = 2;
                        return zpravaReturnu;
                    }else if (urovenBludiste == 2){
                        hra.getCas().setTempoCasu(new CasBloudeni());
                        System.out.println(hra.getCas().odecteniCasu());
                        urovenBludiste = 1;
                        hra.getCas().setTempoCasu(new NormalniCas());
                        return hra.getData().nacteniRadkuSouboru("Bludiste", "DOLEVA2",false);

                    }else if (urovenBludiste == 3){
                        hra.getCas().setTempoCasu(new CasBloudeni());
                        System.out.println(hra.getCas().odecteniCasu());
                        hra.getCas().setTempoCasu(new NormalniCas());
                        urovenBludiste = 1;
                        return hra.getData().nacteniRadkuSouboru("Bludiste", "DOLEVA3",false);
                    }
                    break;
                case "doprava":
                    if (urovenBludiste == 1){
                        hra.getCas().setTempoCasu(new CasBloudeni());
                        System.out.println(hra.getCas().odecteniCasu());
                        urovenBludiste = 1;
                        hra.getCas().setTempoCasu(new NormalniCas());
                        return hra.getData().nacteniRadkuSouboru("Bludiste", "DOPRAVA1",false);

                    }else if (urovenBludiste == 2){
                        hra.getCas().setTempoCasu(new CasBloudeni());
                        System.out.println(hra.getCas().odecteniCasu());
                        urovenBludiste = 1;
                        hra.getCas().setTempoCasu(new NormalniCas());
                        return hra.getData().nacteniRadkuSouboru("Bludiste", "DOPRAVA2",false);

                    }else if (urovenBludiste == 3){
                        zpravaReturnu = hra.getData().nacteniRadkuSouboru("Bludiste", "DOPRAVA3",false);
                        zpravaReturnu =  zpravaReturnu+ "\n" +hra.getCas().odecteniCasu();
                        vyselZbludiste = true;
                        return zpravaReturnu;
                    }
                    break;
                case "rovne":
                    if (urovenBludiste == 1){
                        hra.getCas().setTempoCasu(new CasBloudeni());
                        hra.getCas().odecteniCasu();
                        urovenBludiste = 1;
                        hra.getCas().setTempoCasu(new NormalniCas());
                        return hra.getData().nacteniRadkuSouboru("Bludiste", "ROVNE1",false);
                    }else if (urovenBludiste == 2){
                        zpravaReturnu = hra.getData().nacteniRadkuSouboru("Bludiste", "ROVNE2",false);
                        zpravaReturnu = zpravaReturnu + "\n"+hra.getCas().odecteniCasu();
                        urovenBludiste = 3;
                        return zpravaReturnu;
                    }else if (urovenBludiste == 3){
                        hra.getCas().setTempoCasu(new CasBloudeni());
                        hra.getCas().odecteniCasu();
                        urovenBludiste = 1;
                        hra.getCas().setTempoCasu(new NormalniCas());
                        return hra.getData().nacteniRadkuSouboru("Bludiste", "ROVNE3",false);
                    }
                    break;
            }
        }
        return "Cyklus se nespustil";
    }
}