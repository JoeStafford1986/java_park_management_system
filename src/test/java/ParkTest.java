import Animals.AnimalAttraction;
import Animals.Terrestrial;
import Enums.DietType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParkTest {
    private Park park;
    private Paddock originEnclosedPaddock;
    private Paddock destinationEnclosedPaddock;
    private Terrestrial herbivoreTerrestrial1;
    private Terrestrial herbivoreTerrestrial2;
    private Terrestrial carnivoreTerrestrial1;

    @Before
    public void before() {
        park = new Park();
        originEnclosedPaddock = new Paddock(true);
        destinationEnclosedPaddock = new Paddock(true);
        herbivoreTerrestrial1 = new Terrestrial("Stegosaurus", DietType.HERBIVORE);
        herbivoreTerrestrial2 = new Terrestrial("Brontosaurus", DietType.HERBIVORE);
        carnivoreTerrestrial1 = new Terrestrial("Velociraptor", DietType.CARNIVORE);

    }

    @Test
    public void checkPaddocksStartEmpty() {
        assertEquals(0, park.getPaddocksCount());
    }

    @Test
    public void canAddPaddock() {
        Paddock paddock = new Paddock(true);
        park.addPaddock(paddock);
    }

    //Transfer Tests

    @Test
    public void canTransferHerbivoreTerrestrialAnimalAttractionBetweenPaddocksEmptyPaddocks() {
        originEnclosedPaddock.addAnimalAttraction(herbivoreTerrestrial1);
        park.transferAnimalAttractionBetweenPaddocks(herbivoreTerrestrial1, originEnclosedPaddock, destinationEnclosedPaddock);
        assertEquals(0, originEnclosedPaddock.getAnimalAttractionsCount());
        assertEquals(1, destinationEnclosedPaddock.getAnimalAttractionsCount());
    }

    @Test
    public void canTransferHerbivoreTerrestrialAnimalAttractionBetweenPaddocksNotEmptyPaddocks() {
        originEnclosedPaddock.addAnimalAttraction(herbivoreTerrestrial1);
        originEnclosedPaddock.addAnimalAttraction(herbivoreTerrestrial2);
        destinationEnclosedPaddock.addAnimalAttraction(herbivoreTerrestrial1);
        park.transferAnimalAttractionBetweenPaddocks(herbivoreTerrestrial1, originEnclosedPaddock, destinationEnclosedPaddock);
        assertEquals(1, originEnclosedPaddock.getAnimalAttractionsCount());
        assertEquals(2, destinationEnclosedPaddock.getAnimalAttractionsCount());
    }

    @Test
    public void cannotTransferHerbivoreTerrestrialAnimalAttractionBetweenPaddocksWhenDestinationContainsPredator() {
        originEnclosedPaddock.addAnimalAttraction(herbivoreTerrestrial1);
        destinationEnclosedPaddock.addAnimalAttraction(carnivoreTerrestrial1);
        park.transferAnimalAttractionBetweenPaddocks(herbivoreTerrestrial1, originEnclosedPaddock, destinationEnclosedPaddock);
        assertEquals(1, originEnclosedPaddock.getAnimalAttractionsCount());
        assertEquals(1, destinationEnclosedPaddock.getAnimalAttractionsCount());
    }
}
