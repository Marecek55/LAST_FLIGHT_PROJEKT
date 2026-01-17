package Zaklad;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;


public class NacitaniZeSouboru {
    /**
     * Nacte mapa.json do mapy kde je uplne vse
     * @return
     */
    public static HashMap<String, Mistnost> nactiSouborHry() {
        try {
            ObjectMapper parser = new ObjectMapper();
            File soubor = new File("res/mapa.json");
            return parser.readValue(soubor, new TypeReference<HashMap<String, Mistnost>>() {} );
        } catch (StreamReadException e) {
            throw new RuntimeException(e);
        } catch (DatabindException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
