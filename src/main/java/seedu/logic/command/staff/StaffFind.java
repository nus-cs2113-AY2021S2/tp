package seedu.logic.command.staff;

import seedu.logic.command.Command;
import seedu.logic.command.StaffAggregation;
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
    public void execute(StaffAggregation staffAggregation, StaffUI staffUI, StaffStorage staffStorage) throws IOException {

        staffAggregation.find(this.input.split("/")[1]);
        UI.printEmptyLine();
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
