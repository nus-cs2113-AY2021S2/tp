package seedu.logic.command.staff;

import seedu.logic.command.Command;
import seedu.model.staff.StaffList;
import seedu.storage.StaffStorage;
import seedu.ui.StaffUI;

import java.io.IOException;

public class StaffReturn extends Command {

    public void execute(StaffList staffList, StaffUI staffUI, StaffStorage staffStorage) throws IOException {
       staffList.resetList();
    }


    @Override
    public boolean isExit() {
        return true;
    }
}
