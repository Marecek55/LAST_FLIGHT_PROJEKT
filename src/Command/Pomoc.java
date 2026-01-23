package Command;

import Zaklad.Hra;

import java.util.Scanner;

public class Pomoc implements Command {
    @Override
    public void vykonat(Hra hra, String s) {
        System.out.println("POMOC NEBOLI NAVOD NA HRU \n");
        hra.getData().nacteniRadkuSouboru("NavodHry" ,0, 10);
    }

}
