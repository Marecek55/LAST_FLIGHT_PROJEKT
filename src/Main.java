import Zaklad.Mistnost;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.HashMap;


public class Main {
    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        // Načteme celý JSON jako mapu názvů → Mistnost
        HashMap<String, Mistnost> mapaMistnosti = mapper.readValue(
                new File("res/mapa.json"),
                mapper.getTypeFactory().constructMapType(HashMap.class, String.class, Mistnost.class)
        );

        // Naplníme dostupneVychody konkrétními objekty Mistnost
        for (Mistnost mistnost : mapaMistnosti.values()) {
            HashMap<String, Mistnost> vychody = new HashMap<>();
            for (String vychodNazev : mistnost.getDostupneVychody().keySet()) {
                vychody.put(vychodNazev, mapaMistnosti.get(vychodNazev));
            }
            mistnost.setDostupneVychody(vychody);
        }

        // Test: vypíšeme názvy místností
        for (String nazev : mapaMistnosti.keySet()) {
            System.out.println(nazev);
        }
    }
    }
//        ObjectMapper parser = new ObjectMapper();
//        try {
//            InputStream input = new FileInputStream("res/mapa.json");
//            Mistnost m = parser.readValue(input, Mistnost.class);
//            System.out.println(m.getNazev());
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (StreamReadException e) {
//            throw new RuntimeException(e);
//        } catch (DatabindException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }

