import Dinosaurs.Terrestrial;
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
        assertEquals(0, paddock.getDinosaursCount());
    }

    //Adding Carnivore Tests

    @Test
    public void canAddCarnivoreTerrestrial() {
        paddock.addDinosaur(carnivoreTerrestrial1);
        assertEquals(1, paddock.getDinosaursCount());
    }

    @Test
    public void cannotAddCarnivoreTerrestialDueToHerbivore() {
        paddock.addDinosaur(herbivoreTerrestrial1);
        paddock.addDinosaur(carnivoreTerrestrial1);
        assertEquals(1, paddock.getDinosaursCount());
    }

    @Test
    public void cannotAddCarnivoreTerrestialDueToOmnivore() {
        paddock.addDinosaur(omnivoreTerrestrial1);
        paddock.addDinosaur(carnivoreTerrestrial1);
        assertEquals(1, paddock.getDinosaursCount());
    }

    @Test
    public void cannotAddCarnivoreTerrestialDueToCarnivore() {
        paddock.addDinosaur(carnivoreTerrestrial1);
        paddock.addDinosaur(carnivoreTerrestrial2);
        assertEquals(1, paddock.getDinosaursCount());
    }

    @Test
    public void canAddCarnivoreTerrestialDueToOtherCarnivoreBeingSameGenera() {
        paddock.addDinosaur(carnivoreTerrestrial1);
        paddock.addDinosaur(carnivoreTerrestrial1);
        assertEquals(2, paddock.getDinosaursCount());
    }

    //Adding Omnivore Tests

    @Test
    public void canAddOmnivoreTerrestrial() {
        paddock.addDinosaur(omnivoreTerrestrial1);
        assertEquals(1, paddock.getDinosaursCount());
    }

    @Test
    public void cannotAddOmnivoreTerrestrialDueToHerbivore() {
        paddock.addDinosaur(herbivoreTerrestrial1);
        paddock.addDinosaur(omnivoreTerrestrial1);
        assertEquals(1, paddock.getDinosaursCount());
    }

    @Test
    public void cannotAddOmnivoreTerrestialDueToCarnivore() {
        paddock.addDinosaur(carnivoreTerrestrial1);
        paddock.addDinosaur(omnivoreTerrestrial1);
        assertEquals(1, paddock.getDinosaursCount());
    }

    @Test
    public void cannotAddOmnivoreTerrestrialDueToOmnivore() {
        paddock.addDinosaur(omnivoreTerrestrial1);
        paddock.addDinosaur(omnivoreTerrestrial2);
        assertEquals(1, paddock.getDinosaursCount());
    }

    @Test
    public void canAddOmnivoreTerrestrialDueToOtherOmnivoreBeingSameGenera() {
        paddock.addDinosaur(omnivoreTerrestrial1);
        paddock.addDinosaur(omnivoreTerrestrial1);
        assertEquals(2, paddock.getDinosaursCount());
    }

    //Adding Herbivore Tests

    @Test
    public void canAddHerbivoreTerrestial() {
        paddock.addDinosaur(herbivoreTerrestrial1);
        assertEquals(1, paddock.getDinosaursCount());
    }

    @Test
    public void canAddMultipleHerbivoreTerrestialsOfSameGenera() {
        paddock.addDinosaur(herbivoreTerrestrial1);
        paddock.addDinosaur(herbivoreTerrestrial1);
        assertEquals(2, paddock.getDinosaursCount());
    }

    @Test
    public void canAddMultipleHerbivoreTerrestialsOfDifferentGenera() {
        paddock.addDinosaur(herbivoreTerrestrial1);
        paddock.addDinosaur(herbivoreTerrestrial2);
        assertEquals(2, paddock.getDinosaursCount());
    }

    @Test
    public void cannotAddHerbivoreTerrestialDueToOmnivoreTerrestial() {
        paddock.addDinosaur(omnivoreTerrestrial1);
        paddock.addDinosaur(herbivoreTerrestrial1);
        assertEquals(1, paddock.getDinosaursCount());
    }

    @Test
    public void cannotAddHerbivoreTerrestialDueToCarnivoreTerrestial() {
        paddock.addDinosaur(carnivoreTerrestrial1);
        paddock.addDinosaur(herbivoreTerrestrial1);
        assertEquals(1, paddock.getDinosaursCount());
    }

    //Check for Predator Tests

    @Test
    public void canCheckForCarnivoreTerrestialsInPaddockTrue() {
        paddock.addDinosaur(carnivoreTerrestrial1);
        assertEquals(true, paddock.checkForPredators());
    }

    @Test
    public void canCheckForOmnivoreTerrestialsInPaddockTrue() {
        paddock.addDinosaur(omnivoreTerrestrial1);
        assertEquals(true, paddock.checkForPredators());
    }

    @Test
    public void canCheckForCarnivoreTerrestialsAndOmnivoreTerrestialsInPaddockFalse() {
        paddock.addDinosaur(herbivoreTerrestrial1);
        assertEquals(false, paddock.checkForPredators());
    }
//
//    //Check Which Predator Tests
//
//    @Test
//    public void canGetGeneraOfPredatorGeneraInPaddockPredatorExists() {
//        paddock.addDinosaur(carnivoreTerrestrial1);
//        assertEquals("Velociraptor", paddock.getGeneraOfPredator());
//    }

    //Remove Dinosaur Tests

    @Test
    public void canRemoveCarnivoreTerrestrial() {
        paddock.addDinosaur(carnivoreTerrestrial1);
        paddock.removeDinosaur(carnivoreTerrestrial1);
        assertEquals(0, paddock.getDinosaursCount());
    }
}
