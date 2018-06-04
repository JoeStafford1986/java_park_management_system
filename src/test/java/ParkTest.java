import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParkTest {
    private Park park;

    @Before
    public void before() {
        park = new Park();
    }

    @Test
    public void checkPaddocksStartEmpty() {
        assertEquals(0, park.getPaddocksCount());
    }

    @Test
    public void canAddPaddock() {
        Paddock paddock = new Paddock(true);
        park.addPaddock(paddock);
    }
}
