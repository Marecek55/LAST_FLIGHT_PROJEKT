package Zaklad;

import Postavy.NPC;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;


public class NacitaniZeSouboru {
//    /**
//     * Nacte dataHry.json do mapy kde je uplne vse
//     * @return
//     */
//    public static HashMap<String, Mistnost> nactiSouborHry() {
//        try {
//            ObjectMapper parser = new ObjectMapper();
//            File soubor = new File("res/dataHry.json");
//            return parser.readValue(soubor, new TypeReference<HashMap<String, Mistnost>>() {} );
//        } catch (StreamReadException e) {
//            throw new RuntimeException(e);
//        } catch (DatabindException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//    }
    public ArrayList<Predmet> predmety;
    public ArrayList<NPC> npc;
    public ArrayList<Mistnost> mistnosti;

    public static NacitaniZeSouboru nactiDataZeSlozky(String cestaSlozky) {
        Gson gson = new Gson();


        try (InputStream is = Hra.class.getResourceAsStream(cestaSlozky)) {

            if (is == null) {
                throw new IllegalStateException("Nenalezen resource: " + cestaSlozky +
                        " (zkontrolujte, že soubor je v src/main/resources).");
            }
            return gson.fromJson(
                    new InputStreamReader(is, StandardCharsets.UTF_8),
                    NacitaniZeSouboru.class
            );

        } catch (Exception e) {
            throw new RuntimeException("Chyba při načítání JSON: " + e.getMessage());
        }

    }
    public  Mistnost najdiMistnost(String nazev) {
        for (int i = 0; i < mistnosti.size(); i++) {
            if (mistnosti.get(i).getNazev().equals(nazev)) {
                return mistnosti.get(i);
            }
        }
        throw new IllegalArgumentException("Neexistuje lokace s id: " + nazev);
    }


}
