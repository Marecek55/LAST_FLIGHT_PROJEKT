package Mluveni;
/**
 * Interface na Strategii mluveni ktera ji vybere podle nalady kazdeho npc
 * @author MAREK KULHÁNEK
 */
public interface StrategieMluveni {
    /**
     * Pozdrav vypise pozdrav podle nalady npc
     * @return vraci pozdrav
     */
    public String pozdrav();
    /**
     * Rozlouceni vypise rozlouceni podle nalady npc
     * @return vraci rozlouceni
     */
    public String rozlouceni();


}
