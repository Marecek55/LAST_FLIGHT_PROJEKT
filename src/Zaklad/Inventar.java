package Zaklad;

import java.util.ArrayList;
/**
 * Trida Inventar spravuje inventar a jeho chod tzn vyhazovani prijimani kontrola plnosti
 * kontrola jestli je predmet v inventari
 * @author MAREK KULHÁNEK
 */
public class Inventar {
    private int kapacita = 4;
    private ArrayList<Predmet> listPredmetu;

    /**
     * overuje jestli je inventar plny
     * @return vraci jestli je plny
     */
    public boolean isJePlny(){
        return listPredmetu.size() >= kapacita;
    }

    /**
     * odebira predmet
     * @param p predmet
     */
    public void odebratPredmet(Predmet p) {
        if (!listPredmetu.contains(p)) {
            System.out.println("NEMAS CO VYHODIT");
            return;
        }
        listPredmetu.remove(p);
    }

    /**
     * pridava predmet
     * @param p predmet
     */
    public void pridatPredmet(Predmet p) {
        if (!isJePlny()) {
            listPredmetu.add(p);
        }else {
            System.out.println("MAS PLNOU KAPACITU MUSIS POLOZIT PREDMET");
            return;
        }
    }

    /**
     * kontroluje jestli je dany predmet v inventari
     * @param predmet predmet
     * @return je nebo neni v inventari
     */
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

    /**
     * zobrazi inventar vypise jmena
     */
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
