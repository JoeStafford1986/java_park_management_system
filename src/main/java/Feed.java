import Interfaces.IEdible;

public class Feed implements IEdible {
    private boolean plantBased;

    public Feed(boolean plantBased) {
        this.plantBased = plantBased;
    }

    public boolean checkPlantBased() {
        return this.plantBased;
    }
}
