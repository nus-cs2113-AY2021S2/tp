package seedu.logic.command.staff;

import seedu.logic.command.Command;
import seedu.logic.command.StaffAggregation;
import seedu.storage.StaffStorage;
import seedu.ui.StaffUI;

import java.io.IOException;

public class StaffAdd extends Command {

    private String[] argArr;

    public StaffAdd(String[] args) {
        argArr = args;
    }

    @Override
    public void execute(StaffAggregation staffAggregation, StaffUI staffUI, StaffStorage staffStorage) {

        staffAggregation.add(argArr);
        try {
            staffStorage.writeToFile(staffAggregation);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public boolean isExit() {
        return false;
    }
}
