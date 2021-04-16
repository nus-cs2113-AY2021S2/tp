package seedu.easylog.commands.itemscommands;

import seedu.easylog.exceptions.ItemListAlreadyClearedException;
import seedu.easylog.exceptions.WrongItemsClearCommandException;
import seedu.easylog.model.ItemManager;

public class ItemsClearCommand extends ItemsCommand {

    /**
     * Clears all items in the system.
     */
    public void execute(String extraDescription, ItemManager itemManager) throws ItemListAlreadyClearedException,
            WrongItemsClearCommandException {

        if (!extraDescription.isEmpty()) {
            throw new WrongItemsClearCommandException();
        }
        if (itemManager.getSize() == 0) {
            throw new ItemListAlreadyClearedException();
        }
        assert ui != null : "ui should not be null";
        ui.showClearedItemList();

        assert itemManager != null : "itemManager should not be null";
        itemManager.clearItemList();
    }
}
