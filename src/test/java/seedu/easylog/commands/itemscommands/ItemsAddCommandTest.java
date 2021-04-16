package seedu.easylog.commands.itemscommands;

import org.junit.jupiter.api.Test;
import seedu.easylog.exceptions.EmptyItemNameException;
import seedu.easylog.exceptions.NullItemNameException;
import seedu.easylog.model.ItemManager;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ItemsAddCommandTest {
    ItemsAddCommand itemsAddCommand = new ItemsAddCommand();
    ItemManager itemManager = new ItemManager();

    @Test
    public void add_nullDescription_failure() {
        // Null item description
        assertThrows(NullItemNameException.class, () -> {
            itemsAddCommand.execute(null, itemManager);
        });
    }

    @Test
    public void add_emptyDescription_failure() {
        // Empty item description
        assertThrows(EmptyItemNameException.class, () -> {
            itemsAddCommand.execute("", itemManager);
        });
    }
}
