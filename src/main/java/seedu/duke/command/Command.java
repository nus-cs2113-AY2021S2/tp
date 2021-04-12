package seedu.duke.command;

import java.util.HashMap;

import seedu.duke.Data;
import seedu.duke.Ui;
import seedu.duke.exception.BaseException;

/* Adapted from https://github.com/fsgmhoward/ip/blob/master/src/main/java/duke/command/Command.java */
/**
 * Base class of all the commands, providing necessary interfaces and methods
 * for implementation.
 */
public abstract class Command {
    protected Ui ui;
    protected Data data;
    protected HashMap<String, String> arguments;
    protected Boolean isExit = false;

    /**
     * Initialize a command.
     * @param ui Instance of Ui class, for UI input/output
     * @param data Instance of Data class, for manipulating patient list and read/write miscallaneous config
     * @param arguments Arguments decomposed from the full command given by the user
     */
    public Command(Ui ui, Data data, HashMap<String, String> arguments) {
        this.ui = ui;
        this.data = data;
        this.arguments = arguments;
    }

    /**
     * Check whether program should exit after this command is finished.
     * @return True for yes, False for no
     */
    public Boolean isExit() {
        return this.isExit;
    }

    /**
     * Abstract method to be implemented by each individual command.
     * This is where the actual program logic of each command is stored.
     */
    public abstract void execute() throws BaseException;
}
