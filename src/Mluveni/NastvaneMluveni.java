package Mluveni;

public class NastvaneMluveni implements StrategieMluveni{
    @Override
    public String pozdrav() {
        return "CO CHCES!";
    }

    @Override
    public String rozlouceni() {
        return "VYPADNI!";
    }
}
