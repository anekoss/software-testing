package task3;

import java.util.Set;

public interface Creature {

    String think();

    boolean isGoodInvent(Invent invent);

    void addInvent(Invent invent);


    Set<Invent> invents();
}
