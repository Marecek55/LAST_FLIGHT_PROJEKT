package Postavy;

import Zaklad.AkceUnosce;
/**
 * Trida ktera nastavuje akce unosce a jeho zivoty
 */
public class Unosce extends Postava{
    private int zivoty;
    private AkceUnosce akce;

    public Unosce(String jmeno, int zivoty) {
        super(jmeno);
        this.zivoty = zivoty;
    }

    public int getZivoty() {
        return zivoty;
    }

    public AkceUnosce getAkce() {
        return akce;
    }

    public void setZivoty(int zivoty) {
        this.zivoty = zivoty;
    }

    public void setAkce(AkceUnosce akce) {
        this.akce = akce;
    }
}
