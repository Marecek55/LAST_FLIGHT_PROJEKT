package Mluveni;
/**
 * Trida ktera inicializuje smutny pozdrav
 * @author MAREK KULHÁNEK
 */
public class SmutneMluveni implements StrategieMluveni{
    /**
     * Vypise pozdrav smutneho npc
     * @return vraci pozdrav
     */
    @Override
    public String pozdrav() {
        return "Zdravim...";
    }
    /**
     * Vypise rozlouceni stastneho npc
     * @return vraci rozlouceni
     */
    @Override
    public String rozlouceni() {
        return "Mej se:(";
    }
}
