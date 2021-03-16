package seedu.duke.command;

import java.util.HashMap;

import seedu.duke.Data;
import seedu.duke.Ui;

/**
 * This is a command for testing purposes.
 */
public class EchoCommand extends Command {
    /**
     * This is the constructor of the command. Arguments are passed to parent class.
     * @param ui Instance of Ui class, for UI input/output
     * @param data Instance of Data class, for manipulating patient list and read/write miscallaneous config
     * @param arguments Arguments decomposed from the full command given by the user
     */
    public EchoCommand(Ui ui, Data data, HashMap<String, String> arguments) {
        super(ui, data, arguments);
    }

    @Override
    public void execute() {
        ui.printMessage(arguments.get("payload"));
    }

    /**
     * This is the getter for arguments hashmap.
     * @return Arguments hashmap
     */
    public HashMap<String, String> getArguments() {
        return arguments;
    }

    /**
     * This is the getter for data object
     * @return data object
     */
    public Data getData() {
        return data;
    }
}
