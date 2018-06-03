package Dinosaurs;

import Enums.DietType;
import Interfaces.IEdible;

import java.util.ArrayList;

public class Terrestrial extends Dinosaur {

    public Terrestrial(String genera, DietType diet) {
        super(genera, diet);
        ArrayList<IEdible> stomach = new ArrayList<>();
    }

}
