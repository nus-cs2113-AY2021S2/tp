package seedu.duke;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeliveryTest {
    private final ArrayList<Item> items = new ArrayList<>();
    Delivery delivery;

    @BeforeEach
    public void setUp() {
        Route.routes = DataManager.loadRoutes();
        items.add(new Item(1, 5));
        delivery = new Delivery("1001", "NTU Hall 1", "Manika", items);
    }

    @Test
    public void addDelivery_success() {
        assertEquals("1001", delivery.getDeliveryID());
        assertEquals("NTU Hall 1", delivery.getAddress());
        assertEquals(1.00, delivery.getDeliveryFee());
        assertEquals(1, delivery.getDistance());
        assertEquals("Manika", delivery.getRecipient());
    }

    @Test
    public void completeDelivery_success() {
        delivery.setDeliveryAsComplete();
        assertEquals("[Y]", delivery.getDeliveryStatusSymbol());
    }
}
