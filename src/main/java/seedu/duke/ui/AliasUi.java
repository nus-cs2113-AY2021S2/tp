package seedu.duke.ui;

import seedu.duke.data.BlockAlias;
import seedu.duke.exception.EmptyAliasesException;

public class AliasUi extends UiManager {

    public String[] getAliasInfo() {
        String[] blockAndAlias = new String[2];
        showMessage("Enter block: ");
        blockAndAlias[0] = getUserInput().toUpperCase();

        showMessage("Enter the alias name: ");
        blockAndAlias[1] = getUserInput().toUpperCase();
        return blockAndAlias;
    }

    public void showCustomAliases(BlockAlias aliases) throws EmptyAliasesException {
        if (aliases.getAliasHashMap().isEmpty()) {
            throw new EmptyAliasesException();
        } else {
            showMessageWithDivider(
                    "Here are your aliases:",
                    aliases.getAliasesAsString()
            );
        }
    }

    public String getDeleteAliasInfo() {
        showMessage("Enter the alias name that you wish to delete: ");
        String toDelete = getUserInput().toUpperCase();
        showMessage(CommonMessage.DIVIDER);
        return toDelete;
    }
}
