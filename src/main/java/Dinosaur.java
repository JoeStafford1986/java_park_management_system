import Enums.DietType;
import Interfaces.IEdible;

import java.util.ArrayList;

public class Dinosaur {
    private DietType diet;
    private ArrayList<IEdible> stomach;

    public Dinosaur(DietType diet) {
        this.diet = diet;
        this.stomach = new ArrayList<>();
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
