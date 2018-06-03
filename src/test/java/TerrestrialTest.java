import Dinosaurs.Terrestrial;
import Enums.DietType;
import Interfaces.IEdible;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TerrestrialTest {
    private Terrestrial omnivoreTerrestrial;
    private Terrestrial herbivoreTerrestrial;
    private Terrestrial carnivoreTerrestrial;
    private Feed plantBasedFeed;
    private Feed nonPlantBasedFeed;
    private IEdible plantBasedIEdible;
    private IEdible nonPlantBasedIEdible;

    @Before
    public void dinosaur() {
        omnivoreTerrestrial = new Terrestrial("Gallimimus", DietType.OMNIVORE);
        herbivoreTerrestrial = new Terrestrial("Stegosaurus", DietType.HERBIVORE);
        carnivoreTerrestrial = new Terrestrial("Velociraptor", DietType.CARNIVORE);
        plantBasedFeed = new Feed(true);
        nonPlantBasedFeed = new Feed(false);
        plantBasedIEdible = new Feed(true);
        nonPlantBasedIEdible = new Feed(false);
    }

    @Test
    public void getGenera() {
        assertEquals("Velociraptor", carnivoreTerrestrial.getGenera());
    }

    //DietType Tests

    @Test
    public void canGetOmnivoreTerrestrialDiet() {
        assertEquals(DietType.OMNIVORE, omnivoreTerrestrial.getDiet());
    }

    @Test
    public void canGetHerbivoreTerrestrialDiet() {
        assertEquals(DietType.HERBIVORE, herbivoreTerrestrial.getDiet());
    }

    @Test
    public void canGetCarnivoreTerrestrialDiet() {
        assertEquals(DietType.CARNIVORE, carnivoreTerrestrial.getDiet());
    }

    @Test
    public void checkStomachStartsEmpty() {
        assertEquals(0, omnivoreTerrestrial.getStomachCount());
    }

    //Omnivore Feeding Tests

    @Test
    public void canAddPlantBasedFeedToOmnivoreStomach() {
        omnivoreTerrestrial.eat(plantBasedFeed);
        assertEquals(1, omnivoreTerrestrial.getStomachCount());
    }

    @Test
    public void canAddNonPlantBasedFeedToOmnivoreStomach() {
        omnivoreTerrestrial.eat(nonPlantBasedFeed);
        assertEquals(1, omnivoreTerrestrial.getStomachCount());
    }

    @Test
    public void canAddPlantBasedIEdibleToOmnivoreStomach() {
        omnivoreTerrestrial.eat(plantBasedIEdible);
        assertEquals(1, omnivoreTerrestrial.getStomachCount());
    }

    @Test
    public void canAddNonPlantBasedIEdibleToOmnivoreStomach() {
        omnivoreTerrestrial.eat(nonPlantBasedIEdible);
        assertEquals(1, omnivoreTerrestrial.getStomachCount());
    }

    //Herbivore Feeding tests

    @Test
    public void canAddPlantBasedFeedToHerbivoreStomach() {
        herbivoreTerrestrial.eat(plantBasedFeed);
        assertEquals(1, herbivoreTerrestrial.getStomachCount());
    }

    @Test
    public void cannotAddNonPlantBasedFeedToHerbivoreStomach() {
        herbivoreTerrestrial.eat(nonPlantBasedFeed);
        assertEquals(0, herbivoreTerrestrial.getStomachCount());
    }

    @Test
    public void canAddPlantBasedIEdibleToHerbivoreStomach() {
        herbivoreTerrestrial.eat(plantBasedIEdible);
        assertEquals(1, herbivoreTerrestrial.getStomachCount());
    }

    @Test
    public void cannotAddNonPlantBasedIEdibleToHerbivoreStomach() {
        herbivoreTerrestrial.eat(nonPlantBasedIEdible);
        assertEquals(0, herbivoreTerrestrial.getStomachCount());
    }

    //Carnivore Feeding tests

    @Test
    public void cannotAddPlantBasedFeedToCarnivoreStomach() {
        carnivoreTerrestrial.eat(plantBasedFeed);
        assertEquals(0, carnivoreTerrestrial.getStomachCount());
    }

    @Test
    public void canAddNonPlantBasedFeedToCarnivoreStomach() {
        carnivoreTerrestrial.eat(nonPlantBasedFeed);
        assertEquals(1, carnivoreTerrestrial.getStomachCount());
    }

    @Test
    public void cannotAddPlantBasedIEdibleToCarnivoreStomach() {
        carnivoreTerrestrial.eat(plantBasedIEdible);
        assertEquals(0, carnivoreTerrestrial.getStomachCount());
    }

    @Test
    public void canAddNonPlantBasedIEdibleToCarnivoreStomach() {
        carnivoreTerrestrial.eat(nonPlantBasedIEdible);
        assertEquals(1, carnivoreTerrestrial.getStomachCount());
    }
}
