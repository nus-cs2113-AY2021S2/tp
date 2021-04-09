package seedu.logic.command.staff;

import seedu.logic.command.Command;
import seedu.model.staff.StaffList;
import seedu.storage.StaffStorage;
import seedu.ui.StaffUI;

/**
 * StaffHelp Command executes the necessary action for displaying the help message.
 */
public class StaffHelpCommand extends Command {

    /**
     * Displays the help message for Staff Menu.
     *
     * @param staffList  Not utilised here.
     * @param staffUI Instance of StaffUI used by the StaffHelp command for displaying help message.
     * @param staffStorage Not utilised here.
     */
    public void execute(StaffList staffList, StaffUI staffUI, StaffStorage staffStorage) {
        StaffUI.printStaffHelpMessage();
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
