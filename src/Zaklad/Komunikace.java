package Zaklad;
import Mluveni.NastvaneMluveni;
import Mluveni.PrijemneMluveni;
import Mluveni.SmutneMluveni;
import Postavy.NPC;
import java.util.Scanner;

public class Komunikace {
    Scanner sc = new Scanner(System.in);
    String odpoved;
    NPC pomocna  = null;
    Mistnost pomocnaMistnost = null;
    public void komunikace(NPC npc , Hra hra) {
        switch (npc.getJmeno().toLowerCase()) {
            case "starimanzele":
                System.out.print(hra.getData().nacteniRadkuSouboru(npc.getJmeno(), "START1", false));
                odpoved = sc.nextLine();
                System.out.print(hra.getData().nacteniRadkuSouboru(npc.getJmeno(), "VETEV" + odpoved,false));
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
                if (odpoved.toLowerCase().equals("rozlouceni")) {
                    return;
                }

                break;
            case "sara":
                System.out.print(hra.getData().nacteniRadkuSouboru(npc.getJmeno(), "START1", false));
                hra.getAktualniMistnost().getNpcVMistnosti().remove(npc);
                break;
            case "mechanik":
                    System.out.print(hra.getData().nacteniRadkuSouboru(npc.getJmeno(), "START1", false));
                     odpoved = sc.nextLine();
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

                    }else if(odpoved.equals("2")) {
                        return;
                    }

                break;
            case "prodavacka":
                System.out.print(hra.getData().nacteniRadkuSouboru(npc.getJmeno(), "START1",false));
                odpoved = sc.nextLine();
                System.out.print(hra.getData().nacteniRadkuSouboru(npc.getJmeno(), "VETEV" + odpoved,false));
                if (odpoved.equals("1")) {
                    npc.setTypMluveni(new PrijemneMluveni());
                    npc.setChceMluvit(false);
                    pomocnaMistnost =hra.getData().najdiSousedaCoMa(hra.getAktualniMistnost());
                    pomocnaMistnost.setJeZamcena(false);
                    System.out.println("Odmekl jsi " + pomocnaMistnost.getNazev());
                } else if (odpoved.equals("2")) {
                    return;
                }
                break;
            case "vojak":
                System.out.print(hra.getData().nacteniRadkuSouboru(npc.getJmeno(), "START1",false));
                odpoved = sc.nextLine();
                if (odpoved.equals("1") && !hra.getInventar().predmetJeVInventari(hra.getData().najdiPredmet("pasy"))) {
                    System.out.println("Nemas Pasy");
                    return;
                }
                System.out.print(hra.getData().nacteniRadkuSouboru(npc.getJmeno(), "VETEV" + odpoved,false));
                if (odpoved.equals("1")) {
                    npc.setTypMluveni(new SmutneMluveni());
                    hra.getInventar().odebratPredmet(hra.getData().najdiPredmet("pasy"));
                    pomocnaMistnost =hra.getData().najdiSousedaCoMa(hra.getAktualniMistnost());
                    pomocnaMistnost.setJeZamcena(false);
                    System.out.println("Odmekl jsi " + pomocnaMistnost.getNazev());
                    npc.setChceMluvit(false);


                }else if(odpoved.equals("2")) {
                    return;
                }
                break;
            case "unosce":
                System.out.print(hra.getData().nacteniRadkuSouboru(npc.getJmeno(), "START1",false));
                System.out.print(hra.getData().nacteniRadkuSouboru(npc.getJmeno(), "VETEV" + odpoved,false));
                hra.getSouboj().souboj(hra);
                npc.setChceMluvit(false);
                break;

                default:



        }


    }
}
