package Dinosaurs;

import Enums.DietType;
import Interfaces.IEdible;

import java.util.ArrayList;

public abstract class Dinosaur {
    private String genera;
    private DietType diet;
    private ArrayList<IEdible> stomach;

    public Dinosaur(String genera, DietType diet) {
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

    public void eat(IEdible feed) {
        if ((this.getDiet() == DietType.CARNIVORE && feed.checkPlantBased() == true) || (this.getDiet() == DietType.HERBIVORE && feed.checkPlantBased() == false)) {
            return;
        }
        this.stomach.add(feed);
    }
}
