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
        this.dinosaurs.add(dinosaur);
    }

    public void removeDinosaur(Dinosaur dinosaur) {
        this.dinosaurs.remove(dinosaur);
    }
}
