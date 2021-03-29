package seedu.duke.data;

import seedu.duke.data.NusMap;
import seedu.duke.exception.InvalidAliasException;
import seedu.duke.exception.InvalidBlockException;

import java.util.HashMap;
import java.util.Map;

public class BlockAlias {
    private final HashMap<String, String> aliases;

    public BlockAlias() {
        this.aliases = new HashMap<>();
    }

    public HashMap<String, String> getAliasHashMap() {
        return aliases;
    }

    public void addAlias(String block, String alias) throws InvalidBlockException, InvalidAliasException {
        if (!isValidBlock(block)) {
            throw new InvalidBlockException();
        } else if (!isValidAlias(alias)) {
            throw new InvalidAliasException();
        }
        aliases.put(alias, block);
    }

    public boolean isValidBlock(String block) {
        NusMap nusMap = new NusMap();
        return nusMap.getBlock(block) != null;
    }

    public boolean isValidAlias(String alias) {
        NusMap nusMap = new NusMap();
        return (!aliases.containsKey(alias) | nusMap.getBlock(alias) == null);
    }

    public void deleteAlias(String alias) throws InvalidAliasException {
        if (aliases.containsKey(alias)) {
            aliases.remove(alias);
        } else {
            throw new InvalidAliasException();
        }
    }

    public String getAliasesAsString() {
        StringBuilder aliasesAsString = new StringBuilder();
        int index = 1;
        for (Map.Entry<String, String> pair : aliases.entrySet()) {
            aliasesAsString.append(index + ". " + pair.getKey() + " - " + pair.getValue());
            aliasesAsString.append(System.lineSeparator());
            index++;
        }
        return aliasesAsString.deleteCharAt(aliasesAsString.lastIndexOf(System.lineSeparator())).toString();
    }
}
