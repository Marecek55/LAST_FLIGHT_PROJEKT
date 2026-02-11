package Zaklad;

import Mluveni.NastvaneMluveni;
import Mluveni.PrijemneMluveni;
import Mluveni.SmutneMluveni;
import Postavy.NPC;

import java.util.Scanner;

/**
 * Trida ktera spravuje dialogy u vsech postav
 *
 * @author MAREK KULHÁNEK
 */
public class Komunikace {
    Scanner sc;


    /**
     * Zkracuje odpoved aby se neopakoval kod a pouziva rekurzi aby zadal odpoved znova
     *
     * @return odpoved uzivatele
     */
    public String skenOhlidany() {
        System.out.print(">>");
        odpoved = sc.nextLine().toLowerCase().trim();
        if (!jeUKonce) {
            if (!odpoved.equals("1") && !odpoved.equals("2") && !odpoved.equals("rozlouceni")) {
                return skenOhlidany();
            }
            return odpoved;
        } else {
            if (!odpoved.equals("1") && !odpoved.equals("2")) {
                return skenOhlidany();
            }
            return odpoved;
        }


    }

    String odpoved;
    Mistnost pomocnaMistnost = null;
    boolean jeUKonce = false;

    /**
     * spusti komunikaci podle postavy
     *
     * @param npc npc u ktere komunikuje
     * @param hra odkaz na hru
     */
    public void komunikace(NPC npc, Hra hra) {
        sc = hra.getKonzole().getSc();
        switch (npc.getJmeno().toLowerCase()) {
            case "starimanzele":
                System.out.print(hra.getData().nacteniRadkuSouboru(npc.getJmeno(), "START1", false));
                skenOhlidany();
                if (odpoved.equals("rozlouceni")) {
                    return;
                }
                System.out.print(hra.getData().nacteniRadkuSouboru(npc.getJmeno(), "VETEV" + odpoved, false));
                Predmet p = hra.getData().najdiPredmet("cokolada");
                if (odpoved.equals("1")) {
                    npc.setTypMluveni(new NastvaneMluveni());
                    npc.setChceMluvit(false);
                    return;
                } else if (odpoved.equals("2")) {
                    hra.getInventar().pridatPredmet(p);
                    npc.setChceMluvit(false);
                    return;
                }


                break;
            case "sara":
                System.out.print(hra.getData().nacteniRadkuSouboru(npc.getJmeno(), "START1", false));
                hra.getAktualniMistnost().getNpcVMistnosti().remove(npc);
                break;
            case "mechanik":
                System.out.print(hra.getData().nacteniRadkuSouboru(npc.getJmeno(), "START1", false));
                skenOhlidany();
                if (odpoved.equals("rozlouceni")) {
                    return;
                }
                if (odpoved.equals("1") && !hra.getInventar().predmetJeVInventari(hra.getData().najdiPredmet("kleste"))) {
                    System.out.println("Nemas kleste");
                    return;
                }
                System.out.print(hra.getData().nacteniRadkuSouboru(npc.getJmeno(), "VETEV" + odpoved, false));
                if (odpoved.equals("1")) {
                    npc.setTypMluveni(new PrijemneMluveni());
                    hra.getInventar().odebratPredmet(hra.getData().najdiPredmet("kleste"));
                    pomocnaMistnost = hra.getData().najdiMistnost("dutyFreeShop");
                    pomocnaMistnost.setJeTamTma(false);
                    npc.setChceMluvit(false);

                } else if (odpoved.equals("2")) {
                    return;
                }

                break;
            case "prodavacka":
                System.out.print(hra.getData().nacteniRadkuSouboru(npc.getJmeno(), "START1", false));
                skenOhlidany();
                if (odpoved.equals("rozlouceni")) {
                    return;
                }

                System.out.print(hra.getData().nacteniRadkuSouboru(npc.getJmeno(), "VETEV" + odpoved, false));
                if (odpoved.equals("1")) {
                    npc.setTypMluveni(new PrijemneMluveni());
                    npc.setChceMluvit(false);
                    pomocnaMistnost = hra.getData().najdiSousedaCoMa(hra.getAktualniMistnost());
                    pomocnaMistnost.setJeZamcena(false);
                    System.out.println(hra.getModra("Odmekl jsi ") + pomocnaMistnost.getNazev());
                } else if (odpoved.equals("2")) {
                    npc.setChceMluvit(false);
                    npc.setTypMluveni(new PrijemneMluveni());
                    return;
                }
                break;
            case "vojak":
                System.out.print(hra.getData().nacteniRadkuSouboru(npc.getJmeno(), "START1", false));
                skenOhlidany();
                if (odpoved.equals("rozlouceni")) {
                    return;
                }
                if (odpoved.equals("1") && !hra.getInventar().predmetJeVInventari(hra.getData().najdiPredmet("pasy"))) {
                    System.out.println(hra.getCervena("Nemas Pasy"));
                    return;
                }
                System.out.print(hra.getData().nacteniRadkuSouboru(npc.getJmeno(), "VETEV" + odpoved, false));
                if (odpoved.equals("1")) {
                    npc.setTypMluveni(new SmutneMluveni());
                    hra.getInventar().odebratPredmet(hra.getData().najdiPredmet("pasy"));
                    pomocnaMistnost = hra.getData().najdiSousedaCoMa(hra.getAktualniMistnost());
                    pomocnaMistnost.setJeZamcena(false);
                    System.out.println(hra.getModra("Odmekl jsi ") + pomocnaMistnost.getNazev());
                    npc.setChceMluvit(false);


                } else if (odpoved.equals("2")) {
                    return;
                }
                break;

            default:


        }


    }

    /**
     * Vyber konce se spusti jak prijde do gate4 a necha ho vybrat jak hru zakonci
     *
     * @param hra odkaz na hru
     * @param aktualni odkaz na gate4
     * @return vraci text konce
     */

    public String vyberKonce(Hra hra, Mistnost aktualni) {
        if (this.sc == null) {
            this.sc = hra.getKonzole().getSc();
        }
        System.out.println(hra.getCervena("\nRozhodni se rychle:"));
        System.out.println("1. Vezmi rodinu a utec do letadla");
        System.out.println("2. Zneskodni unosce navzdy");
        jeUKonce = true;
        skenOhlidany();
        String textKonce = hra.getData().nacteniRadkuSouboru(aktualni.getNazev(), "VETEV" + odpoved, true);
        if (odpoved.equals("1")) {
            hra.setStavKonce(StavKonce.VYHRA);

        } else if (odpoved.equals("2")) {
            hra.setStavKonce(StavKonce.SPATNYKONEC);

        }
        hra.setJeKonec(true);
        return textKonce;
    }
}
