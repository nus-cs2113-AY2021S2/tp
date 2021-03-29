package seedu.logic.command.staff;

import seedu.logic.command.Command;
import seedu.logic.command.StaffAggregation;
import seedu.storage.StaffStorage;
import seedu.ui.StaffUI;

import java.io.IOException;

public class StaffDelete extends Command {
    private String input;

    public StaffDelete (String line) {
        this.input = line;
    }

    @Override
    public void execute(StaffAggregation staffAggregation, StaffUI staffUI, StaffStorage staffStorage) throws IOException {
        staffAggregation.delete(input);
        staffStorage.writeToFile(staffAggregation);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
