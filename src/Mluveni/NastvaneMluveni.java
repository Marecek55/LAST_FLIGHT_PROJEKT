package Mluveni;
/**
 * Trida ktera inicializuje nastvany pozdrav
 * @author MAREK KULHÁNEK
 */
public class NastvaneMluveni implements StrategieMluveni{
    /**
     * Vypise pozdrav nastvaneho npc
     * @return vraci pozdrav
     */
    @Override
    public String pozdrav() {
        return "CO CHCES!";
    }
    /**
     * Vypise rozlouceni nastvaneho npc
     * @return vraci rozlouceni
     */

    @Override
    public String rozlouceni() {
        return "VYPADNI!";
    }
}
