package Animals;

import Enums.DietType;
import Interfaces.IEdible;

import java.util.ArrayList;

public abstract class AnimalAttraction {
    private String genera;
    private DietType diet;
    private ArrayList<IEdible> stomach;

    public AnimalAttraction(String genera, DietType diet) {
        this.genera = genera;
        this.diet = diet;
        this.stomach = new ArrayList<>();
    }

    public String getGenera() {
        return this.genera;
    }

    public DietType getDiet() {
        return this.diet;
    }

    public int getStomachCount() {
        return this.stomach.size();
    }

    public void eat(IEdible edible) {
        if ((this.getDiet() == DietType.CARNIVORE && edible.checkPlantBased() == true) || (this.getDiet() == DietType.HERBIVORE && edible.checkPlantBased() == false)) {
            return;
        }
        this.stomach.add(edible);
    }
}
