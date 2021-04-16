package seedu.easylog.commands.itemscommands;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import seedu.easylog.exceptions.ItemListAlreadyClearedException;
import seedu.easylog.exceptions.WrongItemsClearCommandException;
import seedu.easylog.model.Item;
import seedu.easylog.model.ItemManager;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ItemsClearCommandTest {
    ItemsClearCommand itemsClearCommand = new ItemsClearCommand();
    ItemManager itemManager = new ItemManager();

    @Test
    @DisplayName("(If no item is in the inventory, clear command should fail")
    public void clear_noItem_failure() throws WrongItemsClearCommandException, ItemListAlreadyClearedException {
        // No item to clear
        assertThrows(ItemListAlreadyClearedException.class, () -> {
            itemsClearCommand.execute("", itemManager);
        });
    }

    @Test
    public void clear_oneItem_success() throws WrongItemsClearCommandException, ItemListAlreadyClearedException {
        // 1 item to clear
        Item firstItem = new Item("CS2113T Textbook", BigDecimal.valueOf(50), 10);
        itemManager.addItem(firstItem);
        itemsClearCommand.execute("", itemManager);
        assertEquals(0, itemManager.getSize());
    }

    @Test
    public void clear_multipleItem_success() throws WrongItemsClearCommandException, ItemListAlreadyClearedException {
        // multiple items to clear
        Item firstItem = new Item("CS2113T Textbook", BigDecimal.valueOf(50), 10);
        Item secondItem = new Item("CS2113T Textbook", BigDecimal.valueOf(50), 10);
        Item thirdItem = new Item("Logitech BRIO Webcam", BigDecimal.valueOf(300), 5);
        Item fourthItem = new Item("Lenovo China-exclusive Legion R9000X", BigDecimal.valueOf(2000),
                2);
        Item fifthItem = new Item("Guy's Perfume", BigDecimal.valueOf(100), 20);
        itemManager.addItem(secondItem);
        itemManager.addItem(thirdItem);
        itemManager.addItem(fourthItem);
        itemManager.addItem(fifthItem);

        itemsClearCommand.execute("", itemManager);
        assertEquals(0, itemManager.getSize());
    }

    @Test
    public void clear_extraDescription_failure() throws WrongItemsClearCommandException,
            ItemListAlreadyClearedException {
        // multiple items to clear
        Item item = new Item("CS2113T Textbook", BigDecimal.valueOf(50), 10);

        itemManager.addItem(item);

        assertThrows(WrongItemsClearCommandException.class, () -> {
            itemsClearCommand.execute("extra", itemManager);
        });
    }
}