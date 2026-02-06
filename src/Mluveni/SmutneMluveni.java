package Mluveni;
/**
 * Trida ktera inicializuje smutny pozdrav
 */
public class SmutneMluveni implements StrategieMluveni{
    /**
     * Vypise pozdrav smutneho npc
     * @return
     */
    @Override
    public String pozdrav() {
        return "Zdravim...";
    }
    /**
     * Vypise rozlouceni stastneho npc
     * @return
     */
    @Override
    public String rozlouceni() {
        return "Mej se:(";
    }
}
