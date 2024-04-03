package task3;

import lombok.Getter;

import java.util.Set;

public class Planet {
    private final String name;

    @Getter
    private final Set<Creature> creatures;

    public Planet(String name, Set<Creature> creatures) {
        if (name == null) {
            throw new IllegalArgumentException("planet name can't be null");
        }
        if (creatures == null) {
            throw new IllegalArgumentException("creatures can't be null");
        }
        this.name = name;
        this.creatures = creatures;
    }

    public void addCreature(Creature creature) {
        if (creature == null) {
            throw new IllegalArgumentException("creature can't be null");
        }
        creatures.add(creature);
    }

    public void removeCreature(Creature creature) {
        if (creature == null) {
            throw new IllegalArgumentException("creature can't be null");
        }
        creatures.remove(creature);
    }


    public String conflict(Set<Invent> invents) {
        int dolphinInventCount = 0;
        int peopleInventCount = 0;
        for (Creature creature : creatures) {
            for (Invent invent : invents) {
                if (creature.invents().contains(invent)) {
                    if (creature.getClass() == Dolphin.class) {
                        dolphinInventCount++;
                    }
                    if (creature.getClass() == People.class) {
                        peopleInventCount++;
                    }
                }
            }
        }
        if (dolphinInventCount > peopleInventCount) {
            return "дельфины правы!";
        }
        if (peopleInventCount > dolphinInventCount) {
            return "люди правы!";
        }
        return "дельфины и люди правы!";
    }
}
