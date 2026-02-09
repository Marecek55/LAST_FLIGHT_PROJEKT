package Command;

import Cas.CasSeZranenim;
import Zaklad.Hra;
import Zaklad.Mistnost;
import Zaklad.NacitaniZeSouboru;
/**
 * Trida ktera vykonava command Jdi
 */
public class Jdi implements Command {
    /**
     * Zkontroluje jestli uz tam byl a jestli uz v ni vse prosel a pak jestli je zamcena a podle toho ho pusti do mistnosti kterou
     * napsal pokud s ni sousedi ta mistnost ve ktere je
     * @param hra instance hry aby se dala ovladat aktualni mistnost
     * @param s Druha cast inputu uzivatele
     */
    @Override
    public String vykonat(Hra hra, String s) {
        if (hra.getAktualniMistnost().getDostupneVychody().contains(s.toLowerCase())){
            Mistnost cilova = hra.getData().najdiMistnost(s.toLowerCase());
                if (!cilova.isJeZamcena()){
                    if (cilova.getNazev().toLowerCase().equals("tridirnazavazadel") && !hra.getBludiste().isVyselZbludiste()){
                        return hra.getBludiste().bludiste(hra);
                    }
                    if (cilova.getNazev().toLowerCase().equals("garaze")&& !hra.getMiniHra().isDohrano()){
                        hra.getMiniHra().skorapky(hra);
                        hra.getMiniHra().setDohranoPomocne(true);
                    }
                    hra.setAktualniMistnost(cilova);
                    if (hra.getInventar().predmetJeVInventari(hra.getData().najdiPredmet("baterka"))){
                        cilova.setJeTamTma(false);
                    }
                    if (cilova.isJeTamTma()){

                        hra.getAlex().setJeZraneny(true);
                        hra.getCas().setTempoCasu(new CasSeZranenim());
                        System.out.println(hra.getCervena("AUUUU zranil te zlodej ve tme ztracis ted 3krat vic casu"));
                    }
                    if (!hra.getMiniHra().isDohranoPomocne()){
                        System.out.println(hra.getCas().odecteniCasu(hra));
                    }
                    hra.getMiniHra().setDohranoPomocne(false);


                    if (cilova.getNazev().toLowerCase().equals("gate4")){
                        System.out.println(hra.getData().nacteniRadkuSouboru("gate4", "ZACATEKMISTNOSTI", true));
                        System.out.println(hra.getSouboj().souboj(hra));
                        if (!hra.isJeKonec()) {
                            return hra.getKomunikace().vyberKonce(hra, hra.getAktualniMistnost());
                        }
                        return hra.getCervena("Konec hry.");
                    }
                        if (!cilova.isBylVNi()) {
                            cilova.setBylVNi(true);
                            return cilova.getPribeh().trim();

                        }else {
                            return hra.getModra("Vratil jsi se do ") + cilova.getNazev();
                        }

                }else {
                    return hra.getCervena("Mistnost je zamcena");
                }
            }else {
            return hra.getCervena("Mistnost neni sousedni");
            }


        }
    }


