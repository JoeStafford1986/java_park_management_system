import Animals.Terrestrial;
import Enums.DietType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PaddockTest {
    private Paddock paddock;
    private Terrestrial omnivoreTerrestrial1;
    private Terrestrial omnivoreTerrestrial2;
    private Terrestrial herbivoreTerrestrial1;
    private Terrestrial herbivoreTerrestrial2;
    private Terrestrial carnivoreTerrestrial1;
    private Terrestrial carnivoreTerrestrial2;

    @Before
    public void before() {
        paddock = new Paddock();
        omnivoreTerrestrial1 = new Terrestrial("Gallimimus", DietType.OMNIVORE);
        omnivoreTerrestrial2 = new Terrestrial("Oviraptor", DietType.OMNIVORE);
        herbivoreTerrestrial1 = new Terrestrial("Stegosaurus", DietType.HERBIVORE);
        herbivoreTerrestrial2 = new Terrestrial("Triceratops", DietType.HERBIVORE);
        carnivoreTerrestrial1 = new Terrestrial("Velociraptor", DietType.CARNIVORE);
        carnivoreTerrestrial2 = new Terrestrial(" Giganotosaurus", DietType.CARNIVORE);
    }

    @Test
    public void checkPaddockStartsEmpty() {
        assertEquals(0, paddock.getAnimalAttractionsCount());
    }

    //Adding Carnivore Tests

    @Test
    public void canAddCarnivoreTerrestrial() {
        paddock.addAnimalAttraction(carnivoreTerrestrial1);
        assertEquals(1, paddock.getAnimalAttractionsCount());
    }

    @Test
    public void cannotAddCarnivoreTerrestialDueToHerbivore() {
        paddock.addAnimalAttraction(herbivoreTerrestrial1);
        paddock.addAnimalAttraction(carnivoreTerrestrial1);
        assertEquals(1, paddock.getAnimalAttractionsCount());
    }

    @Test
    public void cannotAddCarnivoreTerrestialDueToOmnivore() {
        paddock.addAnimalAttraction(omnivoreTerrestrial1);
        paddock.addAnimalAttraction(carnivoreTerrestrial1);
        assertEquals(1, paddock.getAnimalAttractionsCount());
    }

    @Test
    public void cannotAddCarnivoreTerrestialDueToCarnivore() {
        paddock.addAnimalAttraction(carnivoreTerrestrial1);
        paddock.addAnimalAttraction(carnivoreTerrestrial2);
        assertEquals(1, paddock.getAnimalAttractionsCount());
    }

    @Test
    public void canAddCarnivoreTerrestialDueToOtherCarnivoreBeingSameGenera() {
        paddock.addAnimalAttraction(carnivoreTerrestrial1);
        paddock.addAnimalAttraction(carnivoreTerrestrial1);
        assertEquals(2, paddock.getAnimalAttractionsCount());
    }

    //Adding Omnivore Tests

    @Test
    public void canAddOmnivoreTerrestrial() {
        paddock.addAnimalAttraction(omnivoreTerrestrial1);
        assertEquals(1, paddock.getAnimalAttractionsCount());
    }

    @Test
    public void cannotAddOmnivoreTerrestrialDueToHerbivore() {
        paddock.addAnimalAttraction(herbivoreTerrestrial1);
        paddock.addAnimalAttraction(omnivoreTerrestrial1);
        assertEquals(1, paddock.getAnimalAttractionsCount());
    }

    @Test
    public void cannotAddOmnivoreTerrestialDueToCarnivore() {
        paddock.addAnimalAttraction(carnivoreTerrestrial1);
        paddock.addAnimalAttraction(omnivoreTerrestrial1);
        assertEquals(1, paddock.getAnimalAttractionsCount());
    }

    @Test
    public void cannotAddOmnivoreTerrestrialDueToOmnivore() {
        paddock.addAnimalAttraction(omnivoreTerrestrial1);
        paddock.addAnimalAttraction(omnivoreTerrestrial2);
        assertEquals(1, paddock.getAnimalAttractionsCount());
    }

    @Test
    public void canAddOmnivoreTerrestrialDueToOtherOmnivoreBeingSameGenera() {
        paddock.addAnimalAttraction(omnivoreTerrestrial1);
        paddock.addAnimalAttraction(omnivoreTerrestrial1);
        assertEquals(2, paddock.getAnimalAttractionsCount());
    }

    //Adding Herbivore Tests

    @Test
    public void canAddHerbivoreTerrestial() {
        paddock.addAnimalAttraction(herbivoreTerrestrial1);
        assertEquals(1, paddock.getAnimalAttractionsCount());
    }

    @Test
    public void canAddMultipleHerbivoreTerrestialsOfSameGenera() {
        paddock.addAnimalAttraction(herbivoreTerrestrial1);
        paddock.addAnimalAttraction(herbivoreTerrestrial1);
        assertEquals(2, paddock.getAnimalAttractionsCount());
    }

    @Test
    public void canAddMultipleHerbivoreTerrestialsOfDifferentGenera() {
        paddock.addAnimalAttraction(herbivoreTerrestrial1);
        paddock.addAnimalAttraction(herbivoreTerrestrial2);
        assertEquals(2, paddock.getAnimalAttractionsCount());
    }

    @Test
    public void cannotAddHerbivoreTerrestialDueToOmnivoreTerrestial() {
        paddock.addAnimalAttraction(omnivoreTerrestrial1);
        paddock.addAnimalAttraction(herbivoreTerrestrial1);
        assertEquals(1, paddock.getAnimalAttractionsCount());
    }

    @Test
    public void cannotAddHerbivoreTerrestialDueToCarnivoreTerrestial() {
        paddock.addAnimalAttraction(carnivoreTerrestrial1);
        paddock.addAnimalAttraction(herbivoreTerrestrial1);
        assertEquals(1, paddock.getAnimalAttractionsCount());
    }

    //Check for Predator Tests

    @Test
    public void canCheckForCarnivoreTerrestialsWhenEmpty() {
        assertEquals(false, paddock.checkForPredators());
    }

    @Test
    public void canCheckForCarnivoreTerrestialsInPaddockTrue() {
        paddock.addAnimalAttraction(carnivoreTerrestrial1);
        assertEquals(true, paddock.checkForPredators());
    }

    @Test
    public void canCheckForOmnivoreTerrestialsInPaddockTrue() {
        paddock.addAnimalAttraction(omnivoreTerrestrial1);
        assertEquals(true, paddock.checkForPredators());
    }

    @Test
    public void canCheckForCarnivoreTerrestialsAndOmnivoreTerrestialsInPaddockFalse() {
        paddock.addAnimalAttraction(herbivoreTerrestrial1);
        assertEquals(false, paddock.checkForPredators());
    }
//
//    //Check Which Predator Tests
//
//    @Test
//    public void canGetGeneraOfPredatorGeneraInPaddockPredatorExists() {
//        paddock.addAnimalAttraction(carnivoreTerrestrial1);
//        assertEquals("Velociraptor", paddock.getGeneraOfPredator());
//    }

    //Remove AnimalAttraction Tests

    @Test
    public void canRemoveCarnivoreTerrestrial() {
        paddock.addAnimalAttraction(carnivoreTerrestrial1);
        paddock.removeAnimalAttraction(carnivoreTerrestrial1);
        assertEquals(0, paddock.getAnimalAttractionsCount());
    }
}
