package Command;

import Zaklad.Hra;

public class Poloz implements Command {
    @Override
    public void vykonat(Hra hra, String s) {
        boolean nasel = false;
        for (int i = 0; i < hra.getInventar().getListPredmetu().size(); i++) {
            if (s!= null){
                if (hra.getInventar().getListPredmetu().get(i).getNazev().equalsIgnoreCase(s)){
                    System.out.println("Vyhodil jsi "+ hra.getInventar().getListPredmetu().get(i).getNazev() );
                    hra.getAktualniMistnost().pridatPredmetDoMistnosti(hra.getInventar().getListPredmetu().get(i));
                    hra.getInventar().odebratPredmet(hra.getInventar().getListPredmetu().get(i));
                    nasel = true;
                }
            }


        }
        if (!nasel){
            System.out.println("Spatne zadany predmet");
            return;
        }

    }


}
