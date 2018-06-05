import Animals.Avian;
import Animals.Terrestrial;
import Enums.DietType;
import People.Staff;
import People.Visitor;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AreaTest {
    private Area area;
    private Paddock enclosedPaddock;
    private Visitor visitor;
    private Staff staff;
    private Paddock originEnclosedPaddock;
    private Paddock destinationEnclosedPaddock;
    private Paddock destinationNonEnclosedPaddock;
    private Terrestrial herbivoreTerrestrial1;
    private Terrestrial herbivoreTerrestrial2;
    private Terrestrial carnivoreTerrestrial1;
    private Terrestrial carnivoreTerrestrial2;
    private Terrestrial carnivoreTerrestrial3;
    private Avian carnivoreAvian1;

    @Before
    public void before() {
        area = new Area();
        enclosedPaddock = new Paddock(true);
        visitor = new Visitor("Duncan Marjoribanks");
        staff = new Staff("John Hammond");
        originEnclosedPaddock = new Paddock(true);
        destinationEnclosedPaddock = new Paddock(true);
        destinationNonEnclosedPaddock = new Paddock(false);
        herbivoreTerrestrial1 = new Terrestrial("Stegosaurus", DietType.HERBIVORE);
        herbivoreTerrestrial2 = new Terrestrial("Brontosaurus", DietType.HERBIVORE);
        carnivoreTerrestrial1 = new Terrestrial("Velociraptor", DietType.CARNIVORE);
        carnivoreTerrestrial2 = new Terrestrial("Giganotosaurus", DietType.CARNIVORE);
        carnivoreTerrestrial3 = new Terrestrial("Velociraptor", DietType.CARNIVORE);
        carnivoreAvian1 = new Avian("Sinosauropteryx", DietType.CARNIVORE);
    }

    @Test
    public void checkPaddocksStartEmpty() {
        assertEquals(0, area.getPaddocksCount());
    }

    @Test
    public void checkVisitorsStartEmpty() {
        assertEquals(0, area.getVisitorsCount());
    }

    @Test
    public void checkStaffMembersStartsEmpty() {
        assertEquals(0, area.getStaffMembersCount());
    }

    @Test
    public void canAddPaddock() {
        area.addPaddock(enclosedPaddock);
        assertEquals(1, area.getPaddocksCount());
    }

    @Test
    public void canAddVisitor() {
        area.addVisitor(visitor);
        assertEquals(1, area.getVisitorsCount());
    }

    @Test
    public void canAddStaffMember() {
        area.addStaff(staff);
        assertEquals(1, area.getStaffMembersCount());
    }

    @Test
    public void canRemovePaddock() {
        area.addPaddock(enclosedPaddock);
        area.removePaddock(enclosedPaddock);
        assertEquals(0, area.getPaddocksCount());
    }

    @Test
    public void canRemoveVisitor() {
        area.addVisitor(visitor);
        area.removeVisitor(visitor);
        assertEquals(0, area.getVisitorsCount());
    }

    @Test
    public void canRemoveStaffMembers() {
        area.addStaff(staff);
        area.removeStaff(staff);
        assertEquals(0, area.getStaffMembersCount());
    }

    //Transfer Tests

    @Test
    public void canTransferHerbivoreTerrestrialAnimalAttractionBetweenPaddocksEmptyPaddocks() {
        originEnclosedPaddock.addAnimalAttraction(herbivoreTerrestrial1);
        area.transferAnimalAttractionBetweenPaddocks(herbivoreTerrestrial1, originEnclosedPaddock, destinationEnclosedPaddock);
        assertEquals(0, originEnclosedPaddock.getAnimalAttractionsCount());
        assertEquals(1, destinationEnclosedPaddock.getAnimalAttractionsCount());
    }

    @Test
    public void canTransferHerbivoreTerrestrialAnimalAttractionBetweenPaddocksNotEmptyPaddocks() {
        originEnclosedPaddock.addAnimalAttraction(herbivoreTerrestrial1);
        originEnclosedPaddock.addAnimalAttraction(herbivoreTerrestrial2);
        destinationEnclosedPaddock.addAnimalAttraction(herbivoreTerrestrial1);
        area.transferAnimalAttractionBetweenPaddocks(herbivoreTerrestrial1, originEnclosedPaddock, destinationEnclosedPaddock);
        assertEquals(1, originEnclosedPaddock.getAnimalAttractionsCount());
        assertEquals(2, destinationEnclosedPaddock.getAnimalAttractionsCount());
    }

    @Test
    public void cannotTransferHerbivoreTerrestrialAnimalAttractionBetweenPaddocksWhenDestinationContainsPredator() {
        originEnclosedPaddock.addAnimalAttraction(herbivoreTerrestrial1);
        destinationEnclosedPaddock.addAnimalAttraction(carnivoreTerrestrial1);
        area.transferAnimalAttractionBetweenPaddocks(herbivoreTerrestrial1, originEnclosedPaddock, destinationEnclosedPaddock);
        assertEquals(1, originEnclosedPaddock.getAnimalAttractionsCount());
        assertEquals(1, destinationEnclosedPaddock.getAnimalAttractionsCount());
    }

    @Test
    public void cannotTransferCarnivoreTerrestrialAnimalAttractionBetweenPaddocksWhenDestinationContainsDifferentPredator() {
        originEnclosedPaddock.addAnimalAttraction(carnivoreTerrestrial1);
        destinationEnclosedPaddock.addAnimalAttraction(carnivoreTerrestrial2);
        area.transferAnimalAttractionBetweenPaddocks(carnivoreTerrestrial1, originEnclosedPaddock, destinationEnclosedPaddock);
        assertEquals(1, originEnclosedPaddock.getAnimalAttractionsCount());
        assertEquals(1, destinationEnclosedPaddock.getAnimalAttractionsCount());
    }

    @Test
    public void canTransferCarnivoreTerrestrialAnimalAttractionBetweenPaddocksWhenDestinationContainsSameTypeOfPredator() {
        originEnclosedPaddock.addAnimalAttraction(carnivoreTerrestrial1);
        destinationEnclosedPaddock.addAnimalAttraction(carnivoreTerrestrial3);
        area.transferAnimalAttractionBetweenPaddocks(carnivoreTerrestrial1, originEnclosedPaddock, destinationEnclosedPaddock);
        assertEquals(0, originEnclosedPaddock.getAnimalAttractionsCount());
        assertEquals(2, destinationEnclosedPaddock.getAnimalAttractionsCount());
    }

    @Test
    public void canTransferAvianCarnivoreFromEnclosedPaddockToEnclosedPaddock() {
        originEnclosedPaddock.addAnimalAttraction(carnivoreAvian1);
        area.transferAnimalAttractionBetweenPaddocks(carnivoreAvian1, originEnclosedPaddock, destinationEnclosedPaddock);
    }

    @Test
    public void cannotTransferAvianCarnivoreFromEnclosedPaddockToNonEnclosedPaddock() {
        originEnclosedPaddock.addAnimalAttraction(carnivoreAvian1);
        area.transferAnimalAttractionBetweenPaddocks(carnivoreAvian1, originEnclosedPaddock, destinationNonEnclosedPaddock);
        assertEquals(0, destinationEnclosedPaddock.getAnimalAttractionsCount());
    }


}
