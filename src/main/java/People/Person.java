package People;

import Interfaces.IEdible;

public abstract class Person implements IEdible {
    private String name;
    private boolean plantBased;

    public Person(String name) {
        this.name = name;
        this.plantBased = false;
    }

    public String getName() {
        return this.name;
    }

    public boolean checkPlantBased() {
        return this.plantBased;
    }
}
