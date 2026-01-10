package Cas;

public class CasSeZranenim implements StrategieCasu{
    @Override
    public int spocteniCasu(int zaklad) {
        return zaklad*3;
    }
}
