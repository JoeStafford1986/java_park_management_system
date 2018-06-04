import Animals.AnimalAttraction;
import Animals.Avian;
import Enums.DietType;

import java.util.ArrayList;

public class Paddock {
    private ArrayList<AnimalAttraction> animalAttractions;
    private boolean enclosed;

    public Paddock(boolean enclosed) {
        this.animalAttractions = new ArrayList<>();
        this.enclosed = enclosed;
    }

    public boolean checkEnclosed() {
        return this.enclosed;
    }

    public int getAnimalAttractionsCount() {
        return this.animalAttractions.size();
    }

    public boolean checkForPredators() {
        for (AnimalAttraction animalAttraction : animalAttractions) {
            if (animalAttraction.getDiet() == DietType.CARNIVORE || animalAttraction.getDiet() ==  DietType.OMNIVORE) {
                return true;
            }
        }
        return false;
    }

    public void addAnimalAttraction(AnimalAttraction animalAttraction) {
        if (animalAttractions.getClass().isAssignableFrom(Avian.class) && !this.enclosed) {
            return;
        }
        if (getAnimalAttractionsCount() == 0 || (!checkForPredators() && animalAttraction.getDiet() == DietType.HERBIVORE)) {
            this.animalAttractions.add(animalAttraction);
        } else if (animalAttraction.getDiet() != DietType.HERBIVORE && animalAttractions.get(0).getGenera() == animalAttraction.getGenera()) {
            this.animalAttractions.add(animalAttraction);
        }
    }

    public void removeAnimalAttraction(AnimalAttraction animalAttraction) {
        this.animalAttractions.remove(animalAttraction);
    }
}
