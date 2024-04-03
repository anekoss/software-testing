package task3;

public enum Invent {
    NEW_YORK("Нью-Йорк"),
    WHEEL("колесо"),
    WAR("война"),
    FUN("веселье"),
    HAPPINESS("счастье"),
    SWIMMING("купание");


    private final String name;

    Invent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
