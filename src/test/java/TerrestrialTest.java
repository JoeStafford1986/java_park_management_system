import Animals.Terrestrial;
import Enums.DietType;
import Interfaces.IEdible;
import People.Visitor;
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
    private Visitor visitor;

    @Before
    public void dinosaur() {
        omnivoreTerrestrial = new Terrestrial("Gallimimus", DietType.OMNIVORE);
        herbivoreTerrestrial = new Terrestrial("Stegosaurus", DietType.HERBIVORE);
        carnivoreTerrestrial = new Terrestrial("Velociraptor", DietType.CARNIVORE);
        plantBasedFeed = new Feed(true);
        nonPlantBasedFeed = new Feed(false);
        plantBasedIEdible = new Feed(true);
        nonPlantBasedIEdible = new Feed(false);
        visitor = new Visitor("Euan Bell");
    }

    @Test
    public void getGenera() {
        assertEquals("Velociraptor", carnivoreTerrestrial.getGenera());
    }

    @Test
    public void checkStomachStartsEmpty() {
        assertEquals(0, omnivoreTerrestrial.getStomachCount());
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

    @Test
    public void canAddAnimalAttractionToOmnivoreStomach() {
        omnivoreTerrestrial.eat(carnivoreTerrestrial);
        assertEquals(1, omnivoreTerrestrial.getStomachCount());
    }

    @Test
    public void canAddVisitorToOmnivoreStomach() {
        omnivoreTerrestrial.eat(visitor);
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

    @Test
    public void cannotAddAnimalAttractionToHerbivoreStomach() {
        herbivoreTerrestrial.eat(omnivoreTerrestrial);
        assertEquals(0, herbivoreTerrestrial.getStomachCount());
    }

    @Test
    public void cannotAddVisitorToHerbivoreStomach() {
        herbivoreTerrestrial.eat(visitor);
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

    @Test
    public void canAddAnimalAttractionToCarnivoreStomach() {
        carnivoreTerrestrial.eat(herbivoreTerrestrial);
        assertEquals(1, carnivoreTerrestrial.getStomachCount());
    }

    @Test
    public void canAddVisitorToCarnivoreStomach() {
        carnivoreTerrestrial.eat(visitor);
        assertEquals(1, carnivoreTerrestrial.getStomachCount());
    }
}
