package Mluveni;

public class SmutneMluveni implements StrategieMluveni{
    @Override
    public String pozdrav() {
        return "Zdravim...";
    }

    @Override
    public String rozlouceni() {
        return "Mej se:(";
    }
}
