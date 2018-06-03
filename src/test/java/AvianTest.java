import Dinosaurs.Avian;
import Enums.DietType;
import Interfaces.IEdible;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AvianTest {

    private Avian omnivoreAvian;
    private Avian carnivoreAvian;
    private Feed plantBasedFeed;
    private Feed nonPlantBasedFeed;
    private IEdible plantBasedIEdible;
    private IEdible nonPlantBasedIEdible;

    @Before
    public void dinosaur() {
        omnivoreAvian = new Avian("Ornithomimus", DietType.OMNIVORE);
        carnivoreAvian = new Avian("Pteranodon", DietType.CARNIVORE);
        plantBasedFeed = new Feed(true);
        nonPlantBasedFeed = new Feed(false);
        plantBasedIEdible = new Feed(true);
        nonPlantBasedIEdible = new Feed(false);
    }

    @Test
    public void getGenera() {
        assertEquals("Pteranodon", carnivoreAvian.getGenera());
    }

    //DietType Tests

    @Test
    public void canGetOmnivoreAvianDiet() {
        assertEquals(DietType.OMNIVORE, omnivoreAvian.getDiet());
    }

    @Test
    public void canGetCarnivoreAvianDiet() {
        assertEquals(DietType.CARNIVORE, carnivoreAvian.getDiet());
    }

    @Test
    public void checkStomachStartsEmpty() {
        assertEquals(0, omnivoreAvian.getStomachCount());
    }

    //Omnivore Feeding Tests

    @Test
    public void canAddPlantBasedFeedToOmnivoreStomach() {
        omnivoreAvian.eat(plantBasedFeed);
        assertEquals(1, omnivoreAvian.getStomachCount());
    }

    @Test
    public void canAddNonPlantBasedFeedToOmnivoreStomach() {
        omnivoreAvian.eat(nonPlantBasedFeed);
        assertEquals(1, omnivoreAvian.getStomachCount());
    }

    @Test
    public void canAddPlantBasedIEdibleToOmnivoreStomach() {
        omnivoreAvian.eat(plantBasedIEdible);
        assertEquals(1, omnivoreAvian.getStomachCount());
    }

    @Test
    public void canAddNonPlantBasedIEdibleToOmnivoreStomach() {
        omnivoreAvian.eat(nonPlantBasedIEdible);
        assertEquals(1, omnivoreAvian.getStomachCount());
    }

    //Carnivore Feeding tests

    @Test
    public void cannotAddPlantBasedFeedToCarnivoreStomach() {
        carnivoreAvian.eat(plantBasedFeed);
        assertEquals(0, carnivoreAvian.getStomachCount());
    }

    @Test
    public void canAddNonPlantBasedFeedToCarnivoreStomach() {
        carnivoreAvian.eat(nonPlantBasedFeed);
        assertEquals(1, carnivoreAvian.getStomachCount());
    }

    @Test
    public void cannotAddPlantBasedIEdibleToCarnivoreStomach() {
        carnivoreAvian.eat(plantBasedIEdible);
        assertEquals(0, carnivoreAvian.getStomachCount());
    }

    @Test
    public void canAddNonPlantBasedIEdibleToCarnivoreStomach() {
        carnivoreAvian.eat(nonPlantBasedIEdible);
        assertEquals(1, carnivoreAvian.getStomachCount());
    }
}
