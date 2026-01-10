package Postavy;
import Mluveni.StrategieMluveni;
import Zaklad.Predmet;

public abstract class  NPC extends Postava {
    protected StrategieMluveni typMluveni;
    protected String dialog;
    protected boolean chceMluvit;
    protected boolean dostalToCoChtel;
    protected Predmet ocekavanyPredmet;
    public abstract String mluv();
    public abstract void prijmutiPredmetu();

    public NPC(String jmeno, StrategieMluveni typMluveni, Predmet ocekavanyPredmet) {
        super(jmeno);
        this.typMluveni = typMluveni;
        this.dialog = null;
        this.chceMluvit = true;
        this.dostalToCoChtel = false;
        this.ocekavanyPredmet = ocekavanyPredmet;
    }
}
