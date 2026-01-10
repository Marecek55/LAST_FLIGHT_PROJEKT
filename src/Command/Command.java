package Command;

import Zaklad.Hra;

public interface Command {
    public void vykonat(Hra hra , String s);
    public void opustit();
}
