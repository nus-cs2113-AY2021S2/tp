package seedu.duke.data;

import seedu.duke.exception.InvalidAliasException;
import seedu.duke.exception.InvalidBlockException;

import java.util.HashMap;

public class BlockAlias {
    private final HashMap<String, String> aliases;

    public BlockAlias() {
        this.aliases = new HashMap<>();
    }

    public HashMap<String, String> getAliasHashMap() {
        return aliases;
    }

    public String[] changeAliasToBlock(String from, String to) {
        String[] blockNames = {from, to};
        if (aliases.containsKey(from)) {
            blockNames[0] = aliases.get(from);
        }
        if (aliases.containsKey(to)) {
            blockNames[1] = aliases.get(to);
        }
        return blockNames;
    }

    public void addAlias(String block, String alias) throws InvalidAliasException {
        if (!isValidAlias(alias)) {
            throw new InvalidAliasException();
        }
        aliases.put(alias, block);
    }

    public boolean isValidAlias(String alias) {
        NusMap nusMap = new NusMap();
        return (!aliases.containsKey(alias) && nusMap.getBlock(alias) == null);
    }

    public void deleteAlias(String alias) throws InvalidAliasException {
        if (aliases.containsKey(alias)) {
            aliases.remove(alias);
        } else {
            throw new InvalidAliasException();
        }
    }
}
