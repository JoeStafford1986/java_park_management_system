package Animals;

import Enums.DietType;
import Interfaces.IEdible;

import java.util.ArrayList;

public abstract class AnimalAttraction implements IEdible {
    private String genera;
    private DietType diet;
    private int caloricContent;
    private int requiredDailyCalories;
    private boolean plantBased;
    private ArrayList<IEdible> stomach;

    public AnimalAttraction(String genera, DietType diet, int caloricContent, int requiredDailyCalories) {
        this.genera = genera;
        this.diet = diet;
        this.caloricContent = caloricContent;
        this.requiredDailyCalories = requiredDailyCalories;
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

    public void setCaloricContent(int newCaloricContent) {
        this.caloricContent = newCaloricContent;
    }

    public int getRequiredDailyCalories() {
        return this.requiredDailyCalories;
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

    public void satiateAppetite(int hours) {
        for (int i = 0; i < hours; i++) {
            if (this.getCaloricContentInStomach() < this.requiredDailyCalories) {
                this.attemptEscape();
                return;
            } else {
                int caloriesNeeded = this.requiredDailyCalories;
                ArrayList<IEdible> digestedFood = new ArrayList<>();
                for (IEdible foodInStomach : this.stomach) {
                    caloriesNeeded -= foodInStomach.getCaloricContent();
                    if (foodInStomach.getCaloricContent() <= (this.requiredDailyCalories - caloriesNeeded)) {
                        digestedFood.add(foodInStomach);
                    } else {
                        foodInStomach.setCaloricContent(this.requiredDailyCalories - caloriesNeeded);
                        return;
                    }
                }
                for (IEdible foodInStomach : digestedFood) {
                    if (digestedFood.contains(foodInStomach)) {
                        this.stomach.remove(foodInStomach);
                    }
                }
            }
        }
    }

    public void digestFood(int days) {
        for (int i = 0; i < days; i++) {
            if (this.getCaloricContentInStomach() < this.requiredDailyCalories) {
                this.attemptEscape();
                return;
            } else {
                int caloriesNeeded = this.requiredDailyCalories;
                ArrayList<IEdible> digestedFood = new ArrayList<>();
                for (IEdible foodInStomach : this.stomach) {
                    if (caloriesNeeded >= foodInStomach.getCaloricContent()) {
                        caloriesNeeded -= foodInStomach.getCaloricContent();
                        digestedFood.add(foodInStomach);
                    } else {
                        foodInStomach.setCaloricContent(foodInStomach.getCaloricContent() - caloriesNeeded);
                    }
                }
                for (IEdible foodInStomach : digestedFood) {
                    if (digestedFood.contains(foodInStomach)) {
                        this.stomach.remove(foodInStomach);
                    }
                }
            }
        }
    }

    public boolean attemptEscape() {
        return true;
    }
}
