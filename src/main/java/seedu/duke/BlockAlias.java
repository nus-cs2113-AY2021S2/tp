package seedu.duke;

import seedu.duke.exception.InvalidAliasException;
import seedu.duke.exception.InvalidBlockException;

import java.util.HashMap;

public class BlockAlias {
    private final HashMap<String, String> aliasMap;

    public BlockAlias() {
        this.aliasMap = new HashMap<>();
    }

    public HashMap<String, String> getAliasMap() {
        return aliasMap;
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
}
