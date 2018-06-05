import Animals.AnimalAttraction;
import Animals.Avian;
import Animals.Terrestrial;
import Enums.DietType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParkTest {
    private Park park;
//    private Paddock originEnclosedPaddock;
//    private Paddock destinationEnclosedPaddock;
//    private Paddock destinationNonEnclosedPaddock;
//    private Terrestrial herbivoreTerrestrial1;
//    private Terrestrial herbivoreTerrestrial2;
//    private Terrestrial carnivoreTerrestrial1;
//    private Terrestrial carnivoreTerrestrial2;
//    private Terrestrial carnivoreTerrestrial3;
//    private Avian carnivoreAvian1;

    @Before
    public void before() {
        park = new Park();
//        originEnclosedPaddock = new Paddock(true);
//        destinationEnclosedPaddock = new Paddock(true);
//        destinationNonEnclosedPaddock = new Paddock(false);
//        herbivoreTerrestrial1 = new Terrestrial("Stegosaurus", DietType.HERBIVORE);
//        herbivoreTerrestrial2 = new Terrestrial("Brontosaurus", DietType.HERBIVORE);
//        carnivoreTerrestrial1 = new Terrestrial("Velociraptor", DietType.CARNIVORE);
//        carnivoreTerrestrial2 = new Terrestrial("Giganotosaurus", DietType.CARNIVORE);
//        carnivoreTerrestrial3 = new Terrestrial("Velociraptor", DietType.CARNIVORE);
//        carnivoreAvian1 = new Avian("Sinosauropteryx", DietType.CARNIVORE);
    }

    @Test
    public void checkAreasStartsEmpty() {
        assertEquals(0, park.getAreasCount());
    }
//
//    //Transfer Tests
//
//    @Test
//    public void canTransferHerbivoreTerrestrialAnimalAttractionBetweenPaddocksEmptyPaddocks() {
//        originEnclosedPaddock.addAnimalAttraction(herbivoreTerrestrial1);
//        park.transferAnimalAttractionBetweenPaddocks(herbivoreTerrestrial1, originEnclosedPaddock, destinationEnclosedPaddock);
//        assertEquals(0, originEnclosedPaddock.getAnimalAttractionsCount());
//        assertEquals(1, destinationEnclosedPaddock.getAnimalAttractionsCount());
//    }
//
//    @Test
//    public void canTransferHerbivoreTerrestrialAnimalAttractionBetweenPaddocksNotEmptyPaddocks() {
//        originEnclosedPaddock.addAnimalAttraction(herbivoreTerrestrial1);
//        originEnclosedPaddock.addAnimalAttraction(herbivoreTerrestrial2);
//        destinationEnclosedPaddock.addAnimalAttraction(herbivoreTerrestrial1);
//        park.transferAnimalAttractionBetweenPaddocks(herbivoreTerrestrial1, originEnclosedPaddock, destinationEnclosedPaddock);
//        assertEquals(1, originEnclosedPaddock.getAnimalAttractionsCount());
//        assertEquals(2, destinationEnclosedPaddock.getAnimalAttractionsCount());
//    }
//
//    @Test
//    public void cannotTransferHerbivoreTerrestrialAnimalAttractionBetweenPaddocksWhenDestinationContainsPredator() {
//        originEnclosedPaddock.addAnimalAttraction(herbivoreTerrestrial1);
//        destinationEnclosedPaddock.addAnimalAttraction(carnivoreTerrestrial1);
//        park.transferAnimalAttractionBetweenPaddocks(herbivoreTerrestrial1, originEnclosedPaddock, destinationEnclosedPaddock);
//        assertEquals(1, originEnclosedPaddock.getAnimalAttractionsCount());
//        assertEquals(1, destinationEnclosedPaddock.getAnimalAttractionsCount());
//    }
//
//    @Test
//    public void cannotTransferCarnivoreTerrestrialAnimalAttractionBetweenPaddocksWhenDestinationContainsDifferentPredator() {
//        originEnclosedPaddock.addAnimalAttraction(carnivoreTerrestrial1);
//        destinationEnclosedPaddock.addAnimalAttraction(carnivoreTerrestrial2);
//        park.transferAnimalAttractionBetweenPaddocks(carnivoreTerrestrial1, originEnclosedPaddock, destinationEnclosedPaddock);
//        assertEquals(1, originEnclosedPaddock.getAnimalAttractionsCount());
//        assertEquals(1, destinationEnclosedPaddock.getAnimalAttractionsCount());
//    }
//
//    @Test
//    public void canTransferCarnivoreTerrestrialAnimalAttractionBetweenPaddocksWhenDestinationContainsSameTypeOfPredator() {
//        originEnclosedPaddock.addAnimalAttraction(carnivoreTerrestrial1);
//        destinationEnclosedPaddock.addAnimalAttraction(carnivoreTerrestrial3);
//        park.transferAnimalAttractionBetweenPaddocks(carnivoreTerrestrial1, originEnclosedPaddock, destinationEnclosedPaddock);
//        assertEquals(0, originEnclosedPaddock.getAnimalAttractionsCount());
//        assertEquals(2, destinationEnclosedPaddock.getAnimalAttractionsCount());
//    }
//
//    @Test
//    public void canTransferAvianCarnivoreFromEnclosedPaddockToEnclosedPaddock() {
//        originEnclosedPaddock.addAnimalAttraction(carnivoreAvian1);
//        park.transferAnimalAttractionBetweenPaddocks(carnivoreAvian1, originEnclosedPaddock, destinationEnclosedPaddock);
//    }
//
//    @Test
//    public void cannotTransferAvianCarnivoreFromEnclosedPaddockToNonEnclosedPaddock() {
//        originEnclosedPaddock.addAnimalAttraction(carnivoreAvian1);
//        park.transferAnimalAttractionBetweenPaddocks(carnivoreAvian1, originEnclosedPaddock, destinationNonEnclosedPaddock);
//        assertEquals(0, destinationEnclosedPaddock.getAnimalAttractionsCount());
//    }
}
