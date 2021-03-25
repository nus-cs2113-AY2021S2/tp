package seedu.duke;

import java.util.HashMap;

public class BlockAlias {
    private final HashMap<String, String> aliasMap;

    public BlockAlias() {
        this.aliasMap = new HashMap<>();
    }

    public HashMap<String, String> getAliasMap() {
        return aliasMap;
    }
}
