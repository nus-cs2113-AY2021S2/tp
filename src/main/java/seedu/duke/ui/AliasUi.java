package seedu.duke.ui;

import seedu.duke.BlockAlias;
import seedu.duke.Map;
import seedu.duke.exception.InvalidAliasException;
import seedu.duke.exception.InvalidBlockException;

import java.util.HashMap;

public class AliasUi extends Ui {
    public AliasUi() {
    }

    public HashMap<String, String> getAliasInfo(HashMap<String, String> aliasMap)
            throws InvalidAliasException, InvalidBlockException {
        String block = getAliasBlock(aliasMap).toUpperCase().trim();
        String alias = getAliasName(aliasMap).toUpperCase().trim();

        HashMap<String, String> newAlias = new HashMap<>();
        newAlias.put(alias, block);

        showToUser("Got it! Successfully added " + alias + " for block " + block, divider);
        return newAlias;
    }


    private String getAliasName(HashMap<String, String> aliasMap) throws InvalidAliasException {
        showToUser("Enter the alias name: ");
        String alias = getUserInput().trim();
        checkValidAlias(alias, aliasMap);
        return alias;
    }

    private String getAliasBlock(HashMap<String, String> aliasMap) throws InvalidBlockException {
        showToUser("Enter the block: ");
        String block = getUserInput().toUpperCase().trim();
        checkValidAliasBlock(block);
        return block;
    }

    public void checkValidAlias(String alias, HashMap<String, String> aliasMap) throws InvalidAliasException {
        Map nusMap = new Map();
        if (aliasMap.containsValue(alias)) {
            throw new InvalidAliasException();
        } else if (nusMap.getBlock(alias.toUpperCase()) != null) {
            throw new InvalidAliasException();
        }
    }

    public void checkValidAliasBlock(String block) throws InvalidBlockException {
        Map nusMap = new Map();
        if (nusMap.getBlock(block) == null) {
            throw new InvalidBlockException();
        }
    }

    public void showCustomAliases(HashMap<String, String> aliasMap) {
        if (aliasMap.isEmpty()) {
            showToUser("It seems that you currently do not have any aliases");
        } else {
            showToUser("Your aliases are:");
            int index = 1;
            for (String alias: aliasMap.keySet()) {
                String block = aliasMap.get(alias);
                System.out.println(index + ". " + alias + " - " + block);
            }
        }
        showToUser(divider);
    }

    public String getDeleteAliasInfo(BlockAlias blockAlias) throws InvalidAliasException {
        showToUser("Enter the alias name that you wish to delete: ");
        String toDelete = getUserInput().trim().toUpperCase();
        if (checkValidDeleteAlias(toDelete, blockAlias.getAliasHashMap())) {
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
