package Zaklad;

import java.util.ArrayList;

public class Inventar {
    private int kapacita = 3;
    private ArrayList<Predmet> listPredmetu;
    public boolean isJePlny(){
        return listPredmetu.size() >= kapacita;
    }
    public void odebratPredmet(Predmet p) {
        if (!listPredmetu.contains(p)) {
            System.out.println("NEMAS CO VYHODIT");
            return;
        }
        listPredmetu.remove(p);
    }
    public void pridatPredmet(Predmet p) {
        if (!isJePlny()) {
            listPredmetu.add(p);
        }else {
            System.out.println("MAS PLNOU KAPACITU MUSIS POLOZIT PREDMET");
            return;
        }
    }
    public boolean predmetJeVInventari(Predmet predmet){
        if (listPredmetu.contains(predmet)){
            return true;
        }else {
            return false;
        }

    }

    public ArrayList<Predmet> getListPredmetu() {
        return listPredmetu;
    }

    public int getKapacita() {
        return kapacita;
    }

    public void setKapacita(int kapacita) {
        this.kapacita = kapacita;
    }

    public void setListPredmetu(ArrayList<Predmet> listPredmetu) {
        this.listPredmetu = listPredmetu;
    }

    public void zobrazeniInventare(){
        for (Predmet p : listPredmetu) {
            System.out.println(p.getNazev());
        }
    }

    public Inventar(int kapacita) {
        this.kapacita = kapacita;
        this.listPredmetu = new ArrayList<>();
    }
}
