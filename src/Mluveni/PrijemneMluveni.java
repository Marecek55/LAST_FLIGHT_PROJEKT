package Mluveni;

public class PrijemneMluveni implements StrategieMluveni{
    /**
     * Vypise pozdrav stastneho npc
     * @return
     */
    @Override
    public String pozdrav() {
        return "Ahojky";
    }
    /**
     * Vypise rozlouceni stastneho npc
     * @return
     */
    @Override
    public String rozlouceni() {
        return "Hodne stesti";
    }
}
