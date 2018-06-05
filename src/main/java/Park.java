import Animals.AnimalAttraction;
import People.Visitor;

import java.util.ArrayList;

public class Park {
    private ArrayList<Area> areas;
    private ArrayList<Visitor> visitors;

    public Park() {
        areas = new ArrayList<>();
        visitors = new ArrayList<>();
    }

    public int getAreasCount() {
        return this.areas.size();
    }

    public int getVisitorsCount() {
        return this.visitors.size();
    }



    public void transferAnimalAttractionBetweenPaddocks(AnimalAttraction animalToTransfer, Paddock originPaddock, Paddock destinationPaddock) {
        int currentDinosaurCount = destinationPaddock.getAnimalAttractionsCount();
        destinationPaddock.addAnimalAttraction(animalToTransfer);
        if (destinationPaddock.getAnimalAttractionsCount() == currentDinosaurCount + 1)
        {
            originPaddock.removeAnimalAttraction(animalToTransfer);
        }
    }
}
