package seedu.logic.command.staff;

import seedu.logic.command.Command;
import seedu.storage.StaffStorage;
import seedu.ui.StaffUI;
import seedu.ui.UI;

public class StaffList extends Command {
    private String[] input;

    public StaffList (String[] array) {
        this.input = array;
    }

    public void execute(seedu.model.staff.StaffList staffList, StaffUI staffUI, StaffStorage staffStorage) {
        UI.printEmptyLine();
        staffList.list(this.input);
        UI.printEmptyLine();
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
