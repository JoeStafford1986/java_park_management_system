import People.Staff;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StaffTest {
    private Staff staff;

    @Before
    public void before() {
        staff = new Staff("Dennis Nedry");
    }

    @Test
    public void canGetName() {
        assertEquals("Dennis Nedry", staff.getName());
    }

    @Test
    public void canCheckPlantBased() {
        assertEquals(false, staff.checkPlantBased());
    }

}
