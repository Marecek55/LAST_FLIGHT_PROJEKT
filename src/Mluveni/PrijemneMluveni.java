package Mluveni;

public class PrijemneMluveni implements StrategieMluveni{
    @Override
    public String pozdrav() {
        return "Ahojky";
    }

    @Override
    public String rozlouceni() {
        return "Hodne stesti";
    }
}
