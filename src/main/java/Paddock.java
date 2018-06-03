import java.util.ArrayList;

public class Paddock {
    private ArrayList<Dinosaur> dinosaurs;

    public Paddock() {
        this.dinosaurs = new ArrayList<>();
    }

    public int getDinosaursCount() {
        return this.dinosaurs.size();
    }
}
