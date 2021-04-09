package seedu.logic.command.staff;

import seedu.logic.command.Command;
import seedu.model.staff.StaffList;
import seedu.storage.StaffStorage;
import seedu.ui.StaffUI;
import seedu.ui.UI;

import java.io.IOException;

/**
 * StaffAdd Command executes the necessary action for finding a Staff object within a StaffList.
 */
public class StaffFind extends Command {

    private String input;

    /**
     * Constructor for StaffFind command.
     *
     * @param line Inputs to find Staff object.
     */
    public StaffFind (String line) {
        this.input = line;
    }

    /**
     * Find a Staff object in the StaffList based on the input.
     *
     * @param staffList  Instance of StaffList used by the StaffFind command to find Staff objects.
     * @param staffUI Instance of StaffUI used by the StaffFind command for displaying any output.
     * @param staffStorage Not utilised here.
     */
    @Override
    public void execute(StaffList staffList, StaffUI staffUI, StaffStorage staffStorage) throws IOException {
        staffList.find(this.input.split("/")[1]);
        UI.printEmptyLine();
    }

    /**
     * Returns true if return command is given to exit the menu.
     *
     * @return false.
     */
    @Override
    public boolean isExit() {
        return false;
    }
}
