import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AreaTest {
    private Area area;

    @Before
    public void before() {
        area = new Area();
    }

    @Test
    public void checkPaddocksStartEmpty() {
        assertEquals(0, area.getPaddocksCount());
    }

    @Test
    public void checkVisitorsStartEmpty() {
        assertEquals(0, area.getVisitorsCount());
    }
}
