package canteen;

import org.junit.jupiter.api.Test;
import canteens.Canteen;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CanteenTest {

    @Test
    public void canteenTest() {
        Canteen canteen = new Canteen("Techno Edge");
        canteen.addStore("western town");
        assertEquals(canteen.getStores(),canteen.getStores());
        assertEquals(canteen.getStore(0),canteen.getStore(0));
        assertEquals(1,canteen.getNumStores());
        assertEquals("Techno Edge", canteen.getCanteenName());
    }
}

