package Zaklad;

import Cas.CasBloudeni;
import Cas.NormalniCas;

import java.util.Scanner;

public class Bludiste {
    Scanner sc = new Scanner(System.in);
    int urovenBludiste = 1;
    boolean vyselZbludiste = false;
    public void bludiste(Hra hra ){

        System.out.print(hra.getData().nacteniRadkuSouboru("Bludiste", "START",false));
        while (!vyselZbludiste) {
            String odpoved = sc.nextLine();
            switch(odpoved){
                case "doleva":
                    if (urovenBludiste == 1){
                        System.out.print(hra.getData().nacteniRadkuSouboru("Bludiste", "DOLEVA1",false));
                        hra.getCas().odecteniCasu();
                        urovenBludiste = 2;
                    }else if (urovenBludiste == 2){
                        System.out.print(hra.getData().nacteniRadkuSouboru("Bludiste", "DOLEVA2",false));
                        hra.getCas().setTempoCasu(new CasBloudeni());
                        hra.getCas().odecteniCasu();
                        urovenBludiste = 1;
                        hra.getCas().setTempoCasu(new NormalniCas());

                    }else if (urovenBludiste == 3){
                        System.out.print(hra.getData().nacteniRadkuSouboru("Bludiste", "DOLEVA3",false));
                        hra.getCas().setTempoCasu(new CasBloudeni());
                        hra.getCas().odecteniCasu();
                        hra.getCas().setTempoCasu(new NormalniCas());
                        urovenBludiste = 1;
                    }
                    break;
                case "doprava":
                    if (urovenBludiste == 1){
                        System.out.print(hra.getData().nacteniRadkuSouboru("Bludiste", "DOPRAVA1",false));
                        hra.getCas().setTempoCasu(new CasBloudeni());
                        hra.getCas().odecteniCasu();
                        urovenBludiste = 1;
                        hra.getCas().setTempoCasu(new NormalniCas());

                    }else if (urovenBludiste == 2){
                        System.out.print(hra.getData().nacteniRadkuSouboru("Bludiste", "DOPRAVA2",false));
                        hra.getCas().setTempoCasu(new CasBloudeni());
                        hra.getCas().odecteniCasu();
                        urovenBludiste = 1;
                        hra.getCas().setTempoCasu(new NormalniCas());

                    }else if (urovenBludiste == 3){
                        System.out.print(hra.getData().nacteniRadkuSouboru("Bludiste", "DOPRAVA3",false));
                        hra.getCas().odecteniCasu();
                        vyselZbludiste = true;
                        return;
                    }
                    break;
                case "rovne":
                    if (urovenBludiste == 1){
                        System.out.print(hra.getData().nacteniRadkuSouboru("Bludiste", "ROVNE1",false));
                        hra.getCas().setTempoCasu(new CasBloudeni());
                        hra.getCas().odecteniCasu();
                        urovenBludiste = 1;
                        hra.getCas().setTempoCasu(new NormalniCas());
                    }else if (urovenBludiste == 2){
                        System.out.print(hra.getData().nacteniRadkuSouboru("Bludiste", "ROVNE2",false));
                        hra.getCas().odecteniCasu();
                        urovenBludiste = 3;
                    }else if (urovenBludiste == 3){
                        System.out.print(hra.getData().nacteniRadkuSouboru("Bludiste", "ROVNE3",false));
                        hra.getCas().setTempoCasu(new CasBloudeni());
                        hra.getCas().odecteniCasu();
                        urovenBludiste = 1;
                        hra.getCas().setTempoCasu(new NormalniCas());
                    }
                    break;
            }
        }
    }
}