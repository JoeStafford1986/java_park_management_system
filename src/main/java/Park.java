import Animals.AnimalAttraction;

import java.util.ArrayList;

public class Park {
    private ArrayList<Area> areas;

    public Park() {
        areas = new ArrayList<>();
    }

    public int getAreasCount() {
        return this.areas.size();
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
