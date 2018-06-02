import Enums.DietType;
import Interfaces.IEadable;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DinosaurTest {
    private Dinosaur dinosaur;

    @Before
    public void dinosaur() {
        dinosaur = new Dinosaur(DietType.OMNIVORE);
    }

    @Test
    public void canGetDiet() {
        assertEquals(DietType.OMNIVORE, dinosaur.getDiet());
    }

    @Test
    public void checkStomachStartsEmpty() {
        assertEquals(0, dinosaur.getStomachCount());
    }

    @Test
    public void canAddFeedToStomach() {
        Feed feed = new Feed(true);
        dinosaur.eat(feed);
        assertEquals(1, dinosaur.getStomachCount());
    }

    @Test
    public void canAddIEadableToStomach() {
        IEadable feed = new Feed(true);
        dinosaur.eat(feed);
        assertEquals(1, dinosaur.getStomachCount());
    }
}
