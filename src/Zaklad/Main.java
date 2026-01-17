package Zaklad;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.File;
import java.util.HashMap;


public class Main {
    public static void main(String[] args) {
        System.out.println("=== START TESTU PROPOJENÍ ===");

        // 1. Vytvoření hry (tady se na pozadí načte JSON a spustí se tvoje propojovací smyčka)
        Hra hra = new Hra();

        // 2. Kontrola startu
        Mistnost aktualni = hra.getAktualniMistnost();
        if (aktualni == null) {
            System.out.println("❌ CHYBA: Hra se nenačetla nebo není nastavena startovní místnost!");
            return;
        }
        System.out.println("📍 Jsi v místnosti: " + aktualni.getNazev());

        // 3. Test propojení (zkusíme projít všechny východy)
        System.out.println("\n--- Testuji sousedy ---");

        // Projdeme klíče (směry), které máš v JSONu (např. "sever", "vychod")
        for (String smer : aktualni.getDostupneVychody().keySet()) {

            // TADY je ten test: Metoda vstupDoDalsiMistnosti vrátí buď OBJEKT, nebo NULL
            Mistnost soused = aktualni.vstupDoDalsiMistnosti(smer);

            if (soused != null) {
                System.out.println("✅ [OK] Směr '" + smer + "' funguje -> vede do: " + soused.getNazev());
            } else {
                System.out.println("❌ [CHYBA] Směr '" + smer + "' nefunguje! (Vrátilo to null, propojení selhalo)");
            }
        }
        System.out.println("=============================");

    }
}



