package seedu.easylog.commands.itemscommands;

import org.junit.jupiter.api.Test;
import seedu.easylog.exceptions.EmptyItemListException;
import seedu.easylog.exceptions.WrongUpdateCommandException;
import seedu.easylog.model.Item;
import seedu.easylog.model.ItemManager;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ItemsUpdateCommandTest {
    ItemsUpdateCommand itemsUpdateCommand = new ItemsUpdateCommand();
    ItemManager itemManager = new ItemManager();

    @Test
    public void update_emptyList_failure() {
        // Calling items update command when the item list is empty
        assertThrows(EmptyItemListException.class, () -> {
            itemsUpdateCommand.execute("", itemManager);
        });
    }

    @Test
    public void update_extraDescription_failure() {
        // Wrong items update command
        Item firstItem = new Item("CS2113T Textbook", BigDecimal.valueOf(50), 10);
        itemManager.addItem(firstItem);
        assertThrows(WrongUpdateCommandException.class, () -> {
            itemsUpdateCommand.execute(" CS2113T Textbook", itemManager);
        });
        assertThrows(WrongUpdateCommandException.class, () -> {
            itemsUpdateCommand.execute(" ", itemManager);
        });
        assertThrows(WrongUpdateCommandException.class, () -> {
            itemsUpdateCommand.execute("items", itemManager);
        });
    }

}
