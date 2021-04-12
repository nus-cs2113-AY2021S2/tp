package seedu.logic.command.staff;

import seedu.logic.command.Command;
import seedu.model.staff.StaffList;
import seedu.storage.StaffStorage;
import seedu.ui.StaffUI;

import java.io.IOException;

/**
 * StaffDelete Command executes the necessary action for deleting a Staff object.
 */

public class StaffDeleteCommand extends Command {
    private String input;

    /**
     * Constructor for StaffDelete command.
     *
     * @param input String input for identifying Staff object to be deleted.
     */
    public StaffDeleteCommand(String input) {
        this.input = input;
    }

    /**
     * Deletes a Staff object from the StaffList and write the updated Staff object data to text file.
     *
     * @param staffList  Instance of StaffList used by the StaffDelete command to delete Staff objects.
     * @param staffUI Not utilised here.
     * @param staffStorage Instance of StaffStorage used by the StaffDelete command to update
     *                     Staff objects data into relevant text file.
     */
    @Override
    public void execute(StaffList staffList, StaffUI staffUI, StaffStorage staffStorage) throws IOException {
        staffList.delete(input);
        staffStorage.writeToFile(staffList);
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
