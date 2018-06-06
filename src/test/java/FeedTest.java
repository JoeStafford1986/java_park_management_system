import Interfaces.IEdible;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FeedTest {

    @Test
    public void canCheckPlantBasedTrue() {
        Feed feed = new Feed(true, 500);
        assertEquals(true, feed.checkPlantBased());
    }

    @Test
    public void canCheckPlantBasedFalse() {
        Feed feed = new Feed(false, 1000);
        assertEquals(false, feed.checkPlantBased());
    }

    @Test
    public void canCheckPlantBasedOnIEdibleTypeTrue() {
        IEdible feed = new Feed(true, 500);
        assertEquals(true, feed.checkPlantBased());
    }
}
