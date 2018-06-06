import Interfaces.IEdible;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FeedTest {
    private Feed feed;

    @Before
    public void before() {
        feed = new Feed(true, 500);
    }

    @Test
    public void canGetCaloricContent() {
        assertEquals(500, feed.getCaloricContent());
    }

    @Test
    public void canSetCaloricContent() {
        feed.setCaloricContent(400);
        assertEquals(400, feed.getCaloricContent());
    }

    @Test
    public void canCheckPlantBasedTrue() {
        assertEquals(true, feed.checkPlantBased());
    }

    @Test
    public void canCheckPlantBasedFalse() {
        feed = new Feed(false, 1000);
        assertEquals(false, feed.checkPlantBased());
    }

    @Test
    public void canCheckPlantBasedOnIEdibleTypeTrue() {
        IEdible feed = new Feed(true, 500);
        assertEquals(true, feed.checkPlantBased());
    }
}
