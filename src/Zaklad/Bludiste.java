package Zaklad;

import Cas.CasBloudeni;
import Cas.NormalniCas;

import java.util.Scanner;


public class Bludiste {

    int urovenBludiste = 1;
    boolean vyselZbludiste = false;
    String zpravaReturnu = "";
    public String bludiste(Hra hra ){

        System.out.print(hra.getData().nacteniRadkuSouboru("bludiste", "START",null));

            String odpoved = hra.getKonzole().getSc().nextLine().toLowerCase();
            switch(odpoved){
                case "doleva":
                    if (urovenBludiste == 1){
                        zpravaReturnu = hra.getData().nacteniRadkuSouboru("bludiste", "DOLEVA1",null);
                        zpravaReturnu = zpravaReturnu+ "\n"+hra.getCas().odecteniCasu();
                        urovenBludiste = 2;
                        return zpravaReturnu;
                    }else if (urovenBludiste == 2){
                        hra.getCas().setTempoCasu(new CasBloudeni());
                        System.out.println(hra.getCas().odecteniCasu());
                        urovenBludiste = 1;
                        hra.getCas().setTempoCasu(new NormalniCas());
                        return hra.getData().nacteniRadkuSouboru("bludiste", "DOLEVA2",null);

                    }else if (urovenBludiste == 3){
                        hra.getCas().setTempoCasu(new CasBloudeni());
                        System.out.println(hra.getCas().odecteniCasu());
                        hra.getCas().setTempoCasu(new NormalniCas());
                        urovenBludiste = 1;
                        return hra.getData().nacteniRadkuSouboru("bludiste", "DOLEVA3",null);
                    }
                    break;
                case "doprava":
                    if (urovenBludiste == 1){
                        hra.getCas().setTempoCasu(new CasBloudeni());
                        System.out.println(hra.getCas().odecteniCasu());
                        urovenBludiste = 1;
                        hra.getCas().setTempoCasu(new NormalniCas());
                        return hra.getData().nacteniRadkuSouboru("bludiste", "DOPRAVA1",null);

                    }else if (urovenBludiste == 2){
                        hra.getCas().setTempoCasu(new CasBloudeni());
                        System.out.println(hra.getCas().odecteniCasu());
                        urovenBludiste = 1;
                        hra.getCas().setTempoCasu(new NormalniCas());
                        return hra.getData().nacteniRadkuSouboru("bludiste", "DOPRAVA2",null);

                    }else if (urovenBludiste == 3){
                        zpravaReturnu = hra.getData().nacteniRadkuSouboru("bludiste", "DOPRAVA3",null);
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
                        return hra.getData().nacteniRadkuSouboru("bludiste", "ROVNE1",null);
                    }else if (urovenBludiste == 2){
                        zpravaReturnu = hra.getData().nacteniRadkuSouboru("bludiste", "ROVNE2",null);
                        zpravaReturnu = zpravaReturnu + "\n"+hra.getCas().odecteniCasu();
                        urovenBludiste = 3;
                        return zpravaReturnu;
                    }else if (urovenBludiste == 3){
                        hra.getCas().setTempoCasu(new CasBloudeni());
                        hra.getCas().odecteniCasu();
                        urovenBludiste = 1;
                        hra.getCas().setTempoCasu(new NormalniCas());
                        return hra.getData().nacteniRadkuSouboru("bludiste", "ROVNE3",null);
                    }
                    break;
                default:
                    return "Spatne zadano";
            }

        return "Cyklus se nespustil";
    }
}