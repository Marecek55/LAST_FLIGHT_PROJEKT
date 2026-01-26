package Zaklad;

import Cas.CasBloudeni;
import Cas.NormalniCas;

import java.util.Scanner;

public class Bludiste {
    Scanner sc = new Scanner(System.in);
    int urovenBludiste = 1;
    boolean vyselZbludiste = false;
    public void bludiste(Hra hra ){

        System.out.print(hra.getData().nacteniRadkuSouboru("Bludiste", 1,6));
        while (!vyselZbludiste) {
            String odpoved = sc.nextLine();
            switch(odpoved){
                case "doleva":
                    if (urovenBludiste == 1){
                        System.out.print(hra.getData().nacteniRadkuSouboru("Bludiste", 7,10));
                        hra.getCas().odecteniCasu();
                        urovenBludiste = 2;
                    }else if (urovenBludiste == 2){
                        System.out.print(hra.getData().nacteniRadkuSouboru("Bludiste", 14,15));
                        hra.getCas().setTempoCasu(new CasBloudeni());
                        hra.getCas().odecteniCasu();
                        urovenBludiste = 1;
                        hra.getCas().setTempoCasu(new NormalniCas());

                    }else if (urovenBludiste == 3){
                        System.out.print(hra.getData().nacteniRadkuSouboru("Bludiste", 23,23));
                        hra.getCas().setTempoCasu(new CasBloudeni());
                        hra.getCas().odecteniCasu();
                        hra.getCas().setTempoCasu(new NormalniCas());
                        urovenBludiste = 1;
                    }
                    break;
                case "doprava":
                    if (urovenBludiste == 1){
                        System.out.print(hra.getData().nacteniRadkuSouboru("Bludiste", 12,13));
                        hra.getCas().setTempoCasu(new CasBloudeni());
                        hra.getCas().odecteniCasu();
                        urovenBludiste = 1;
                        hra.getCas().setTempoCasu(new NormalniCas());

                    }else if (urovenBludiste == 2){
                        System.out.print(hra.getData().nacteniRadkuSouboru("Bludiste", 20,21));
                        hra.getCas().setTempoCasu(new CasBloudeni());
                        hra.getCas().odecteniCasu();
                        urovenBludiste = 1;
                        hra.getCas().setTempoCasu(new NormalniCas());

                    }else if (urovenBludiste == 3){
                        System.out.print(hra.getData().nacteniRadkuSouboru("Bludiste", 22,22));
                        hra.getCas().odecteniCasu();
                        vyselZbludiste = true;
                        return;
                    }
                    break;
                case "rovne":
                    if (urovenBludiste == 1){
                        System.out.print(hra.getData().nacteniRadkuSouboru("Bludiste", 14,14));
                        hra.getCas().setTempoCasu(new CasBloudeni());
                        hra.getCas().odecteniCasu();
                        urovenBludiste = 1;
                        hra.getCas().setTempoCasu(new NormalniCas());
                    }else if (urovenBludiste == 2){
                        System.out.print(hra.getData().nacteniRadkuSouboru("Bludiste", 16,19));
                        hra.getCas().odecteniCasu();
                        urovenBludiste = 3;
                    }else if (urovenBludiste == 3){
                        System.out.print(hra.getData().nacteniRadkuSouboru("Bludiste", 24,25));
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