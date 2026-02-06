package Mluveni;
/**
 * Interface na Strategii mluveni ktera ji vybere podle nalady kazdeho npc
 */
public interface StrategieMluveni {
    /**
     * Pozdrav vypise pozdrav podle nalady npc
     * @return
     */
    public String pozdrav();
    /**
     * Rozlouceni vypise rozlouceni podle nalady npc
     * @return
     */
    public String rozlouceni();


}
