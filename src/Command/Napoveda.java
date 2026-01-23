package Command;

import Zaklad.Hra;

import java.util.Scanner;

public class Napoveda implements Command {

    @Override
    public void vykonat(Hra hra, String s) {

        switch (s){
            case "1":
                System.out.println("Napoveda pro mistnost " +hra.getAktualniMistnost().getNazev() + " Uroven napovedy " + s);
                hra.getData().nacteniRadkuSouboru(hra.getAktualniMistnost().getNazev() , 0, 2);
                break;
                case "2":
                    System.out.println("Napoveda pro mistnost " +hra.getAktualniMistnost().getNazev() + " Uroven napovedy " + s);
                    hra.getData().nacteniRadkuSouboru(hra.getAktualniMistnost().getNazev() , 0, 3);
                    break;
                    case "3":
                        System.out.println("Napoveda pro mistnost " +hra.getAktualniMistnost().getNazev() + " Uroven napovedy " + s);
                        hra.getData().nacteniRadkuSouboru(hra.getAktualniMistnost().getNazev() , 0, 4);
                        break;
                        default:
                            System.out.println("Spatne zadana uroven napovedy");
                            break;
        }
    }


}
