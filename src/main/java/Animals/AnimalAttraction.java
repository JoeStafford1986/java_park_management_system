package Animals;

import Enums.DietType;
import Interfaces.IEdible;

import java.util.ArrayList;

public abstract class AnimalAttraction implements IEdible {
    private String genera;
    private DietType diet;
    private int caloricContent;
    private boolean plantBased;
    private ArrayList<IEdible> stomach;

    public AnimalAttraction(String genera, DietType diet, int caloricContent) {
        this.genera = genera;
        this.diet = diet;
        this.caloricContent = caloricContent;
        this.stomach = new ArrayList<>();
        this.plantBased = false;
    }

    public String getGenera() {
        return this.genera;
    }

    public DietType getDiet() {
        return this.diet;
    }

    public int getCaloricContent() {
        return this.caloricContent;
    }

    public boolean checkPlantBased() {
        return this.plantBased;
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

    public int getCaloricContentInStomach() {
        int allCalories = 0;
        for (IEdible food : stomach) {
            allCalories += food.getCaloricContent();
        }
        return allCalories;
    }
}
