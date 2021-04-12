package seedu.duke.command;

import seedu.duke.Data;
import seedu.duke.Ui;

import java.util.HashMap;

public class CurrentCommand extends Command {
    /**
     * This is the constructor of the command. Arguments are passed to parent class.
     *
     * @param ui        Instance of Ui class, for UI input/output
     * @param data      Instance of Data class, for manipulating patient list and read/write miscellaneous config
     * @param arguments Arguments decomposed from the full command given by the user
     */
    public CurrentCommand(Ui ui, Data data, HashMap<String, String> arguments) {
        super(ui, data, arguments);
    }

    @Override
    public void execute() {
        String currentMessage = data.getCurrentPatientDetails();
        ui.printMessage(currentMessage);
    }
}
