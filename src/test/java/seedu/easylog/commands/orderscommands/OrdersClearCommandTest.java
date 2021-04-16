package seedu.easylog.commands.orderscommands;

import org.junit.jupiter.api.Test;
import seedu.easylog.exceptions.OrderListAlreadyClearedException;
import seedu.easylog.exceptions.WrongItemsClearCommandException;
import seedu.easylog.exceptions.WrongOrdersClearCommandException;
import seedu.easylog.model.Item;
import seedu.easylog.model.ItemManager;
import seedu.easylog.model.Order;
import seedu.easylog.model.OrderManager;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class OrdersClearCommandTest {
    OrdersClearCommand ordersClearCommand = new OrdersClearCommand();
    OrderManager orderManager = new OrderManager();
    ItemManager itemManager = new ItemManager();

    @Test
    public void clear_noOrder_failure() {
        // No item to clear
        assertThrows(OrderListAlreadyClearedException.class, () -> {
            ordersClearCommand.execute("", itemManager, orderManager);
        });
    }


    @Test
    public void clear_extraDescription_failure() {
        // 1 order
        String itemName = "iPhone X charger";
        BigDecimal itemPrice = new BigDecimal(1499.50);
        int itemStock = 10;
        Item firstItem = new Item(itemName, itemPrice, itemStock);
        itemManager.addItem(firstItem);
        int itemIndex = 0;
        ArrayList<Item> items = new ArrayList<>();
        ArrayList<Integer> stocks = new ArrayList<>();
        stocks.add(itemStock);
        items.add(itemManager.getItem(itemIndex));

        String customerName = "Kexuan";
        Order firstOrder = new Order(customerName, items, stocks);
        orderManager.addOrder(firstOrder);
        assertEquals(1, orderManager.getSize());
        assertThrows(WrongOrdersClearCommandException.class, () -> {
            ordersClearCommand.execute("WrongOrdersClearCommandException", itemManager, orderManager);
        });

    }


    @Test
    public void clear_oneOrder_success() throws OrderListAlreadyClearedException, WrongOrdersClearCommandException {
        // 1 order
        String itemName = "iPhone X charger";
        BigDecimal itemPrice = new BigDecimal(1499.50);
        int itemStock = 10;
        Item firstItem = new Item(itemName, itemPrice, itemStock);
        itemManager.addItem(firstItem);
        int itemIndex = 0;
        ArrayList<Item> items = new ArrayList<>();
        ArrayList<Integer> stocks = new ArrayList<>();
        stocks.add(itemStock);
        items.add(itemManager.getItem(itemIndex));

        String customerName = "Kexuan";
        Order firstOrder = new Order(customerName, items, stocks);
        orderManager.addOrder(firstOrder);
        assertEquals(1, orderManager.getSize());
        ordersClearCommand.execute("", itemManager, orderManager);
        assertEquals(0, orderManager.getSize());
    }

    @Test
    public void clear_multipleOrder_success() throws OrderListAlreadyClearedException,
            WrongOrdersClearCommandException {
        // multiple orders
        String itemName = "iPhone X charger";
        BigDecimal itemPrice = new BigDecimal(1499.50);
        int itemStock = 100;
        Item firstItem = new Item(itemName, itemPrice, itemStock);
        int itemIndex = 0;

        itemManager.addItem(firstItem);
        ArrayList<Item> items = new ArrayList<>();
        ArrayList<Integer> stocks = new ArrayList<>();
        stocks.add(itemStock / 2);
        items.add(itemManager.getItem(itemIndex));

        String customer1 = "Yiwen";
        String customer2 = "Qixiong";
        Order firstOrder = new Order(customer1, items, stocks);
        Order secondOrder = new Order(customer2, items, stocks);
        orderManager.addOrder(firstOrder);
        assertEquals(1, orderManager.getSize());
        orderManager.addOrder(secondOrder);
        assertEquals(2, orderManager.getSize());
        ordersClearCommand.execute("", itemManager, orderManager);
        assertEquals(0, orderManager.getSize());
    }

}