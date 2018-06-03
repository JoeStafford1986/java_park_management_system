import Enums.DietType;
import Interfaces.IEdible;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DinosaurTest {
    private Dinosaur omnivoreDinosaur;
    private Dinosaur herbivoreDinosaur;
    private Dinosaur carnivoreDinosaur;
    private Feed plantBasedFeed;
    private Feed nonPlantBasedFeed;
    private IEdible plantBasedIEdible;
    private IEdible nonPlantBasedIEdible;

    @Before
    public void dinosaur() {
        omnivoreDinosaur = new Dinosaur(DietType.OMNIVORE);
        herbivoreDinosaur = new Dinosaur(DietType.HERBIVORE);
        carnivoreDinosaur = new Dinosaur(DietType.CARNIVORE);
        plantBasedFeed = new Feed(true);
        nonPlantBasedFeed = new Feed(false);
        plantBasedIEdible = new Feed(true);
        nonPlantBasedIEdible = new Feed(false);
    }

    @Test
    public void canGetOmnivoreDiet() {
        assertEquals(DietType.OMNIVORE, omnivoreDinosaur.getDiet());
    }

    //DietType Tests

    @Test
    public void canGetHerbivoreDiet() {
        assertEquals(DietType.HERBIVORE, herbivoreDinosaur.getDiet());
    }

    @Test
    public void canGetCarnivoreDiet() {
        assertEquals(DietType.CARNIVORE, carnivoreDinosaur.getDiet());
    }

    @Test
    public void checkStomachStartsEmpty() {
        assertEquals(0, omnivoreDinosaur.getStomachCount());
    }

    //Omnivore Feeding Tests

    @Test
    public void canAddPlantBasedFeedToOmnivoreStomach() {
        omnivoreDinosaur.eat(plantBasedFeed);
        assertEquals(1, omnivoreDinosaur.getStomachCount());
    }

    @Test
    public void canAddNonPlantBasedFeedToOmnivoreStomach() {
        omnivoreDinosaur.eat(nonPlantBasedFeed);
        assertEquals(1, omnivoreDinosaur.getStomachCount());
    }

    @Test
    public void canAddPlantBasedIEdibleToOmnivoreStomach() {
        omnivoreDinosaur.eat(plantBasedIEdible);
        assertEquals(1, omnivoreDinosaur.getStomachCount());
    }

    @Test
    public void canAddNonPlantBasedIEdibleToOmnivoreStomach() {
        omnivoreDinosaur.eat(nonPlantBasedIEdible);
        assertEquals(1, omnivoreDinosaur.getStomachCount());
    }

    //Herbivore Feeding tests

    @Test
    public void canAddPlantBasedFeedToHerbivoreStomach() {
        herbivoreDinosaur.eat(plantBasedFeed);
        assertEquals(1, herbivoreDinosaur.getStomachCount());
    }

    @Test
    public void cannotAddNonPlantBasedFeedToHerbivoreStomach() {
        herbivoreDinosaur.eat(nonPlantBasedFeed);
        assertEquals(0, herbivoreDinosaur.getStomachCount());
    }

    @Test
    public void canAddPlantBasedIEdibleToHerbivoreStomach() {
        herbivoreDinosaur.eat(plantBasedIEdible);
        assertEquals(1, herbivoreDinosaur.getStomachCount());
    }

    @Test
    public void cannotAddNonPlantBasedIEdibleToHerbivoreStomach() {
        herbivoreDinosaur.eat(nonPlantBasedIEdible);
        assertEquals(0, herbivoreDinosaur.getStomachCount());
    }

    //Carnivore Feeding tests

    @Test
    public void cannotAddPlantBasedFeedToCarnivoreStomach() {
        carnivoreDinosaur.eat(plantBasedFeed);
        assertEquals(0, carnivoreDinosaur.getStomachCount());
    }

    @Test
    public void canAddNonPlantBasedFeedToCarnivoreStomach() {
        carnivoreDinosaur.eat(nonPlantBasedFeed);
        assertEquals(1, carnivoreDinosaur.getStomachCount());
    }

    @Test
    public void cannotAddPlantBasedIEdibleToCarnivoreStomach() {
        carnivoreDinosaur.eat(plantBasedIEdible);
        assertEquals(0, carnivoreDinosaur.getStomachCount());
    }

    @Test
    public void canAddNonPlantBasedIEdibleToCarnivoreStomach() {
        carnivoreDinosaur.eat(nonPlantBasedIEdible);
        assertEquals(1, carnivoreDinosaur.getStomachCount());
    }
}
