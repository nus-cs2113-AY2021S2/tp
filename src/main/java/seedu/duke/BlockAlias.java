package seedu.duke;

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
}
