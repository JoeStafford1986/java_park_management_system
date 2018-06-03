import Enums.DietType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PaddockTest {
    private Paddock paddock;
    private Dinosaur carnivoreDinosaur;
    private Dinosaur herbivoreDinosaur;
    private Dinosaur omnivoreDinosaur;

    @Before
    public void before() {
        paddock = new Paddock();
        carnivoreDinosaur = new Dinosaur(DietType.CARNIVORE);
        herbivoreDinosaur = new Dinosaur(DietType.HERBIVORE);
        omnivoreDinosaur = new Dinosaur(DietType.OMNIVORE);
    }

    @Test
    public void checkPaddockStartsEmpty() {
        assertEquals(0, paddock.getDinosaursCount());
    }

    //Adding Carnivore Tests

    @Test
    public void canAddCarnivoreDinosaur() {
        paddock.addDinosaur(carnivoreDinosaur);
        assertEquals(1, paddock.getDinosaursCount());
    }

    @Test
    public void cannotAddCarnivoreDinosaurDueToHerbivore() {
        paddock.addDinosaur(herbivoreDinosaur);
        paddock.addDinosaur(carnivoreDinosaur);
        assertEquals(1, paddock.getDinosaursCount());
    }

    @Test
    public void cannotAddCarnivoreDinosaurDueToOmnivore() {
        paddock.addDinosaur(omnivoreDinosaur);
        paddock.addDinosaur(carnivoreDinosaur);
        assertEquals(1, paddock.getDinosaursCount());
    }

    @Test
    public void cannotAddCarnivoreDinosaurDueToCarnivore() {
        paddock.addDinosaur(carnivoreDinosaur);
        paddock.addDinosaur(carnivoreDinosaur);
        assertEquals(1, paddock.getDinosaursCount());
    }

    //Adding Omnivore Tests

    @Test
    public void canAddOmnivoreDinosaur() {
        paddock.addDinosaur(omnivoreDinosaur);
        assertEquals(1, paddock.getDinosaursCount());
    }

    @Test
    public void cannotAddOmnivoreDinosaurDueToHerbivore() {
        paddock.addDinosaur(herbivoreDinosaur);
        paddock.addDinosaur(omnivoreDinosaur);
        assertEquals(1, paddock.getDinosaursCount());
    }

    @Test
    public void cannotAddOmnivoreDinosaurDueToOmnivore() {
        paddock.addDinosaur(omnivoreDinosaur);
        paddock.addDinosaur(omnivoreDinosaur);
        assertEquals(1, paddock.getDinosaursCount());
    }

    @Test
    public void cannotAddOmnivoreDinosaurDueToCarnivore() {
        paddock.addDinosaur(carnivoreDinosaur);
        paddock.addDinosaur(omnivoreDinosaur);
        assertEquals(1, paddock.getDinosaursCount());
    }

    //Adding Herbivore Tests

    @Test
    public void canAddHerbivoreDinosaur() {
        paddock.addDinosaur(herbivoreDinosaur);
        assertEquals(1, paddock.getDinosaursCount());
    }

    @Test
    public void canAddMultipleHerbivore() {
        paddock.addDinosaur(herbivoreDinosaur);
        paddock.addDinosaur(herbivoreDinosaur);
        assertEquals(2, paddock.getDinosaursCount());
    }

    @Test
    public void cannotAddHerbivoreDueToOmnivore() {
        paddock.addDinosaur(omnivoreDinosaur);
        paddock.addDinosaur(herbivoreDinosaur);
        assertEquals(1, paddock.getDinosaursCount());
    }

    @Test
    public void cannotAddHerbivoreDueToCarnivore() {
        paddock.addDinosaur(carnivoreDinosaur);
        paddock.addDinosaur(herbivoreDinosaur);
        assertEquals(1, paddock.getDinosaursCount());
    }

    //Check for Omnivores/Carnivores

    @Test
    public void canCheckForCarnivoresInPaddockTrue() {
        paddock.addDinosaur(carnivoreDinosaur);
        assertEquals(true, paddock.checkForCarnivoresAndOmnivores());
    }

    @Test
    public void canCheckForOmnivoresInPaddockTrue() {
        paddock.addDinosaur(omnivoreDinosaur);
        assertEquals(true, paddock.checkForCarnivoresAndOmnivores());
    }

    @Test
    public void canCheckForCarnivoresAndOmnivoresInPaddockFalse() {
        paddock.addDinosaur(herbivoreDinosaur);
        assertEquals(false, paddock.checkForCarnivoresAndOmnivores());
    }

    @Test
    public void canRemoveCarnivoreDinosaur() {
        paddock.addDinosaur(carnivoreDinosaur);
        paddock.removeDinosaur(carnivoreDinosaur);
        assertEquals(0, paddock.getDinosaursCount());
    }
}
