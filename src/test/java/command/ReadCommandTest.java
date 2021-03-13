package command;

import org.junit.jupiter.api.Test;
import stores.Store;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReadCommandTest {
    @Test
    public void testReadCommand() {
        Store store = new Store("chicken rice stall");
        assertEquals("Best Chicken Rice ever!", store.getReviews());
    }

}
