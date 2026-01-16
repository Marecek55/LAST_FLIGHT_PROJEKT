package Zaklad;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class NacitaniZeSouboru {
    private ObjectMapper parser = new ObjectMapper();


    public HashMap<String, Mistnost> nactiSvet() {
        try {
            InputStream input = new FileInputStream("res/mapa.json");
            HashMap<String, Mistnost> mistnosti = parser.readValue(input, new TypeReference<HashMap<String, Mistnost>>() {});

            for (Mistnost m : mistnosti.values()) {
                m.propojVychody(mistnosti);
            }
            //TODO

            return mistnosti;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
