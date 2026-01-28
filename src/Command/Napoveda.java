package Command;

import Zaklad.Hra;

import java.util.Scanner;

public class Napoveda implements Command {
    /**
     * Poskytne hracovi moznost vyberu ze 3 stupnu napovedy pro kazdou mistnost
     * @param hra instance hry aby se dala ovladat aktualni mistnost
     * @param s Druha cast inputu uzivatele
     */

    @Override
    public String vykonat(Hra hra, String s) {

            switch (s){
                case "1":
                    System.out.println("Napoveda pro mistnost " +hra.getAktualniMistnost().getNazev() + " Uroven napovedy " + s);
                    System.out.print(hra.getData().nacteniRadkuSouboru(hra.getAktualniMistnost().getNazev() ,"NAPOVEDA1" ,false));
                    break;

                case "2":
                    if (hra.getAktualniMistnost().isJeProzkoumana()){
                        System.out.println("Napoveda pro mistnost " +hra.getAktualniMistnost().getNazev() + " Uroven napovedy " + s);
                        System.out.print(hra.getData().nacteniRadkuSouboru(hra.getAktualniMistnost().getNazev() , "NAPOVEDA2" ,false));
                        break;
                    }else {
                        return "Nemas mistnost prozkoumanou natolik aby si mohl zobrazit napovedu";
                    }
                case "3":
                    if (hra.getAktualniMistnost().isJeProzkoumana()){
                        System.out.println("Napoveda pro mistnost " +hra.getAktualniMistnost().getNazev() + " Uroven napovedy " + s);
                        System.out.print(hra.getData().nacteniRadkuSouboru(hra.getAktualniMistnost().getNazev() , "NAPOVEDA3",false));
                        break;
                    }else {
                        return "Nemas mistnost prozkoumanou natolik aby si mohl zobrazit napovedu";
                    }

                default:
                    System.out.println("Spatne zadana uroven napovedy");
                    break;
            }

        }
        }





