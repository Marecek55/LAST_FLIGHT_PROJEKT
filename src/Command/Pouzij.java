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
    @Override
    public void vykonat(Hra hra, String s) {
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
                    System.out.println("Pouzil jsi " + predmet.getNazev());
                    System.out.println("Snedl jsi cokoladu mas bonus k casu 10 minut");
                    hra.getCas().setZbyvajiciCas(hra.getCas().getZbyvajiciCas()+10);
                    System.out.println(hra.getCas().getZbyvajiciCas() + " minut zbyva");
                }else if (predmet.getNazev().toLowerCase().equals("lekarnicka")){
                    System.out.println("Pouzil jsi " + predmet.getNazev());
                    System.out.println("Vylecil jsi se mas bonus k casu 5 minut a obnovene zdravi");
                    hra.getCas().setZbyvajiciCas(hra.getCas().getZbyvajiciCas()+5);
                    hra.getCas().setTempoCasu(new NormalniCas());
                    System.out.println(hra.getCas().getZbyvajiciCas() + " minut zbyva");
                } else if (predmet.getNazev().toLowerCase().equals("voda")) {
                    System.out.println("Pouzil jsi " + predmet.getNazev());
                    System.out.println("Vypil jsi vodu a ulevilo se ti, ale mozna te to pozdeji zradi");
                    System.out.println(hra.getCas().getZbyvajiciCas() + " minut zbyva");
                } else if (predmet.getNazev().toLowerCase().equals("pacidlo")) {
                    Mistnost pomocna =hra.getData().najdiSousedaCoMa(hra.getAktualniMistnost());
                    if (pomocna != null){
                        System.out.println("Pouzil jsi " + predmet.getNazev());
                        pomocna.setJeZamcena(false);
                        System.out.println("Odmekl jsi " + pomocna.getNazev());
                    }else {
                        System.out.println("Neni tady nic na co by jsi mohl pouzit pacidlo");
                        return;
                    }

                }
            }
            if (!predmet.getNazev().equals("pacidlo")){
                hra.getInventar().odebratPredmet(predmet);
            }

        }
        if (!jeVInventari) {
            System.out.println("Predmet nemas u sebe");
        }
        if (!bylPouzit&& jeVInventari) {
            System.out.println("Predmet nejde pouzit");
        }

    }

}
