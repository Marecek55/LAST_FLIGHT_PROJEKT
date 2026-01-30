package Command;

import Postavy.NPC;
import Zaklad.Hra;
import Zaklad.Mistnost;
import Zaklad.Predmet;

import java.util.ArrayList;

public class Prozkoumej implements Command {
    boolean mistnostUzJednouProzkoumal = false;
    /**
     * Prozkouma mistnost a ukaze mu predmety a lidi v ni
     * @param hra instance hry aby se dala ovladat aktualni mistnost
     * @param s Druha cast inputu uzivatele
     */
    String zpravaReturnu = "";
    @Override
    public String vykonat(Hra hra, String s) {
        ArrayList<String> mistnostiPomocne = hra.getAktualniMistnost().getDostupneVychody();
        ArrayList<NPC> npcPomocne = hra.getAktualniMistnost().getNpcVMistnosti();
        ArrayList<Predmet> predmetyPomocne = hra.getAktualniMistnost().getPredmetyVMistnosti();
            zpravaReturnu = hra.getFialova("----PROZKOUMAVANI----\n");
            boolean jsouTamLidi = false;
            boolean jsouTamPredmety = false;

            if (npcPomocne.size()>0){
                zpravaReturnu  += hra.getModra("Lide v mistnosti:");
                for (int i = 0; i < npcPomocne.size(); i++) {
                    zpravaReturnu += npcPomocne.get(i).getJmeno() + ", ";
                }
                zpravaReturnu += "\n";
                hra.getAktualniMistnost().setJeProzkoumana(true);
                jsouTamLidi = true;


            }else {
                zpravaReturnu+= hra.getZluta("Nikdo v mistnosti neni\n");
            }
            if (predmetyPomocne.size()>0){
                zpravaReturnu += hra.getModra("Predmety v mistnosti: ");
                for (int i = 0; i < predmetyPomocne.size(); i++) {
                    zpravaReturnu += predmetyPomocne.get(i).getNazev() + " ";
                }
                zpravaReturnu += "\n";
                hra.getAktualniMistnost().setJeProzkoumana(true);
                jsouTamPredmety = true;

            }else {
                zpravaReturnu += hra.getZluta("Zadny predmet v mistnosti neni\n");

            }
            if (mistnostiPomocne.size()>0) {
            zpravaReturnu+= hra.getModra("Dostupne vychody: ");
            for (int i = 0; i < mistnostiPomocne.size(); i++) {
               zpravaReturnu +=mistnostiPomocne.get(i)+ ", ";
            }
        }
            if (jsouTamLidi||jsouTamPredmety) {
                zpravaReturnu += "\n" + hra.getCas().odecteniCasu(hra);
            }
        mistnostUzJednouProzkoumal = true;
            return zpravaReturnu;



    }

}
