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

    @Before
    public void before() {
        area = new Area();
        enclosedPaddock = new Paddock(true);
        visitor = new Visitor("Duncan Marjoribanks");
        staff = new Staff("John Hammond");
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


}
