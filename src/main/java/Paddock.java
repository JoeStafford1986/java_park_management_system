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

    public void addDinosaur(Dinosaur dinosaur) {
        if (checkForCarnivoresAndOmnivores() == false && dinosaur.getDiet() == DietType.HERBIVORE) {
            this.dinosaurs.add(dinosaur);
        }
        else if (getDinosaursCount() == 0) {
            this.dinosaurs.add(dinosaur);
        }
    }

    public void removeDinosaur(Dinosaur dinosaur) {
        this.dinosaurs.remove(dinosaur);
    }

    public boolean checkForCarnivoresAndOmnivores() {
        for (Dinosaur dinosaur : dinosaurs) {
            if (dinosaur.getDiet() == DietType.CARNIVORE || dinosaur.getDiet() ==  DietType.OMNIVORE) {
                return true;
            }
        }
        return false;
    }
}
