import Dinosaurs.Dinosaur;
import Enums.DietType;

import java.util.ArrayList;

public class Paddock {
    private ArrayList<Dinosaur> dinosaurs;

    public Paddock() {
        this.dinosaurs = new ArrayList<>();
    }

    public int getDinosaursCount() {
        return this.dinosaurs.size();
    }

    public boolean checkForPredators() {
        for (Dinosaur dinosaur : dinosaurs) {
            if (dinosaur.getDiet() == DietType.CARNIVORE || dinosaur.getDiet() ==  DietType.OMNIVORE) {
                return true;
            }
        }
        return false;
    }

    public void addDinosaur(Dinosaur dinosaur) {
        if (getDinosaursCount() == 0 || (!checkForPredators() && dinosaur.getDiet() == DietType.HERBIVORE)) {
            this.dinosaurs.add(dinosaur);
        } else if (dinosaur.getDiet() != DietType.HERBIVORE && dinosaurs.get(0).getGenera() == dinosaur.getGenera()) {
            this.dinosaurs.add(dinosaur);
        }
    }

    public void removeDinosaur(Dinosaur dinosaur) {
        this.dinosaurs.remove(dinosaur);
    }
}
