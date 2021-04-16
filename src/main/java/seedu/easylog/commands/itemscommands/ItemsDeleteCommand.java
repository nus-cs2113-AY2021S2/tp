package seedu.easylog.commands.itemscommands;

import seedu.easylog.common.Constants;
import seedu.easylog.exceptions.EmptyNumberException;
import seedu.easylog.exceptions.InvalidNumberException;
import seedu.easylog.model.ItemManager;

public class ItemsDeleteCommand extends ItemsCommand {

    /**
     * Deletes a single item from the list of items.
     */
    public void execute(String itemsArg, ItemManager itemManager) throws EmptyNumberException, InvalidNumberException {
        if (itemsArg.equals("")) {
            throw new EmptyNumberException();
        }
        int index = Integer.parseInt(itemsArg) - Constants.ARRAY_OFFSET;
        int size = itemManager.getSize();
        if ((index < 0) || (index >= size)) {
            throw new InvalidNumberException();
        }
        ui.showDeletedItem(itemManager.getItem(index));
        itemManager.deleteItem(index);
    }
}