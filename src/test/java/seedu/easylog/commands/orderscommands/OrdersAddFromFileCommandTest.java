package seedu.easylog.commands.orderscommands;

import org.junit.jupiter.api.Test;
import seedu.easylog.model.Item;
import seedu.easylog.model.ItemManager;
import seedu.easylog.model.Order;
import seedu.easylog.model.OrderManager;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrdersAddFromFileCommandTest {

    @Test
    public void executeOrdersAddFromFileTest() {
        ItemManager itemManager = new ItemManager();
        Item testItem = new Item("PS5", new BigDecimal("599.00"), 10);
        itemManager.addItem(testItem);
        ArrayList<Item> testItemsInOrder = new ArrayList<>();
        ArrayList<Integer> testQuantityOfItemsInOrder = new ArrayList<>();
        testItemsInOrder.add(testItem);
        testQuantityOfItemsInOrder.add(10);
        Order testOrder = new Order("weisheng", testItemsInOrder, testQuantityOfItemsInOrder);

        String inputFromFile = "weisheng 1 itemQuantity 10";
        OrderManager orderManager = new OrderManager();
        OrdersAddFromFileCommand ordersAddFromFileCommand = new OrdersAddFromFileCommand();
        ordersAddFromFileCommand.execute(inputFromFile, itemManager, orderManager);
        Order orderAdded = orderManager.getLatestOrderAdded();

        assertEquals(testOrder.getCustomerName(), orderAdded.getCustomerName());
        assertEquals(testOrder.getItemsInOrder(), orderAdded.getItemsInOrder());
        assertEquals(testOrder.getStockCounts(), orderAdded.getStockCounts());
    }
}
