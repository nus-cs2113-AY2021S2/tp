package seedu.fridgefriend.command;

import java.util.List;

/**
 * Represent an executable command
 */
public abstract class Command {

    public abstract void execute(List<String> foods);

}
