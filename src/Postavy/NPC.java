package Postavy;
import Mluveni.NastvaneMluveni;
import Mluveni.PrijemneMluveni;
import Mluveni.SmutneMluveni;
import Mluveni.StrategieMluveni;
import Zaklad.Predmet;

public class  NPC extends Postava {
    private  transient StrategieMluveni typMluveni;
    private String dialog;
    private boolean chceMluvit;
    private boolean dostalToCoChtel;
    private Predmet ocekavanyPredmet;
    private String mluv(){
        return "";
    }
    public String typMluveniText;

    public void prijmutiPredmetu(){}

    public NPC(String jmeno) {
        super("");

    }
    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;

    }

    public String getJmeno() {
        return jmeno;
    }


    public StrategieMluveni getTypMluveni() {
        return typMluveni;
    }


    public String getTypMluveniText() {
        return typMluveniText;
    }

    public void setTypMluveniText(String typMluveniText) {
        this.typMluveniText = typMluveniText;

    }

    /**
     * Nastavi pomoci textu z jsonu interface typ mluveni
     * @param typMluveniText je text z jsonu ktery sedi s nazvem typu mluveni
     */

    public void setTypMluveni(String typMluveniText) {
        if (typMluveniText.equals("nastvane")) {
            this.typMluveni = new NastvaneMluveni();
        } else if (typMluveniText.equals("smutne")) {
            this.typMluveni = new SmutneMluveni();
        } else {
            this.typMluveni = new PrijemneMluveni();
        }
    }

    public String getDialog() {
        return dialog;
    }

    public void setDialog(String dialog) {
        this.dialog = dialog;
    }

    public boolean isChceMluvit() {
        return chceMluvit;
    }

    public void setChceMluvit(boolean chceMluvit) {
        this.chceMluvit = chceMluvit;
    }

    public boolean isDostalToCoChtel() {
        return dostalToCoChtel;
    }

    public void setDostalToCoChtel(boolean dostalToCoChtel) {
        this.dostalToCoChtel = dostalToCoChtel;
    }

    public Predmet getOcekavanyPredmet() {
        return ocekavanyPredmet;
    }

    public void setOcekavanyPredmet(Predmet ocekavanyPredmet) {
        this.ocekavanyPredmet = ocekavanyPredmet;
    }

    @Override
    public String toString() {
        return "NPC{" +
                "typMluveni=" + typMluveni+
                ", dialog='" + dialog + '\'' +
                ", chceMluvit=" + chceMluvit +
                ", dostalToCoChtel=" + dostalToCoChtel +
                ", ocekavanyPredmet=" + ocekavanyPredmet +
                ", typMluveniText='" + typMluveniText + '\'' +
                ", jmeno='" + jmeno + '\'' +
                '}';
    }
}
