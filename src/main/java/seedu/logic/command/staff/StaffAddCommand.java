package seedu.logic.command.staff;

import seedu.logic.command.Command;
import seedu.model.staff.StaffList;
import seedu.storage.StaffStorage;
import seedu.ui.StaffUI;

import java.io.IOException;

/**
 * StaffAdd Command executes the necessary action for adding a Staff object.
 */
public class StaffAddCommand extends Command {

    private String[] argArr;

    /**
     * Constructor for StaffAdd command.
     *
     * @param args Array of inputs for Staff object.
     */
    public StaffAddCommand(String[] args) {
        argArr = args;
    }

    /**
     * Adds a Staff object to the StaffList and write the Staff object data to a text file.
     *
     * @param staffList  Instance of StaffList used by the StaffAdd command to store Staff objects.
     * @param staffUI Not utilised here.
     * @param staffStorage Instance of StaffStorage used by the StaffAdd command to write
     *                     Staff objects data into relevant text file.
     */
    @Override
    public void execute(StaffList staffList, StaffUI staffUI, StaffStorage staffStorage) {

        staffList.add(argArr);
        try {
            staffStorage.writeToFile(staffList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns true if return command is given to exit the menu.
     *
     * @return false.
     */
    @Override
    public boolean isExit() {
        return false;
    }
}
