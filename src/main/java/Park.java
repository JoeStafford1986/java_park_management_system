import Animals.AnimalAttraction;

import java.util.ArrayList;

public class Park {
    private ArrayList<Paddock> paddocks;

    public Park() {
        paddocks = new ArrayList<>();
    }

    public int getPaddocksCount() {
        return this.paddocks.size();
    }

    public void addPaddock(Paddock paddock) {
        this.paddocks.add(paddock);
    }

    public void transferAnimalAttractionBetweenPaddocks(AnimalAttraction animalToTransfer, Paddock originPaddock, Paddock destinationPaddock) {
        originPaddock.removeAnimalAttraction(animalToTransfer);
        destinationPaddock.addAnimalAttraction(animalToTransfer);
    }
}
