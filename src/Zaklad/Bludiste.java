package Zaklad;

import Cas.CasBloudeni;
import Cas.NormalniCas;

import java.util.Scanner;


public class Bludiste {

    int urovenBludiste = 1;
    boolean vyselZbludiste = false;
    String zpravaReturnu = "";


    public String bludiste(Hra hra) {
        hra.setAktualniMistnost(hra.getData().najdiMistnost("tridirnaZavazadel"));
        if (vyselZbludiste) {
            return "Tudy uz jsi prosel cesta mezi kufry je volna. Jdes do tridirny zavazadel";
        }

        if (urovenBludiste<3) {
            System.out.print(hra.getData().nacteniRadkuSouboru("bludiste", "START", null));
        }
        while (!vyselZbludiste) {
            if (hra.getCas().getZbyvajiciCas() <= 0) {
                hra.setJeKonec(true);
                return "V bludisti ti dosel cas a nestihl jsi letadlo...";
            }
            if (urovenBludiste == 1) {
                System.out.print(hra.getData().nacteniRadkuSouboru("bludiste", "START", null).trim()+"\n");
            }
            System.out.print(">> ");
            String odpoved = hra.getKonzole().getSc().nextLine().toLowerCase();
            switch (odpoved) {
                case "doleva":
                    if (urovenBludiste == 1) {
                        zpravaReturnu = hra.getData().nacteniRadkuSouboru("bludiste", "DOLEVA1", null);
                        zpravaReturnu = zpravaReturnu + "\n" + hra.getCas().odecteniCasu();
                        urovenBludiste = 2;
                        System.out.println(zpravaReturnu);
                    } else {
                        vratNaZacatek(hra, "DOLEVA" + urovenBludiste);
                    }
                    break;
                case "doprava":
                    if (urovenBludiste == 3) {
                        zpravaReturnu = hra.getData().nacteniRadkuSouboru("bludiste", "DOPRAVA3", null);
                        zpravaReturnu = zpravaReturnu + "\n" + hra.getCas().odecteniCasu();
                        hra.setAktualniMistnost(hra.getData().najdiMistnost("tridirnaZavazadel"));
                        vyselZbludiste = true;
                    } else {
                        vratNaZacatek(hra, "DOPRAVA" + urovenBludiste);
                    }
                    break;
                case "rovne":
                    if (urovenBludiste == 2) {
                        zpravaReturnu = hra.getData().nacteniRadkuSouboru("bludiste", "ROVNE2", null);
                        zpravaReturnu = zpravaReturnu + "\n" + hra.getCas().odecteniCasu();
                        urovenBludiste = 3;
                        System.out.println(zpravaReturnu);
                    } else {
                        vratNaZacatek(hra, "ROVNE" + urovenBludiste);
                    }
                    break;
                default:
                    System.out.println("Musis zadat rovne doleva nebo doprava");
            }
        }

        return zpravaReturnu;
    }
    private void vratNaZacatek(Hra hra, String slovo) {
        hra.getCas().setTempoCasu(new CasBloudeni());
        System.out.print(hra.getData().nacteniRadkuSouboru("bludiste", slovo, null).trim());
        System.out.println("Zabloudil jsi vracis se! "+ hra.getCas().odecteniCasu());
        hra.getCas().setTempoCasu(new NormalniCas());
        urovenBludiste = 1;
    }

    public boolean isVyselZbludiste() {
        return vyselZbludiste;
    }

    public void setVyselZbludiste(boolean vyselZbludiste) {
        this.vyselZbludiste = vyselZbludiste;
    }
}