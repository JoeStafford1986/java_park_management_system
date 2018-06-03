import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PaddockTest {
    private Paddock paddock;

    @Before
    public void before() {
        paddock = new Paddock();
    }

    @Test
    public void checkPaddockStartsEmpty() {
        assertEquals(0, paddock.getDinosaursCount());
    }

}
