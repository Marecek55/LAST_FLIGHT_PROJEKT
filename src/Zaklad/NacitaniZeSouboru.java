package Zaklad;

import Postavy.NPC;
import com.google.gson.Gson;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;


public class NacitaniZeSouboru {
    public ArrayList<Predmet> predmety;
    public ArrayList<NPC> npc;
    public ArrayList<Mistnost> mistnosti;

    /**
     * Nacte pomoci cesty do jednotlivych objektu data z json souboru do jednotlivych listu
     * @param cestaSlozky cesta k jsonu
     * @return
     */

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

    /**
     * Naplni listy predmetu v mistnosti a npc v mistnosti v dane mistnosti protoze se nenaplnuji v jsonu
     * @param nazevPredmetu nazev predmetu ktery se prida
     * @param nazevNPC nazev npc ktery se prida
     * @param nazevMistnosti nazev mistnosti kam se to vse prida
     */
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

    /**
     * Nacte vsem npc jejich ocekavany predmet
     * @param jmeno jmeno npc
     * @param jmenoPredmetu  jmeno ocekavaneho predmetu
     */
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


    /**
     * Hleda mistnost v listu nactenych mistnosti
     * @param nazev nazev mistnosti kterou chceme najit
     * @return
     */
    public  Mistnost najdiMistnost(String nazev) {
        for (int i = 0; i < mistnosti.size(); i++) {
            if (mistnosti.get(i).getNazev().equalsIgnoreCase(nazev)) {
                return mistnosti.get(i);
            }
        }
        throw new IllegalArgumentException("Neexistuje lokace s nazvem: " + nazev);
    }

    /**
     * Najde npc podle nazvu z listu nactenych npc
     * @param nazev
     * @return
     */
    public NPC najdiNPC(String nazev) {
        for (int i = 0; i < npc.size(); i++) {
            if (npc.get(i).getJmeno().equalsIgnoreCase(nazev)) {
                return npc.get(i);
            }
        }
        throw new IllegalArgumentException("Neexistuje npc s nazvem: " + nazev);
    }

    /**
     * najde predmet podle nazvu z listu nactenych predmetu
     * @param nazev
     * @return
     */
    public Predmet najdiPredmet(String nazev) {
        for (int i = 0; i < predmety.size(); i++) {
            if (predmety.get(i).getNazev().equalsIgnoreCase(nazev)) {
                return predmety.get(i);
            }
        }
        throw new IllegalArgumentException("Neexistuje predmet s nazvem: " + nazev);
    }

    /**
     * nacte pozadovany pocet raku z daneho souboru podle hledaneho slova
     * @param nazev nazev souboru
     * @param hledaneSlovo od jakeho slova se ma nacitat
     * @return
     */
    public String nacteniRadkuSouboru(String nazev , String hledaneSlovo, boolean jeToProMistnost) {
        String text = "";
        boolean nalezeno = false;
        try {
            BufferedReader br = new BufferedReader((new FileReader("res/" + nazev+ ".txt")));
            String line = "";
            while ((line = br.readLine()) != null) {
                String radek = line.trim();

                if (nalezeno&&radek.equals("KONEC")){
                    break;
                }
                if (nalezeno) {
                    text = text + radek + "\n";
                }
                if (radek.equals(hledaneSlovo)) {
                    nalezeno = true;
                }

            }
            br.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (jeToProMistnost) {
            najdiMistnost(nazev).setPribeh(text);
        }else {
            najdiNPC(nazev).setDialog(text);
        }
        return text;

    }


//    /**
//     * Nacte pribeh mistnosti ze souboru a taky nacte dialogy npc
//     * @param nazev nazev mistnosti nebo npc
//     * @param jeToProNpc urci jestli jde o npc nebo ne aby se dobre pridal soubor
//     */
//    public void nacteniPribehuPostavAMistnosti(String nazev , boolean jeToProNpc) {
//        String nazevSouboru;
//        if (jeToProNpc) {
//            nazevSouboru = najdiNPC(nazev).getJmeno() ;
//        }else {
//            nazevSouboru =  najdiMistnost(nazev).getNazev();
//        }
//        int pocetRadku  = 0;
//        try {
//            BufferedReader br = new BufferedReader((new FileReader("res\\" + nazevSouboru + ".txt")));
//            String line = "";
//            while ((line = br.readLine())!= null){
//                pocetRadku++;
//
//            }
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        String text = "";
//        if (!jeToProNpc) {
//           text = nacteniRadkuSouboru(nazevSouboru , "ZACATEKNPC");
//        }else {
//            text = nacteniRadkuSouboru(nazevSouboru , "ZACATEKMISTNOSTI");
//        }
//
//
//        if (jeToProNpc) {
//            najdiNPC(nazev).setDialog(text);
//        }else {
//            najdiMistnost(nazev).setPribeh(text);
//       }
//
//
//    }
    public Mistnost najdiSousedaCoMa(Mistnost aktualni){
        ArrayList<Mistnost> mistnostiSousedni = new ArrayList<>();
        Mistnost cilova = null;
        for (int i = 0; i < aktualni.getDostupneVychody().size(); i++) {
            String nazevVychodu = aktualni.getDostupneVychody().get(i);

            for (int j = 0; j < mistnosti.size(); j++) {
                if (nazevVychodu.equals(mistnosti.get(j).getNazev().toLowerCase())) {
                    mistnostiSousedni.add(mistnosti.get(j));
                }
            }
        }
        for (int i = 0; i < mistnostiSousedni.size(); i++) {
            if (mistnostiSousedni.get(i).isJeZamcena()){
                cilova = mistnostiSousedni.get(i);
            }
        }
        return cilova;
    }


}
