package seedu.easylog.order;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import seedu.easylog.model.Item;
import seedu.easylog.model.ItemManager;
import seedu.easylog.model.Order;

import java.math.BigDecimal;
import java.util.ArrayList;


public class OrderTest {

    @Test
    public void getAddOrderMessageTest() {
        ArrayList<Item> itemList = new ArrayList<>();
        ArrayList<Integer> itemStockList = new ArrayList<>();
        itemList.add(new Item("milk", new BigDecimal("5.6"), Integer.parseInt("20")));
        itemList.add(new Item("tea", new BigDecimal("3.4"), Integer.parseInt("20")));
        itemStockList.add(Integer.parseInt("1"));
        itemStockList.add(Integer.parseInt("2"));
        String customerName = "Coco";
        assertEquals("Got it! The order for customer [Coco] is added.",
                new Order(customerName, itemList, itemStockList).getAddOrderMessage());
    }

    @Test
    public void getCustomerNameTest() {
        Item itemOne = new Item("milk", new BigDecimal("5.6"), Integer.parseInt("20"));
        Item itemTwo = new Item("tea", new BigDecimal("3.4"), Integer.parseInt("20"));
        ArrayList<Item> itemList = new ArrayList<>();
        itemList.add(itemOne);
        itemList.add(itemTwo);
        ArrayList<Integer> itemStockList = new ArrayList<>();
        itemStockList.add(Integer.parseInt("1"));
        itemStockList.add(Integer.parseInt("2"));
        Order order = new Order("Coco", itemList, itemStockList);
        String customerName = "Coco";
        assertEquals(customerName, order.getCustomerName());
    }

    @Test
    public void getItemsInOrderTest() {
        Item itemOne = new Item("milk", new BigDecimal("5.6"), Integer.parseInt("20"));
        Item itemTwo = new Item("tea", new BigDecimal("3.4"), Integer.parseInt("20"));
        ArrayList<Item> itemList = new ArrayList<>();
        itemList.add(itemOne);
        itemList.add(itemTwo);
        ArrayList<Integer> itemStockList = new ArrayList<>();
        itemStockList.add(Integer.parseInt("1"));
        itemStockList.add(Integer.parseInt("2"));
        Order order = new Order("Coco", itemList, itemStockList);
        assertEquals(itemList, order.getItemsInOrder());
    }

    @Test
    public void getOrderTotalPriceTest() {
        Item itemOne = new Item("milk", new BigDecimal("2.00"), 5);
        Item itemTwo = new Item("tea", new BigDecimal("1.00"), 5);
        ItemManager itemsInOrder = new ItemManager();
        itemsInOrder.addItem(itemOne);
        itemsInOrder.addItem(itemTwo);
        ArrayList<Integer> quantityOfItems = new ArrayList<>();
        quantityOfItems.add(1);
        quantityOfItems.add(1);
        Order order = new Order("Coco", itemsInOrder.getItemList(), quantityOfItems);
        assertEquals(new BigDecimal("3.00"), order.getOrderTotalPrice(itemsInOrder.getItemList()));
    }

    @Test
    public void saveToFileFormatTest() {
        ItemManager itemManager = new ItemManager();
        Item itemOne = new Item("milk", new BigDecimal("5.6"), Integer.parseInt("20"));
        Item itemTwo = new Item("tea", new BigDecimal("3.4"), Integer.parseInt("20"));
        itemManager.addItem(itemOne);
        itemManager.addItem(itemTwo);
        ArrayList<Item> itemList = new ArrayList<>();
        itemList.add(itemOne);
        itemList.add(itemTwo);
        ArrayList<Integer> itemStockList = new ArrayList<>();
        itemStockList.add(Integer.parseInt("1"));
        itemStockList.add(Integer.parseInt("2"));
        Order order = new Order("Coco", itemList, itemStockList);

        String expectedOutput = "Coco 1 2 itemQuantity 1 2 ";
        assertEquals(expectedOutput, order.saveToFileFormat(itemManager));
    }
}
