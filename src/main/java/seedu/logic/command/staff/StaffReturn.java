package seedu.logic.command.staff;

import seedu.logic.command.Command;
import seedu.model.staff.StaffList;
import seedu.storage.StaffStorage;
import seedu.ui.StaffUI;

import java.io.IOException;

/**
 * StaffReturn Command executes resets given StaffList and exits the Staff Menu.
 */
public class StaffReturn extends Command {

    /**
     * Resets the given StaffList object.
     *
     * @param staffList  Instance of StaffList to be reset.
     * @param staffUI Not utilised here.
     * @param staffStorage Not utilised here.
     */
    public void execute(StaffList staffList, StaffUI staffUI, StaffStorage staffStorage) throws IOException {
       staffList.resetList();
    }

    /**
     * Returns true if return command is given to exit the menu.
     *
     * @return true.
     */
    @Override
    public boolean isExit() {
        return true;
    }
}
