package seedu.easylog.commands.orderscommands;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import seedu.easylog.exceptions.EmptyOrderIndexException;
import seedu.easylog.exceptions.EmptyOrderListException;
import seedu.easylog.exceptions.InvalidOrderIndexException;
import seedu.easylog.model.Item;
import seedu.easylog.model.ItemManager;
import seedu.easylog.model.Order;
import seedu.easylog.model.OrderManager;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

class OrdersDeleteCommandTest {
    @Test
    @DisplayName("A Specific Order Should Be Deleted Correctly")
    public void ordersDeleteCommand_shouldBeDeletedCorrectly() throws EmptyOrderListException, EmptyOrderIndexException,
            InvalidOrderIndexException {
        OrdersDeleteCommand ordersDeleteCommand = new OrdersDeleteCommand();
        ItemManager itemManager = new ItemManager();
        OrderManager orderManager = new OrderManager();

        // No order to delete
        String ordersArgNoOrder = "1";
        EmptyOrderListException emptyOrderListException =
                assertThrows(EmptyOrderListException.class, () -> {
                    ordersDeleteCommand.execute(ordersArgNoOrder, itemManager, orderManager);
                });

        // ??
        ArrayList<Item> itemList = new ArrayList<>();
        ArrayList<Integer> itemStockList = new ArrayList<>();

        Item firstItem = new Item("milk", new BigDecimal("5.6"), Integer.parseInt("20"));
        Item secondItem = new Item("tea", new BigDecimal("3.4"), Integer.parseInt("20"));
        itemList.add(firstItem);
        itemList.add(secondItem);
        itemStockList.add(10);
        itemStockList.add(5);

        String firstCustomerName = "Coco";
        Order firstOrder = new Order(firstCustomerName, itemList, itemStockList);
        orderManager.addOrder(firstOrder);

        // No input order index
        String ordersArgEmptyIndex = "";
        EmptyOrderIndexException emptyOrderIndexException =
                assertThrows(EmptyOrderIndexException.class, () -> {
                    ordersDeleteCommand.execute(ordersArgEmptyIndex, itemManager, orderManager);
                });

        // Out of range order index
        String ordersArgInvalidIndex = "10";
        InvalidOrderIndexException invalidOrderIndexException =
                assertThrows(InvalidOrderIndexException.class, () -> {
                    ordersDeleteCommand.execute(ordersArgInvalidIndex, itemManager, orderManager);
                });

        // 1 order to delete
        String ordersArgToDelete = "1";
        ordersDeleteCommand.execute(ordersArgToDelete, itemManager, orderManager);
        assertSame(0, orderManager.getSize());


    }

}