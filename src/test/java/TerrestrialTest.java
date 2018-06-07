import Animals.Terrestrial;
import Enums.DietType;
import Interfaces.IEdible;
import People.Staff;
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
    private Staff staff;

    @Before
    public void dinosaur() {
        omnivoreTerrestrial = new Terrestrial("Gallimimus", DietType.OMNIVORE, 1000, 200);
        herbivoreTerrestrial = new Terrestrial("Stegosaurus", DietType.HERBIVORE, 10000, 200);
        carnivoreTerrestrial = new Terrestrial("Velociraptor", DietType.CARNIVORE, 2000, 200);
        plantBasedFeed = new Feed(true, 100);
        nonPlantBasedFeed = new Feed(false, 100);
        plantBasedIEdible = new Feed(true, 100);
        nonPlantBasedIEdible = new Feed(false, 100);
        visitor = new Visitor("Euan Bell", 100);
        staff = new Staff("Dennis Nedry", 100);
    }

    @Test
    public void canGetGenera() {
        assertEquals("Velociraptor", carnivoreTerrestrial.getGenera());
    }

    @Test
    public void canGetCaloricContent() {
        assertEquals(1000, omnivoreTerrestrial.getCaloricContent());
    }

    @Test
    public void canSetCaloricContent() {
        omnivoreTerrestrial.setCaloricContent(900);
        assertEquals(900, omnivoreTerrestrial.getCaloricContent());
    }

    @Test
    public void canGetDailyRequiredCalories() {
        assertEquals(200, omnivoreTerrestrial.getRequiredDailyCalories());
    }

    @Test
    public void canGetEnraged() {

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

    @Test
    public void canAddStaffToOmnivoreStomach() {
        omnivoreTerrestrial.eat(staff);
        assertEquals(1, omnivoreTerrestrial.getStomachCount());
    }

    //Omnivore Stomach and Calorie Tests

    @Test
    public void canGetAllCaloricContentInOmnivoreStomachSingleIEdible() {
        omnivoreTerrestrial.eat(staff);
        assertEquals(100, omnivoreTerrestrial.getCaloricContentInStomach());
    }

    @Test
    public void canGetAllCaloricContentInOmnivoreStomachMultipleIEdible() {
        omnivoreTerrestrial.eat(staff);
        omnivoreTerrestrial.eat(plantBasedFeed);
        assertEquals(200, omnivoreTerrestrial.getCaloricContentInStomach());
    }

    @Test
    public void canGetAllCaloricContentInOmnivoreStomachEmptyStomach() {
        assertEquals(0, omnivoreTerrestrial.getCaloricContentInStomach());
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

    @Test
    public void cannotAddStaffToHerbivoreStomach() {
        herbivoreTerrestrial.eat(staff);
        assertEquals(0, herbivoreTerrestrial.getStomachCount());
    }

    //Herbivore Stomach and Calorie Tests

    @Test
    public void canGetAllCaloricContentInHerbivoreStomachSingleIEdible() {
        herbivoreTerrestrial.eat(plantBasedFeed);
        assertEquals(100, herbivoreTerrestrial.getCaloricContentInStomach());
    }

    @Test
    public void canGetAllCaloricContentInHerbivoreStomachMultipleIEdibleAndNonPlantBased() {
        herbivoreTerrestrial.eat(staff);
        herbivoreTerrestrial.eat(plantBasedIEdible);
        herbivoreTerrestrial.eat(plantBasedFeed);
        assertEquals(200, herbivoreTerrestrial.getCaloricContentInStomach());
    }

    @Test
    public void canGetAllCaloricContentInHerbivoreStomachEmptyStomach() {
        assertEquals(0, herbivoreTerrestrial.getCaloricContentInStomach());
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

    @Test
    public void canAddStaffToCarnivoreStomach() {
        carnivoreTerrestrial.eat(staff);
        assertEquals(1, carnivoreTerrestrial.getStomachCount());
    }

    //Carnivore Stomach and Calorie Tests

    @Test
    public void canGetAllCaloricContentInCarnivoreStomachSingleIEdible() {
        carnivoreTerrestrial.eat(staff);
        assertEquals(100, carnivoreTerrestrial.getCaloricContentInStomach());
    }

    @Test
    public void canGetAllCaloricContentInCarnivoreStomachMultipleIEdibleAndPlantBased() {
        carnivoreTerrestrial.eat(staff);
        carnivoreTerrestrial.eat(visitor);
        carnivoreTerrestrial.eat(plantBasedFeed);
        assertEquals(200, carnivoreTerrestrial.getCaloricContentInStomach());
    }

    @Test
    public void canGetAllCaloricContentInCarnivoreStomachEmptyStomach() {
        assertEquals(0, carnivoreTerrestrial.getCaloricContentInStomach());
    }

    //Digestion Tests

    @Test
    public void canDigestFood() {
        carnivoreTerrestrial.eat(staff);
        carnivoreTerrestrial.eat(visitor);
        carnivoreTerrestrial.eat(nonPlantBasedIEdible);
        carnivoreTerrestrial.digestFood(1);
        assertEquals(100, staff.getCaloricContent());
        assertEquals(100, carnivoreTerrestrial.getCaloricContentInStomach());
        assertEquals(1, carnivoreTerrestrial.getStomachCount());
    }

    @Test
    public void canDigestFoodMultipleSmallMeals() {
        carnivoreTerrestrial.eat(nonPlantBasedIEdible);
        carnivoreTerrestrial.eat(nonPlantBasedIEdible);
        carnivoreTerrestrial.eat(nonPlantBasedIEdible);
        carnivoreTerrestrial.eat(nonPlantBasedIEdible);
        carnivoreTerrestrial.digestFood(1);
        assertEquals(200, carnivoreTerrestrial.getCaloricContentInStomach());
        assertEquals(2, carnivoreTerrestrial.getStomachCount());
    }

    @Test
    public void canSurviveMultipleDays() {
        carnivoreTerrestrial.eat(nonPlantBasedIEdible);
        carnivoreTerrestrial.eat(nonPlantBasedIEdible);
        carnivoreTerrestrial.eat(nonPlantBasedIEdible);
        carnivoreTerrestrial.eat(nonPlantBasedIEdible);
        carnivoreTerrestrial.eat(nonPlantBasedIEdible);
        carnivoreTerrestrial.digestFood(2);
        assertEquals(100, carnivoreTerrestrial.getCaloricContentInStomach());
        assertEquals(1, carnivoreTerrestrial.getStomachCount());
    }

    @Test
    public void willStarveOverMultipleDays() {
        Feed bigFood = new Feed(false, 400);
        carnivoreTerrestrial.eat(bigFood);
        carnivoreTerrestrial.digestFood(1);
        carnivoreTerrestrial.digestFood(1);
        carnivoreTerrestrial.digestFood(1);
        carnivoreTerrestrial.digestFood(1);
        carnivoreTerrestrial.digestFood(1);
        assertEquals(0, carnivoreTerrestrial.getCaloricContentInStomach());
        assertEquals(0, carnivoreTerrestrial.getStomachCount());
    }

    //Escaping Tests

    @Test
    public void getEscaping() {
        assertEquals("I'm escaping!", carnivoreTerrestrial.attemptEscape());
    }
}
