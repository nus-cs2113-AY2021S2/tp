package seedu.easylog.commands.itemscommands;

import seedu.easylog.model.ItemManager;

public class ItemsListCommand extends ItemsCommand {

    /**
     * Print out all the items in the items list.
     */
    public void execute(ItemManager itemManager) {

        assert ui != null : "ui should not be null";
        assert itemManager != null : "itemManager should not be null";
        String rawItemListOutput =
                itemManager.getItemListPrintFormat(itemManager.getItemList());
        ui.showItemList(rawItemListOutput);
        boolean isCorrectOutput = false;
        if (rawItemListOutput == "" || rawItemListOutput.startsWith("1. ")) {
            isCorrectOutput = true;
        }

        assert isCorrectOutput == true : "rawItemListOutput is either empty "
                + "or starts with \"1. <item name>\"";
    }
}
