import Interfaces.IEdible;

public class Feed implements IEdible {
    private int caloricContent;
    private boolean plantBased;

    public Feed(boolean plantBased, int caloricContent) {
        this.caloricContent = caloricContent;
        this.plantBased = plantBased;
    }

    public int getCaloricContent() {
        return this.caloricContent;
    }

    public boolean checkPlantBased() {
        return this.plantBased;
    }
}
