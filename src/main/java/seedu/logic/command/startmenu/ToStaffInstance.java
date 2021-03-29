package seedu.logic.command.startmenu;

import seedu.logic.command.Command;
import seedu.logic.instance.StaffInstance;

import static seedu.duke.Constants.STAFF_FILE_PATH;

public class ToStaffInstance extends Command {

    public void execute() {
        StaffInstance staffInstance = new StaffInstance(STAFF_FILE_PATH);
        staffInstance.run();
    }
    @Override
    public boolean isExit() {
        return false;
    }
}
