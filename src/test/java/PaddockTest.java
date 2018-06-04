import Animals.Avian;
import Animals.Terrestrial;
import Enums.DietType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PaddockTest {
    private Paddock paddockNotEnclosed;
    private Paddock paddockEnclosed;
    private Terrestrial omnivoreTerrestrial1;
    private Terrestrial omnivoreTerrestrial2;
    private Terrestrial herbivoreTerrestrial1;
    private Terrestrial herbivoreTerrestrial2;
    private Terrestrial carnivoreTerrestrial1;
    private Terrestrial carnivoreTerrestrial2;
    private Avian carnivoreAvian;

    @Before
    public void before() {
        paddockNotEnclosed = new Paddock(false);
        paddockEnclosed = new Paddock(true);
        omnivoreTerrestrial1 = new Terrestrial("Gallimimus", DietType.OMNIVORE);
        omnivoreTerrestrial2 = new Terrestrial("Oviraptor", DietType.OMNIVORE);
        herbivoreTerrestrial1 = new Terrestrial("Stegosaurus", DietType.HERBIVORE);
        herbivoreTerrestrial2 = new Terrestrial("Triceratops", DietType.HERBIVORE);
        carnivoreTerrestrial1 = new Terrestrial("Velociraptor", DietType.CARNIVORE);
        carnivoreTerrestrial2 = new Terrestrial(" Giganotosaurus", DietType.CARNIVORE);
        carnivoreAvian = new Avian("Sinosauropteryx", DietType.CARNIVORE);
    }

    @Test
    public void checkPaddockStartsEmpty() {
        assertEquals(0, paddockNotEnclosed.getAnimalAttractionsCount());
    }

    @Test
    public void canCheckEnclosedTrue() {
        assertEquals(true, paddockEnclosed.checkEnclosed());
    }

    @Test
    public void canCheckEnclosedFalse() {
        assertEquals(false, paddockNotEnclosed.checkEnclosed());
    }

    //Adding Carnivore Tests

    @Test
    public void canAddCarnivoreTerrestrialToNonEnclosedPaddock() {
        paddockNotEnclosed.addAnimalAttraction(carnivoreTerrestrial1);
        assertEquals(1, paddockNotEnclosed.getAnimalAttractionsCount());
    }

    @Test
    public void canAddCarnivoreTerrestrialToEnclosedPaddock() {
        paddockEnclosed.addAnimalAttraction(carnivoreTerrestrial1);
        assertEquals(1, paddockEnclosed.getAnimalAttractionsCount());
    }

    @Test
    public void cannotAddCarnivoreTerrestrialDueToHerbivore() {
        paddockNotEnclosed.addAnimalAttraction(herbivoreTerrestrial1);
        paddockNotEnclosed.addAnimalAttraction(carnivoreTerrestrial1);
        assertEquals(1, paddockNotEnclosed.getAnimalAttractionsCount());
    }

    @Test
    public void cannotAddCarnivoreTerrestrialDueToOmnivore() {
        paddockNotEnclosed.addAnimalAttraction(omnivoreTerrestrial1);
        paddockNotEnclosed.addAnimalAttraction(carnivoreTerrestrial1);
        assertEquals(1, paddockNotEnclosed.getAnimalAttractionsCount());
    }

    @Test
    public void cannotAddCarnivoreTerrestrialDueToCarnivore() {
        paddockNotEnclosed.addAnimalAttraction(carnivoreTerrestrial1);
        paddockNotEnclosed.addAnimalAttraction(carnivoreTerrestrial2);
        assertEquals(1, paddockNotEnclosed.getAnimalAttractionsCount());
    }

    @Test
    public void canAddCarnivoreTerrestrialDueToOtherCarnivoreBeingSameGenera() {
        paddockNotEnclosed.addAnimalAttraction(carnivoreTerrestrial1);
        paddockNotEnclosed.addAnimalAttraction(carnivoreTerrestrial1);
        assertEquals(2, paddockNotEnclosed.getAnimalAttractionsCount());
    }

    //Adding Omnivore Tests

    @Test
    public void canAddOmnivoreTerrestrialToNonEnclosedPaddock() {
        paddockNotEnclosed.addAnimalAttraction(omnivoreTerrestrial1);
        assertEquals(1, paddockNotEnclosed.getAnimalAttractionsCount());
    }

    @Test
    public void canAddOmnivoreTerrestrialToEnclosedPaddock() {
        paddockEnclosed.addAnimalAttraction(omnivoreTerrestrial1);
        assertEquals(1, paddockEnclosed.getAnimalAttractionsCount());
    }


    @Test
    public void cannotAddOmnivoreTerrestrialDueToHerbivore() {
        paddockNotEnclosed.addAnimalAttraction(herbivoreTerrestrial1);
        paddockNotEnclosed.addAnimalAttraction(omnivoreTerrestrial1);
        assertEquals(1, paddockNotEnclosed.getAnimalAttractionsCount());
    }

    @Test
    public void cannotAddOmnivoreTerrestrialDueToCarnivore() {
        paddockNotEnclosed.addAnimalAttraction(carnivoreTerrestrial1);
        paddockNotEnclosed.addAnimalAttraction(omnivoreTerrestrial1);
        assertEquals(1, paddockNotEnclosed.getAnimalAttractionsCount());
    }

    @Test
    public void cannotAddOmnivoreTerrestrialDueToOmnivore() {
        paddockNotEnclosed.addAnimalAttraction(omnivoreTerrestrial1);
        paddockNotEnclosed.addAnimalAttraction(omnivoreTerrestrial2);
        assertEquals(1, paddockNotEnclosed.getAnimalAttractionsCount());
    }

    @Test
    public void canAddOmnivoreTerrestrialDueToOtherOmnivoreBeingSameGenera() {
        paddockNotEnclosed.addAnimalAttraction(omnivoreTerrestrial1);
        paddockNotEnclosed.addAnimalAttraction(omnivoreTerrestrial1);
        assertEquals(2, paddockNotEnclosed.getAnimalAttractionsCount());
    }

    //Adding Herbivore Tests

    @Test
    public void canAddHerbivoreTerrestrialToNonEnclosedPaddock() {
        paddockNotEnclosed.addAnimalAttraction(herbivoreTerrestrial1);
        assertEquals(1, paddockNotEnclosed.getAnimalAttractionsCount());
    }

    @Test
    public void canAddHerbivoreTerrestrialToOEnclosedPaddock() {
        paddockEnclosed.addAnimalAttraction(herbivoreTerrestrial1);
        assertEquals(1, paddockEnclosed.getAnimalAttractionsCount());
    }

    @Test
    public void canAddMultipleHerbivoreTerrestrialsOfSameGenera() {
        paddockNotEnclosed.addAnimalAttraction(herbivoreTerrestrial1);
        paddockNotEnclosed.addAnimalAttraction(herbivoreTerrestrial1);
        assertEquals(2, paddockNotEnclosed.getAnimalAttractionsCount());
    }

    @Test
    public void canAddMultipleHerbivoreTerrestrialsOfDifferentGenera() {
        paddockNotEnclosed.addAnimalAttraction(herbivoreTerrestrial1);
        paddockNotEnclosed.addAnimalAttraction(herbivoreTerrestrial2);
        assertEquals(2, paddockNotEnclosed.getAnimalAttractionsCount());
    }

    @Test
    public void cannotAddHerbivoreTerrestrialDueToOmnivoreTerrestrial() {
        paddockNotEnclosed.addAnimalAttraction(omnivoreTerrestrial1);
        paddockNotEnclosed.addAnimalAttraction(herbivoreTerrestrial1);
        assertEquals(1, paddockNotEnclosed.getAnimalAttractionsCount());
    }

    @Test
    public void cannotAddHerbivoreTerrestrialDueToCarnivoreTerrestrial() {
        paddockNotEnclosed.addAnimalAttraction(carnivoreTerrestrial1);
        paddockNotEnclosed.addAnimalAttraction(herbivoreTerrestrial1);
        assertEquals(1, paddockNotEnclosed.getAnimalAttractionsCount());
    }

    // Adding Avian Animal Attractions Tests

    @Test
    public void canAddAvianToEnclosedPaddock() {
        paddockEnclosed.addAnimalAttraction(carnivoreAvian);
        assertEquals(1, paddockEnclosed.getAnimalAttractionsCount());
    }

    @Test
    public void cannotAddAvianToNonEnclosedPaddock() {
        paddockEnclosed.addAnimalAttraction(carnivoreAvian);
        assertEquals(0, paddockNotEnclosed.getAnimalAttractionsCount());
    }

    //Check for Predator Tests

    @Test
    public void canCheckForCarnivoreTerrestrialsWhenEmpty() {
        assertEquals(false, paddockNotEnclosed.checkForPredators());
    }

    @Test
    public void canCheckForCarnivoreTerrestrialsInPaddockTrue() {
        paddockNotEnclosed.addAnimalAttraction(carnivoreTerrestrial1);
        assertEquals(true, paddockNotEnclosed.checkForPredators());
    }

    @Test
    public void canCheckForOmnivoreTerrestrialsInPaddockTrue() {
        paddockNotEnclosed.addAnimalAttraction(omnivoreTerrestrial1);
        assertEquals(true, paddockNotEnclosed.checkForPredators());
    }

    @Test
    public void canCheckForCarnivoreTerrestrialsAndOmnivoreTerrestrialsInPaddockFalse() {
        paddockNotEnclosed.addAnimalAttraction(herbivoreTerrestrial1);
        assertEquals(false, paddockNotEnclosed.checkForPredators());
    }

    //Remove AnimalAttraction Tests

    @Test
    public void canRemoveCarnivoreTerrestrial() {
        paddockNotEnclosed.addAnimalAttraction(carnivoreTerrestrial1);
        paddockNotEnclosed.removeAnimalAttraction(carnivoreTerrestrial1);
        assertEquals(0, paddockNotEnclosed.getAnimalAttractionsCount());
    }
}
