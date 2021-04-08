package seedu.logic.command.staff;

import seedu.logic.command.Command;
import seedu.model.staff.StaffList;
import seedu.storage.StaffStorage;
import seedu.ui.StaffUI;

import java.io.IOException;

public class StaffAdd extends Command {

    private String[] argArr;

    public StaffAdd(String[] args) {
        argArr = args;
    }

    @Override
    public void execute(StaffList staffList, StaffUI staffUI, StaffStorage staffStorage) {

        staffList.add(argArr);
        try {
            staffStorage.writeToFile(staffList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public boolean isExit() {
        return false;
    }
}
