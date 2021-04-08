package seedu.logic.command.staff;

import seedu.logic.command.Command;
import seedu.model.staff.StaffList;
import seedu.storage.StaffStorage;
import seedu.ui.StaffUI;
import seedu.ui.UI;

import java.io.IOException;

public class StaffFind extends Command {

    private String input;

    public StaffFind (String line) {
        this.input = line;
    }

    @Override
    public void execute(StaffList staffList, StaffUI staffUI, StaffStorage staffStorage) throws IOException {
        staffList.find(this.input.split("/")[1]);
        UI.printEmptyLine();
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
