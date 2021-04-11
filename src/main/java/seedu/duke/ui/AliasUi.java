//@@author Rizavur

package seedu.duke.ui;

import seedu.duke.data.BlockAlias;
import seedu.duke.exception.EmptyAliasesException;
import seedu.duke.exception.InvalidAliasException;

import java.util.Map;

public class AliasUi extends UiManager {

    /**
     * This method obtains user input and returns an array of strings which contains the user input for the alias and
     * block names.
     * @return A string array of size 2 where the first index contains the block name and second index contains the
     * alias name.
     * @throws InvalidAliasException If alias is the same as a block or an alias of the same name already exists.
     */
    public String[] getAliasInfo() throws InvalidAliasException {
        String[] blockAndAlias = new String[2];
        showMessage("Enter block: ");
        blockAndAlias[0] = getUserInput().toUpperCase();

        showMessage("Enter the alias name: ");
        blockAndAlias[1] = getUserInput().toUpperCase();

        showMessage(CommonMessage.DIVIDER);
        return blockAndAlias;
    }

    /**
     * This method prints out the aliases that are currently saved in the alias hashmap.
     * @param aliases The alias hashmap will be retrieved from this instance of blockAlias.
     * @throws EmptyAliasesException If there are not aliases currently stored and the alias hashmap is empty.
     */
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

    /**
     * This method gets the user input for the alias that they want to remove from the stored aliases.
     * @return The alias name that is to be removed.
     */
    public String getDeleteAliasInfo() {
        showMessage("Enter the alias name that you wish to delete: ");
        String toDelete = getUserInput().toUpperCase();
        showMessage(CommonMessage.DIVIDER);
        return toDelete;
    }
}
