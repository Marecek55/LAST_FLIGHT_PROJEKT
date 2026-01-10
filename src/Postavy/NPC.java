package Postavy;

public abstract class  NPC {
    protected StrategieMluveni typMluveni;
    protected String dialog;
    protected boolean chceMluvit;
    protected boolean dostalToCoChtel;
    protected Predmet ocekavanyPredmet;
    public abstract String mluv();
    public abstract void prijmutiPredmetu();



}
