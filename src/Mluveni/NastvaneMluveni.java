package Mluveni;

public class NastvaneMluveni implements StrategieMluveni{
    /**
     * Vypise pozdrav nastvaneho npc
     * @return
     */
    @Override
    public String pozdrav() {
        return "CO CHCES!";
    }
    /**
     * Vypise rozlouceni nastvaneho npc
     * @return
     */

    @Override
    public String rozlouceni() {
        return "VYPADNI!";
    }
}
