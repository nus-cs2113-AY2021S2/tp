package seedu.duke;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UiTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final ArrayList<Item> items = new ArrayList<>();
    private Ui ui = new Ui();
    Delivery delivery;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStream));
        // set up a delivery list for testing
        ArrayList<Delivery> listOfDeliveries = new ArrayList<>();
        // the actual routes are loaded here since this wouldn't really be changing
        Route.routes = DataManager.loadRoutes();
        // create testing items and delivery
        items.add(new Item(1, 5));
        delivery = new Delivery("1001", "NTU Hall 1", "Manika", items);
        listOfDeliveries.add(delivery);
        DeliveryList.deliveries = listOfDeliveries;
    }

    @Test
    public void printDeliveries_message() {
        ui.showDeliveryDetails(0);
        assertEquals("1001 [N] NTU Hall 1 Manika\r\n1: \r\nItem Number: 1\r\nItem Weight: 5", outputStream.toString()
                .trim());
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }
}
