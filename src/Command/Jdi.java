package Command;

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
    public void vykonat(Hra hra, String s) {
        if (hra.getAktualniMistnost().getDostupneVychody().contains(s.toLowerCase())){
            Mistnost cilova = hra.getData().najdiMistnost(s.toLowerCase());
                if (!cilova.isJeZamcena()){
                    if (!cilova.isBylVNi()||!cilova.isJeCelaHotova()){
                        hra.setAktualniMistnost(cilova);
                        cilova.setBylVNi(true);
                        System.out.println(hra.getAktualniMistnost().getPribeh());
                        for (int i = 0; i < hra.getAktualniMistnost().getNpcVMistnosti().size(); i++) {
                            System.out.println(hra.getAktualniMistnost().getNpcVMistnosti().get(i).getDialog());
                        }

                    }else {
                        System.out.println("V mistnosti uz nic neni muzes jit dal");
                        hra.setAktualniMistnost(cilova);
                    }


                }else {
                    System.out.println("Mistnost je zamcena");
                }

            }else {
            System.out.println("Mistnost neni sousedni");
            }

        }
    }


