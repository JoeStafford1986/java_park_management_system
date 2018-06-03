import Enums.DietType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PaddockTest {
    private Paddock paddock;
    private Dinosaur carnivoreDinosaur;

    @Before
    public void before() {
        paddock = new Paddock();
        carnivoreDinosaur = new Dinosaur(DietType.CARNIVORE);
    }

    @Test
    public void checkPaddockStartsEmpty() {
        assertEquals(0, paddock.getDinosaursCount());
    }

    @Test
    public void canAddCarnivoreDinosaur() {
        paddock.addDinosaur(carnivoreDinosaur);
        assertEquals(1, paddock.getDinosaursCount());
    }

    @Test
    public void canRemoveCarnivoreDinosaur() {
        paddock.addDinosaur(carnivoreDinosaur);
        paddock.removeDinosaur(carnivoreDinosaur);
        assertEquals(0, paddock.getDinosaursCount());
    }

}
