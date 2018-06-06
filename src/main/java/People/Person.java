package People;

import Interfaces.IEdible;

public abstract class Person implements IEdible {
    private String name;
    private boolean plantBased;
    private int caloricContent;

    public Person(String name, int caloricContent) {
        this.name = name;
        this.caloricContent = caloricContent;
        this.plantBased = false;
    }

    public String getName() {
        return this.name;
    }

    public int getCaloricContent() {
        return this.caloricContent;
    }

    public boolean checkPlantBased() {
        return this.plantBased;
    }
}
