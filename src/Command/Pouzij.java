package Command;

import Cas.NormalniCas;
import Zaklad.Hra;
import Zaklad.Predmet;

public class Pouzij implements Command {
    /**
     * Pouzije predmet jako cokolada nebo lekarnicka na sebe pro nejaky ucinek
     * @param hra instance hry aby se dala ovladat aktualni mistnost
     * @param s Druha cast inputu uzivatele
     */
    @Override
    public void vykonat(Hra hra, String s) {
        Predmet predmet =null;
        boolean bylPouzit = false;
        if (s== null){
            System.out.println("Musis zadat jaky prdmet chces pouzit");
            return;
        }
        for (int i = 0; i <hra.getInventar().getListPredmetu().size() ; i++) {
            if (hra.getInventar().getListPredmetu().get(i).getNazev().toLowerCase().equals(s.toLowerCase())) {
                predmet = hra.getInventar().getListPredmetu().get(i);
                if (predmet.isJdeVyhodit()){
                    bylPouzit = true;
                    System.out.println("Pouzil jsi " + predmet.getNazev());
                    if (predmet.getNazev().toLowerCase().equals("cokolada")){
                        System.out.println("Snedl jsi cokoladu mas bonus k casu 10 minut");
                        hra.getCas().setZbyvajiciCas(hra.getCas().getZbyvajiciCas()+10);
                    }else if (predmet.getNazev().toLowerCase().equals("lekarnicka")){
                        System.out.println("Vylecil jsi se mas bonus k casu 5 minut a obnovene zdravi");
                        hra.getCas().setZbyvajiciCas(hra.getCas().getZbyvajiciCas()+5);
                        hra.getCas().setTempoCasu(new NormalniCas());
                    }
                    }
                    hra.getInventar().odebratPredmet(predmet);
                    return;
                }
            }
        if (predmet == null) {
            System.out.println("Predmet nemas v inventari");
        }else if (!bylPouzit) {
            System.out.println("Predmet nemuze byt pouzit");
        }

    }

}
