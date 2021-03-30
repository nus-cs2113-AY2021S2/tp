package seedu.logic.command.staff;

import seedu.logic.command.Command;
import seedu.logic.command.StaffAggregation;
import seedu.storage.StaffStorage;
import seedu.ui.StaffUI;
import seedu.ui.UI;

import java.util.Arrays;

public class StaffList extends Command {
    private String input;

    public StaffList (String line) {
        this.input = line;
    }

    public void execute(StaffAggregation staffAggregation, StaffUI staffUI, StaffStorage staffStorage) {
        UI.printEmptyLine();
        if (StaffAggregation.getNumStaff() == 0) {
            StaffUI.emptyListOutput();
            UI.printEmptyLine();
            return;
        }
        StaffUI.staffListHeader();
        UI.showLine();
        String[] string = Arrays.copyOfRange(this.input.split("/"), 1, 2);
        staffAggregation.list(string);
        UI.printEmptyLine();
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
