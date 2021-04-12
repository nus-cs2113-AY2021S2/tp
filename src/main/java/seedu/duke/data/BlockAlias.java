//@@author Rizavur

package seedu.duke.data;

import seedu.duke.exception.InvalidAliasException;
import seedu.duke.exception.NoAliasNameException;

import java.util.HashMap;

public class BlockAlias {
    private final HashMap<String, String> aliases;

    public BlockAlias() {
        this.aliases = new HashMap<>();
    }

    /**
     * Returns the hash map containing all the aliases and block pairs.
     * @return The hash map containing all the aliases and block pairs is returned.
     */
    public HashMap<String, String> getAliasHashMap() {
        return aliases;
    }

    /**
     * Returns the boolean value on whether the alias hashmap is empty.
     * @return A boolean value on whether the alias hashmap is empty is returned.
     */
    public boolean isEmpty() {
        return aliases.isEmpty();
    }

    /**
     * This method adds the new alias that was specified by the user into the alias hashmap.
     * @param block The block name.
     * @param alias The alias name.
     * @throws InvalidAliasException If alias is the same as a block or an alias of the same name already exists.
     */
    public void addAlias(String block, String alias) throws InvalidAliasException {
        if (!isValidAlias(alias)) {
            throw new InvalidAliasException();
        }
        aliases.put(alias, block);
    }

    /**
     * Returns a boolean value on whether the alias is valid or not.
     * @param alias The alias that is to be checked if valid.
     * @return A boolean value of whether the alias is valid.
     */
    public boolean isValidAlias(String alias) {
        NusMap nusMap = new NusMap();
        return (!aliases.containsKey(alias)
                && nusMap.getBlock(alias) == null
                && !alias.equalsIgnoreCase("eatery")
                && !alias.equals(""))
                && !alias.contains("/");
    }

    /**
     * This method checks and converts the alias name back to the block name when being called in the routing function.
     * @param from The from block that was input in the routing command by the user.
     * @param to The to block that was input in the routing command by the user.
     * @return An array of strings where the converted from block is stored in the first index and the converted to
     *          block is stored in the second index.
     */
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

    /**
     * This method deletes the specified alias from the alias hashmap.
     * @param alias The alias that is to be deleted.
     * @throws NoAliasNameException If the alias name cannot be found in the alias hashmap.
     */
    public void deleteAlias(String alias) throws NoAliasNameException {
        if (aliases.containsKey(alias)) {
            aliases.remove(alias);
        } else {
            throw new NoAliasNameException();
        }
    }
}
