import Dinosaurs.Terrestrial;
import Enums.DietType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PaddockTest {
    private Paddock paddock;
    private Terrestrial omnivoreTerrestial;
    private Terrestrial herbivoreTerrestial;
    private Terrestrial carnivoreTerrestial;

    @Before
    public void before() {
        paddock = new Paddock();
        omnivoreTerrestial = new Terrestrial("Gallimimus", DietType.OMNIVORE);
        herbivoreTerrestial = new Terrestrial("Stegosaurus", DietType.HERBIVORE);
        carnivoreTerrestial = new Terrestrial("Velociraptor", DietType.CARNIVORE);
    }

    @Test
    public void checkPaddockStartsEmpty() {
        assertEquals(0, paddock.getDinosaursCount());
    }

    //Adding Carnivore Tests

    @Test
    public void canAddCarnivoreTerrestial() {
        paddock.addDinosaur(carnivoreTerrestial);
        assertEquals(1, paddock.getDinosaursCount());
    }

    @Test
    public void cannotAddCarnivoreTerrestialDueToHerbivore() {
        paddock.addDinosaur(herbivoreTerrestial);
        paddock.addDinosaur(carnivoreTerrestial);
        assertEquals(1, paddock.getDinosaursCount());
    }

    @Test
    public void cannotAddCarnivoreTerrestialDueToOmnivore() {
        paddock.addDinosaur(omnivoreTerrestial);
        paddock.addDinosaur(carnivoreTerrestial);
        assertEquals(1, paddock.getDinosaursCount());
    }

    @Test
    public void cannotAddCarnivoreTerrestialDueToCarnivore() {
        paddock.addDinosaur(carnivoreTerrestial);
        paddock.addDinosaur(carnivoreTerrestial);
        assertEquals(1, paddock.getDinosaursCount());
    }

    //Adding Omnivore Tests

    @Test
    public void canAddOmnivoreTerrestial() {
        paddock.addDinosaur(omnivoreTerrestial);
        assertEquals(1, paddock.getDinosaursCount());
    }

    @Test
    public void cannotAddOmnivoreTerrestialDueToHerbivore() {
        paddock.addDinosaur(herbivoreTerrestial);
        paddock.addDinosaur(omnivoreTerrestial);
        assertEquals(1, paddock.getDinosaursCount());
    }

    @Test
    public void cannotAddOmnivoreTerrestialDueToOmnivore() {
        paddock.addDinosaur(omnivoreTerrestial);
        paddock.addDinosaur(omnivoreTerrestial);
        assertEquals(1, paddock.getDinosaursCount());
    }

    @Test
    public void cannotAddOmnivoreTerrestialDueToCarnivore() {
        paddock.addDinosaur(carnivoreTerrestial);
        paddock.addDinosaur(omnivoreTerrestial);
        assertEquals(1, paddock.getDinosaursCount());
    }

    //Adding Herbivore Tests

    @Test
    public void canAddHerbivoreTerrestial() {
        paddock.addDinosaur(herbivoreTerrestial);
        assertEquals(1, paddock.getDinosaursCount());
    }

    @Test
    public void canAddMultipleHerbivoreTerrestials() {
        paddock.addDinosaur(herbivoreTerrestial);
        paddock.addDinosaur(herbivoreTerrestial);
        assertEquals(2, paddock.getDinosaursCount());
    }

    @Test
    public void cannotAddHerbivoreTerrestialDueToOmnivoreTerrestial() {
        paddock.addDinosaur(omnivoreTerrestial);
        paddock.addDinosaur(herbivoreTerrestial);
        assertEquals(1, paddock.getDinosaursCount());
    }

    @Test
    public void cannotAddHerbivoreTerrestialDueToCarnivoreTerrestial() {
        paddock.addDinosaur(carnivoreTerrestial);
        paddock.addDinosaur(herbivoreTerrestial);
        assertEquals(1, paddock.getDinosaursCount());
    }

    //Check for Omnivores/Carnivores

    @Test
    public void canCheckForCarnivoreTerrestialsInPaddockTrue() {
        paddock.addDinosaur(carnivoreTerrestial);
        assertEquals(true, paddock.checkForCarnivoresAndOmnivores());
    }

    @Test
    public void canCheckForOmnivoreTerrestialsInPaddockTrue() {
        paddock.addDinosaur(omnivoreTerrestial);
        assertEquals(true, paddock.checkForCarnivoresAndOmnivores());
    }

    @Test
    public void canCheckForCarnivoreTerrestialsAndOmnivoreTerrestialsInPaddockFalse() {
        paddock.addDinosaur(herbivoreTerrestial);
        assertEquals(false, paddock.checkForCarnivoresAndOmnivores());
    }

    //Remove Dinosaur Tests

    @Test
    public void canRemoveCarnivoreTerrestial() {
        paddock.addDinosaur(carnivoreTerrestial);
        paddock.removeDinosaur(carnivoreTerrestial);
        assertEquals(0, paddock.getDinosaursCount());
    }
}
