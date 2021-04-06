package seedu.logic.command.staff;

import seedu.logic.command.Command;
import seedu.logic.command.StaffAggregation;
import seedu.storage.StaffStorage;
import seedu.ui.StaffUI;
import seedu.ui.UI;

public class StaffList extends Command {
    private String[] input;

    public StaffList (String[] array) {
        this.input = array;
    }

    public void execute(StaffAggregation staffAggregation, StaffUI staffUI, StaffStorage staffStorage) {
        UI.printEmptyLine();
        if (StaffAggregation.getNumStaff() == 0) {
            StaffUI.emptyListOutput();
            UI.printEmptyLine();
            return;
        }
        staffAggregation.list(this.input[0]);
        UI.printEmptyLine();
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
