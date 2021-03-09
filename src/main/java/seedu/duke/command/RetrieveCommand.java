package seedu.duke.command;

import seedu.duke.Data;
import seedu.duke.Ui;

import java.util.HashMap;

public class RetrieveCommand extends Command {
    /**
     * This is the constructor of the command. Arguments are passed to parent class.
     *
     * @param ui        Instance of Ui class, for UI input/output
     * @param data      Instance of Data class, for manipulating patient list and read/write miscallaneous config
     * @param arguments Arguments decomposed from the full command given by the user
     */
    public RetrieveCommand(Ui ui, Data data, HashMap<String, String> arguments) {
        super(ui, data, arguments);
    }

    @Override
    public void execute() {
        // Replace by ui after ui is implemented
        System.out.println("Dummy Retrieve Command");
    }
}
