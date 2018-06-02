import Enums.DietType;
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
}
