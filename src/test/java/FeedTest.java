import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FeedTest {

    @Test
    public void canCheckPlantBasedTrue() {
        Feed feed = new Feed(true);
        assertEquals(true, feed.checkPlantBased());
    }

    @Test
    public void canCheckPlantBasedFalse() {
        Feed feed = new Feed(false);
        assertEquals(false, feed.checkPlantBased());
    }
}
