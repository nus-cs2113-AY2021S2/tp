//@@author Rizavur

package seedu.duke.ui;

import seedu.duke.data.BlockAlias;
import seedu.duke.exception.EmptyAliasesException;

import java.util.Map;

public class AliasUi extends UiManager {

    public String[] getAliasInfo() {
        String[] blockAndAlias = new String[2];
        showMessage("Enter block: ");
        blockAndAlias[0] = getUserInput().toUpperCase();

        showMessage("Enter the alias name: ");
        blockAndAlias[1] = getUserInput().toUpperCase();

        showMessage(CommonMessage.DIVIDER);
        return blockAndAlias;
    }

    public void showCustomAliases(BlockAlias aliases) throws EmptyAliasesException {
        if (aliases.isEmpty()) {
            throw new EmptyAliasesException();
        } else {
            showMessage("Here are your aliases:");
            int index = 1;
            for (Map.Entry<String, String> pair : aliases.getAliasHashMap().entrySet()) {
                showMessage(index + ". " + pair.getKey() + " - " + pair.getValue());
                index++;
            }
            showMessage(CommonMessage.DIVIDER);
        }
    }

    public String getDeleteAliasInfo() {
        showMessage("Enter the alias name that you wish to delete: ");
        String toDelete = getUserInput().toUpperCase();
        showMessage(CommonMessage.DIVIDER);
        return toDelete;
    }
}
