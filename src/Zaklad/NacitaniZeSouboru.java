package Zaklad;

import Postavy.NPC;
import com.google.gson.Gson;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;


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
//        +
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
    public void nasypDoMistnostiPredmety(String[] nazevPredmetu, String[] nazevNPC ,String nazevMistnosti) {
        ArrayList<Predmet> predmetyNaNasypani = new ArrayList<>();
        ArrayList<NPC> npcNaNasypani = new ArrayList<>();
        for (int i = 0; i < nazevPredmetu.length;  i++) {
            for (int j = 0; j < predmety.size(); j++) {
                if (nazevPredmetu[i].equals(predmety.get(j).getNazev())) {
                    predmetyNaNasypani.add(predmety.get(j));
                }
            }
        }
        for (int i = 0; i < nazevNPC.length;  i++) {
            for (int j = 0; j < npc.size(); j++) {
                if (nazevNPC[i].equals(npc.get(j).getJmeno())) {
                    npcNaNasypani.add(npc.get(j));
                }
            }
        }
        for (int i = 0; i < mistnosti.size(); i++) {
            if (nazevMistnosti.equals(mistnosti.get(i).getNazev())) {
                mistnosti.get(i).setPredmetyVMistnosti(predmetyNaNasypani);
                mistnosti.get(i).setNpcVMistnosti(npcNaNasypani);
                return;

            }
        }
    }
    public void nactiPozadovanyPredmet(String jmeno , String jmenoPredmetu){
        Predmet predmetPotrebny = new Predmet();
        for (int i = 0; i < predmety.size(); i++) {
            if (predmety.get(i).getNazev().equals(jmenoPredmetu)) {
                predmetPotrebny = predmety.get(i);
            }
        }
        for (int i = 0; i < npc.size(); i++) {
            if (npc.get(i).getJmeno().equals(jmeno)) {
                npc.get(i).setOcekavanyPredmet(predmetPotrebny);
            }
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
