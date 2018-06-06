import People.Visitor;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VisitorTest {
    private Visitor visitor;

    @Before
    public void before() {
        visitor = new Visitor("Euan Bell", 2500);
    }

    @Test
    public void canGetName() {
        assertEquals("Euan Bell", visitor.getName());
    }

    @Test
    public void canCheckPlantBased() {
        assertEquals(false, visitor.checkPlantBased());
    }
}
