package task3;

import java.util.Set;

public class People implements Creature {
    private final Set<Invent> invents;

    public People(Set<Invent> invents) {
        if (invents == null) {
            throw new IllegalArgumentException("invents can't be null");
        }
        this.invents = invents;
    }

    @Override
    public String think() {
        return "мы разумнее дельфинов!";
    }

    public void addInvent(Invent invent) {
        invents.add(invent);
    }

    @Override
    public Set<Invent> invents() {
        return invents;
    }

    @Override
    public boolean isGoodInvent(Invent invent) {
        if (invents.contains(invent)) {
            return true;
        }
        return false;
    }

}
