package Command;

import Cas.CasSeZranenim;
import Zaklad.Hra;
import Zaklad.Mistnost;
import Zaklad.NacitaniZeSouboru;

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
                    if (!cilova.getNazev().toLowerCase().equals("tridirnazavazadel")){
                        if (!cilova.isBylVNi()&&!cilova.isJeCelaHotova()){
                            hra.setAktualniMistnost(cilova);
                            cilova.setBylVNi(true);
                            if (cilova.isJeTamTma()){
                                hra.getAlex().setJeZraneny(true);
                                hra.getCas().setTempoCasu(new CasSeZranenim());
                                System.out.println("AUUUU zranil te zlodej ve tme ztracis ted 3krat vic casu");
                            }
                            System.out.println(hra.getCas().odecteniCasu());
                            if (cilova.getNazev().toLowerCase().equals("gate4")){
                                return hra.getKomunikace().vyberKonce(hra, hra.getAktualniMistnost());
                            }
                            return hra.getAktualniMistnost().getPribeh().trim();


                        }else if (cilova.isBylVNi()&&!cilova.isJeCelaHotova()){
                            hra.setAktualniMistnost(cilova);
                            System.out.println(hra.getCas().odecteniCasu());
                            return "Jdes do "+cilova.getNazev();
                        }
                        else {
                            hra.setAktualniMistnost(cilova);
                            System.out.println(hra.getCas().odecteniCasu());;
                            return "V mistnosti uz nic neni muzes jit dal";
                        }


                    }else {

                        return  hra.getBludiste().bludiste(hra);
                    }

                }else {
                    return "Mistnost je zamcena";
                }

            }else {
            return "Mistnost neni sousedni";
            }


        }
    }


