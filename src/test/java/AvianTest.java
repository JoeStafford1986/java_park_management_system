import Animals.Avian;
import Enums.DietType;
import Interfaces.IEdible;
import People.Staff;
import People.Visitor;
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
    private Visitor visitor;
    private Staff staff;

    @Before
    public void dinosaur() {
        omnivoreAvian = new Avian("Ornithomimus", DietType.OMNIVORE, 1000, 2000);
        carnivoreAvian = new Avian("Pteranodon", DietType.CARNIVORE, 1000, 2000);
        plantBasedFeed = new Feed(true, 500);
        nonPlantBasedFeed = new Feed(false, 1000);
        plantBasedIEdible = new Feed(true, 500);
        nonPlantBasedIEdible = new Feed(false, 1000);
        visitor = new Visitor("Euan Bell", 3000);
        staff = new Staff("Dennis Nedry", 4000);
    }

    @Test
    public void canGetGenera() {
        assertEquals("Pteranodon", carnivoreAvian.getGenera());
    }

    @Test
    public void canGetCaloricContent() {
        assertEquals(1000, omnivoreAvian.getCaloricContent());
    }

    @Test
    public void canGetDailyRequiredCalories() {
        assertEquals(2000, omnivoreAvian.getRequiredDailyCalories());
    }

    @Test
    public void checkStomachStartsEmpty() {
        assertEquals(0, omnivoreAvian.getStomachCount());
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

    @Test
    public void canAddAnimalAttractionToOmnivoreStomach() {
        omnivoreAvian.eat(carnivoreAvian);
        assertEquals(1, omnivoreAvian.getStomachCount());
    }

    @Test
    public void canAddVisitorToOmnivoreStomach() {
        omnivoreAvian.eat(visitor);
        assertEquals(1, omnivoreAvian.getStomachCount());
    }

    @Test
    public void canAddStaffToOmnivoreStomach() {
        omnivoreAvian.eat(staff);
        assertEquals(1, omnivoreAvian.getStomachCount());
    }

    @Test
    public void canGetAllCaloricContentInOmnivoreStomachSingleIEdible() {
        omnivoreAvian.eat(staff);
        assertEquals(4000, omnivoreAvian.getCaloricContentInStomach());
    }

    @Test
    public void canGetAllCaloricContentInOmnivoreStomachMultipleIEdible() {
        omnivoreAvian.eat(staff);
        omnivoreAvian.eat(plantBasedFeed);
        assertEquals(4500, omnivoreAvian.getCaloricContentInStomach());
    }

    @Test
    public void canGetAllCaloricContentInOmnivoreStomachEmptyStomach() {
        assertEquals(0, omnivoreAvian.getCaloricContentInStomach());
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

    @Test
    public void canAddAnimalAttractionToCarnivoreStomach() {
        carnivoreAvian.eat(omnivoreAvian);
        assertEquals(1, carnivoreAvian.getStomachCount());
    }

    @Test
    public void canAddVisitorToCarnivoreStomach() {
        carnivoreAvian.eat(visitor);
        assertEquals(1, carnivoreAvian.getStomachCount());
    }

    @Test
    public void canAddStaffToCarnivoreStomach() {
        carnivoreAvian.eat(staff);
        assertEquals(1, carnivoreAvian.getStomachCount());
    }

    @Test
    public void canGetAllCaloricContentInCarnivoreStomachSingleIEdible() {
        carnivoreAvian.eat(staff);
        assertEquals(4000, carnivoreAvian.getCaloricContentInStomach());
    }

    @Test
    public void canGetAllCaloricContentInCarnivoreStomachMultipleIEdibleAndPlantBased() {
        carnivoreAvian.eat(staff);
        carnivoreAvian.eat(visitor);
        carnivoreAvian.eat(plantBasedFeed);
        assertEquals(7000, carnivoreAvian.getCaloricContentInStomach());
    }

    @Test
    public void canGetAllCaloricContentInCarnivoreStomachEmptyStomach() {
        assertEquals(0, carnivoreAvian.getCaloricContentInStomach());
    }
}
