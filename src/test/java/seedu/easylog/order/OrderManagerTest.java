package seedu.easylog.order;

import org.junit.jupiter.api.Test;
import seedu.easylog.model.Item;
import seedu.easylog.model.ItemManager;
import seedu.easylog.model.Order;
import seedu.easylog.model.OrderManager;
import java.math.BigDecimal;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderManagerTest {

    @Test
    public void testGetOrderListPrintFormat() {
        ItemManager itemsInOrder = new ItemManager();
        BigDecimal priceOne = new BigDecimal("100.00");
        BigDecimal priceTwo = new BigDecimal("36.00");
        Item itemOne = new Item("PS5",priceOne,5);
        Item itemTwo = new Item("MP3", priceTwo,5);
        itemsInOrder.addItem(itemOne);
        itemsInOrder.addItem(itemTwo);
        ArrayList<Integer> quantityOfItems = new ArrayList<>();
        quantityOfItems.add(1);
        quantityOfItems.add(1);
        Order orderOne = new Order("Yiwen",itemsInOrder.getItemList(),quantityOfItems);
        OrderManager orderManager = new OrderManager();
        orderManager.addOrder(orderOne);

        assertEquals("1.Yiwen\n"
                        + "    1. PS5, S$100.00, 1\n"
                        + "    2. MP3, S$36.00, 1\n"
                        + "    Total Price : S$136.00\n"
                        + "____________________________________________________________\n",
                orderManager.getOrderListPrintFormat(orderManager.getOrderList()));
    }
}
