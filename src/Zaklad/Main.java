package Zaklad;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.File;
import java.util.HashMap;


public class Main {
    public static void main(String[] args) throws IOException {
        // 1. Vytvoříš načítač
        NacitaniZeSouboru nacteni = new NacitaniZeSouboru();

        // 2. Načteš celý svět do HashMapy
        HashMap<String, Mistnost> svet = nacteni.nactiSvet();

        // 3. Získáš startovní místnost (podle klíče v JSONu)
        Mistnost aktualniMistnost = svet.get("hlavniHala");

        // 4. TEST: Vypíšeme, kde jsme
        if (aktualniMistnost != null) {
            System.out.println("Vítejte ve hře!");
            System.out.println("Aktuálně jsi v: " + aktualniMistnost.getNazev());
            System.out.println("Příběh: " + aktualniMistnost.getPribeh());
        } else {
            System.out.println("Chyba: Startovní místnost nebyla nalezena!");
        }
    }
}



