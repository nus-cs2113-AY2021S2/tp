package seedu.logic.command.staff;

import seedu.logic.command.Command;
import seedu.model.staff.StaffList;
import seedu.storage.StaffStorage;
import seedu.ui.StaffUI;

public class StaffHelp extends Command {

    public StaffHelp() {
    }

    public void execute(StaffList staffList, StaffUI staffUI, StaffStorage staffStorage) {
        StaffUI.printStaffHelpMessage();
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
