package seedu.logic.command.staff;

import seedu.logic.command.Command;
import seedu.model.staff.StaffList;
import seedu.storage.StaffStorage;
import seedu.ui.StaffUI;

import java.io.IOException;

public class StaffDelete extends Command {
    private String input;

    public StaffDelete (String input) {
        this.input = input;
    }

    @Override
    public void execute(StaffList staffList, StaffUI staffUI, StaffStorage staffStorage) throws IOException {
        staffList.delete(input);
        staffStorage.writeToFile(staffList);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
