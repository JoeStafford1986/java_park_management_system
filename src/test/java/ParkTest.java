import Animals.AnimalAttraction;
import Animals.Avian;
import Animals.Terrestrial;
import Enums.DietType;
import People.Staff;
import People.Visitor;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParkTest {
    private Park park;
    private Area area;
    private Visitor visitor;
    private Staff staff;
    private Terrestrial animalAttraction;
    private Area originArea;
    private Area destinationArea;

    @Before
    public void before() {
        park = new Park();
        area = new Area();
        visitor = new Visitor("Jo Malo", 2500);
        staff = new Staff("Robert Muldoon", 2500);
        animalAttraction = new Terrestrial("Velocirapter", DietType.CARNIVORE, 2000);
        originArea = new Area();
        destinationArea = new Area();
    }

    @Test
    public void checkAreasStartsEmpty() {
        assertEquals(0, park.getAreasCount());
    }

    @Test
    public void checkVisitorsStartsEmpty() {
        assertEquals(0, park.getVisitorsCount());
    }

    @Test
    public void checkStaffMembersStartsEmpty() {
        assertEquals(0, park.getStaffMembersCount());
    }

    @Test
    public void checkAnimalAttractionsStartsEmpty() {
        assertEquals(0, park.getAnimalAttractionsCount());
    }

    //Adding Entity Tests

    @Test
    public void canAddAreasToPark() {
        park.addArea(area);
        assertEquals(1, park.getAreasCount());
    }

    @Test
    public void canAddVisitorsToPark() {
        park.addVisitor(visitor);
        assertEquals(1, park.getVisitorsCount());
    }

    @Test
    public void canAddStaffMemberToPark() {
        park.addStaffMember(staff);
        assertEquals(1, park.getStaffMembersCount());
    }

    @Test
    public void canAddAnimalAttractionToPark() {
        park.addAnimalAttraction(animalAttraction);
        assertEquals(1, park.getAnimalAttractionsCount());
    }

    //Removal Tests

    @Test
    public void canRemoveVisitorFromPark() {
        park.addVisitor(visitor);
        park.removeVisitor(visitor);
        assertEquals(0, park.getVisitorsCount());
    }

    @Test
    public void canRemoveStaffMembersFromPark() {
        park.addStaffMember(staff);
        park.removeStaffMember(staff);
        assertEquals(0, park.getStaffMembersCount());
    }

    @Test
    public void canRemoveAnimalAttractionFromPark() {
        park.addAnimalAttraction(animalAttraction);
        park.removeAnimalAttraction(animalAttraction);
        assertEquals(0, park.getAnimalAttractionsCount());
    }

    //Transfer Tests

    @Test
    public void canTransferVisitorBetweenAreas() {
        originArea.addVisitor(visitor);
        park.transferVisitorBetweenAreas(visitor, originArea, destinationArea);
        assertEquals(0, originArea.getVisitorsCount());
        assertEquals(1, destinationArea.getVisitorsCount());
    }

    @Test
    public void canTransferStaffBetweenAreas() {
        originArea.addStaff(staff);
        park.transferStaffBetweenAreas(staff, originArea, destinationArea);
        assertEquals(0, originArea.getStaffMembersCount());
        assertEquals(1, destinationArea.getStaffMembersCount());
    }
}
