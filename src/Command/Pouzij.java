package Command;

import Cas.NormalniCas;
import Zaklad.Hra;
import Zaklad.Mistnost;
import Zaklad.Predmet;

public class Pouzij implements Command {
    /**
     * Pouzije predmet jako cokolada nebo lekarnicka na sebe pro nejaky ucinek
     * @param hra instance hry aby se dala ovladat aktualni mistnost
     * @param s Druha cast inputu uzivatele
     */
    String  zpravaReturnu = "";
    @Override
    public String vykonat(Hra hra, String s) {
        Predmet predmet =null;
        boolean bylPouzit = false;
        boolean jeVInventari = false;
        for (int i = 0; i < hra.getInventar().getListPredmetu().size(); i++) {
            if (hra.getInventar().getListPredmetu().get(i).getNazev().toLowerCase().equals(s.toLowerCase())) {
                predmet = hra.getInventar().getListPredmetu().get(i);
                jeVInventari = true;
                break;
            }
        }
        if (jeVInventari){
            if (predmet.isJdePouzit()){
                bylPouzit = true;
                if (predmet.getNazev().toLowerCase().equals("cokolada")){
                    zpravaReturnu = "Pouzil jsi " + predmet.getNazev()+ "\nSnedl jsi cokoladu mas bonus k casu 10 minut";
                    hra.getCas().setZbyvajiciCas(hra.getCas().getZbyvajiciCas()+10);
                    zpravaReturnu = "\n" +hra.getCas().getZbyvajiciCas() + " minut zbyva";
                    return zpravaReturnu;
                }else if (predmet.getNazev().toLowerCase().equals("lekarnicka")){
                    zpravaReturnu = "Pouzil jsi " + predmet.getNazev()+ "\nVylecil jsi se mas bonus k casu 5 minut a obnovene zdravi";
                    hra.getCas().setZbyvajiciCas(hra.getCas().getZbyvajiciCas()+5);
                    hra.getCas().setTempoCasu(new NormalniCas());
                    zpravaReturnu = "\n"+hra.getCas().getZbyvajiciCas() + " minut zbyva";
                    return zpravaReturnu;
                } else if (predmet.getNazev().toLowerCase().equals("voda")) {
                    zpravaReturnu = "Pouzil jsi " + predmet.getNazev();
                    zpravaReturnu+= "\nVypil jsi vodu a ulevilo se ti, ale mozna te to pozdeji zradi";
                    zpravaReturnu+= "\n"+ hra.getCas().getZbyvajiciCas() + " minut zbyva";
                    return zpravaReturnu;
                } else if (predmet.getNazev().toLowerCase().equals("pacidlo")) {
                    Mistnost pomocna =hra.getData().najdiSousedaCoMa(hra.getAktualniMistnost());
                    if (pomocna != null){
                        zpravaReturnu = "Pouzil jsi " + predmet.getNazev();
                        pomocna.setJeZamcena(false);
                        zpravaReturnu = zpravaReturnu + "\nOdmekl jsi"+ pomocna.getNazev();
                        return zpravaReturnu;
                    }else {
                        return "Neni tady nic na co by jsi mohl pouzit pacidlo";
                    }

                }
            }
            if (!predmet.getNazev().equals("pacidlo")){
                hra.getInventar().odebratPredmet(predmet);
                return "";
            }

        }
        if (!jeVInventari) {
            return "Predmet nemas u sebe";
        }
        if (!bylPouzit&& jeVInventari) {
            return "Predmet nejde pouzit";
        }
        return "Predmet nemas u sebe";

    }

}
