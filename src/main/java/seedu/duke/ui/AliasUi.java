package seedu.duke.ui;

import seedu.duke.BlockAlias;
import seedu.duke.exception.InvalidAliasException;
import seedu.duke.exception.InvalidBlockException;

import java.util.HashMap;

public class AliasUi extends Ui {
    BlockAlias blockAlias;

    public AliasUi() {
    }

    public HashMap<String, String> getAliasInfo(HashMap<String, String> aliasMap)
            throws InvalidAliasException, InvalidBlockException {
        String block = getAliasBlock("Enter the block: ");
        String alias = getAliasName(aliasMap).toUpperCase();

        HashMap<String, String> newAlias = new HashMap<>();
        newAlias.put(alias, block);

        showToUser("Got it! Successfully added " + alias + " for block " + block);
        showToUser(divider);
        return newAlias;
    }


    private String getAliasName(HashMap<String, String> aliasMap) throws InvalidAliasException {
        showToUser("Enter the alias name: ");
        String alias = getUserInput().trim();
        blockAlias.checkValidAlias(alias, aliasMap);
        return alias;
    }

    private String getAliasBlock(String s) throws InvalidBlockException {
        showToUser(s);
        String block = getUserInput().toUpperCase().trim();
        blockAlias.checkValidAliasBlock(block);
        return block;
    }

    public void showCustomAliases(HashMap<String, String> aliasMap) {
        if (aliasMap.isEmpty()) {
            showToUser("It seems that you currently do not have any aliases");
        } else {
            showToUser("Your aliases are:");
            for (String alias: aliasMap.keySet()) {
                String block = aliasMap.get(alias);
                System.out.println(block + " - " + alias);
            }
        }
        showToUser(divider);
    }

    public String getDeleteAliasInfo(BlockAlias blockAlias) throws InvalidAliasException {
        showToUser("Enter the alias name that you wish to delete: ");
        String toDelete = getUserInput().trim().toUpperCase();
        if (checkValidDeleteAlias(toDelete, blockAlias.getAliasMap())) {
            showToUser("Got it! Successfully deleted " + toDelete + " from the aliases");
        }
        showToUser(divider);
        return toDelete;
    }

    private boolean checkValidDeleteAlias(String aliasToDelete, HashMap<String, String> aliasMap)
            throws InvalidAliasException {
        if (!aliasMap.containsKey(aliasToDelete)) {
            throw new InvalidAliasException();
        }
        return true;
    }
}
