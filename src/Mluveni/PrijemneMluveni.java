package Mluveni;
/**
 * Trida ktera inicializuje prijemny pozdrav
 * @author MAREK KULHÁNEK
 */
public class PrijemneMluveni implements StrategieMluveni{
    /**
     * Vypise pozdrav stastneho npc
     * @return vraci pozdrav
     */
    @Override
    public String pozdrav() {
        return "Ahojky";
    }
    /**
     * Vypise rozlouceni stastneho npc
     * @return vraci rozlouceni
     */
    @Override
    public String rozlouceni() {
        return "Hodne stesti";
    }
}
