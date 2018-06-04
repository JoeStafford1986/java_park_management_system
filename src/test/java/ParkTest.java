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

    @Before
    public void before() {
        park = new Park();
        originEnclosedPaddock = new Paddock(true);
        destinationEnclosedPaddock = new Paddock(true);
        herbivoreTerrestrial1 = new Terrestrial("Stegosaurus", DietType.HERBIVORE);
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

    @Test
    public void canTransferTerrestrialAnimalAttractionBetweenPaddocksEmptyPaddocks() {
        originEnclosedPaddock.addAnimalAttraction(herbivoreTerrestrial1);
        park.transferAnimalAttractionBetweenPaddocks(herbivoreTerrestrial1, originEnclosedPaddock, destinationEnclosedPaddock);
        assertEquals(0, originEnclosedPaddock.getAnimalAttractionsCount());
        assertEquals(1, destinationEnclosedPaddock.getAnimalAttractionsCount());
    }
}
