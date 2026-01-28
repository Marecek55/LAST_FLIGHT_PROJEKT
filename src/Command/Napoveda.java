package Command;

import Zaklad.Hra;

import java.util.Scanner;

public class Napoveda implements Command {
    /**
     * Poskytne hracovi moznost vyberu ze 3 stupnu napovedy pro kazdou mistnost
     * @param hra instance hry aby se dala ovladat aktualni mistnost
     * @param s Druha cast inputu uzivatele
     */
    String zpravaReturnu  = "";

    @Override
    public String vykonat(Hra hra, String s) {
            switch (s){
                case "1":
                    zpravaReturnu = "Napoveda pro mistnost " +hra.getAktualniMistnost().getNazev() + " Uroven napovedy " + s;
                zpravaReturnu = zpravaReturnu + " " +hra.getData().nacteniRadkuSouboru(hra.getAktualniMistnost().getNazev() ,"NAPOVEDA1" ,null);
                return zpravaReturnu;
                case "2":
                    if (hra.getAktualniMistnost().isJeProzkoumana()){
                        zpravaReturnu = "Napoveda pro mistnost " +hra.getAktualniMistnost().getNazev() + " Uroven napovedy " + s;
                        zpravaReturnu = zpravaReturnu + " " +hra.getData().nacteniRadkuSouboru(hra.getAktualniMistnost().getNazev() ,"NAPOVEDA2" ,null);
                        return zpravaReturnu;
                    }else {
                        return "Nemas mistnost prozkoumanou natolik aby si mohl zobrazit napovedu";
                    }
                case "3":
                    if (hra.getAktualniMistnost().isJeProzkoumana()){
                        zpravaReturnu = "Napoveda pro mistnost " +hra.getAktualniMistnost().getNazev() + " Uroven napovedy " + s;
                        zpravaReturnu = zpravaReturnu + " " +hra.getData().nacteniRadkuSouboru(hra.getAktualniMistnost().getNazev() ,"NAPOVEDA3" ,null);
                        return zpravaReturnu;
                    }else {
                        return "Nemas mistnost prozkoumanou natolik aby si mohl zobrazit napovedu";
                    }
                default:
                    return "Spatne zadana uroven napovedy";

            }

        }
        }





