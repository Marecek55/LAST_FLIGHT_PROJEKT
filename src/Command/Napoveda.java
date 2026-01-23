package Command;

import Zaklad.Hra;

import java.util.Scanner;

public class Napoveda implements Command {
    Scanner sc = new Scanner(System.in);
    @Override
    public void vykonat(Hra hra, String s) {
        System.out.println("Zadej s cim potrebujes pomoct");
        System.out.println("1: Kam muzu jit?\n2: Co mam delat?\n ");
        String odpoved = sc.next();
        switch (odpoved){
            case "1":
                System.out.println(hra.getAktualniMistnost().getDostupneVychody());

        }

    }


}
