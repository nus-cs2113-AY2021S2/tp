package seedu.logic.command.staff;

import seedu.logic.command.Command;
import seedu.logic.command.StaffAggregation;
import seedu.storage.StaffStorage;
import seedu.ui.StaffUI;

public class StaffHelp extends Command {

    public StaffHelp() {
    }

    public void execute(StaffAggregation staffAggregation, StaffUI staffUI, StaffStorage staffStorage) {
        StaffUI.printStaffHelpMessage();
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
