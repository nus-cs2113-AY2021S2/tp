package seedu.logic.command.staff;

import seedu.logic.command.Command;
import seedu.storage.StaffStorage;
import seedu.ui.StaffUI;
import seedu.ui.UI;

/**
 * StaffList Command executes the necessary action for displaying relevant Staff objects.
 */
public class StaffListCommand extends Command {
    private String[] input;

    /**
     * Constructor for StaffList command.
     *
     * @param array Array of inputs for StaffList comamnd.
     */
    public StaffListCommand(String[] array) {
        this.input = array;
    }

    /**
     * Lists all relevant Staff object from the StaffList.
     *
     * @param staffList  Instance of StaffList (Model) used by the StaffList (Command) command to display all Staff objects.
     * @param staffUI Instance of StaffUI used by the StaffList command for output.
     * @param staffStorage Not utilised here.
     */
    public void execute(seedu.model.staff.StaffList staffList, StaffUI staffUI, StaffStorage staffStorage) {
        UI.printEmptyLine();
        staffList.list(this.input);
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
