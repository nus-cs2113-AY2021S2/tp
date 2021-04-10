package seedu.logic.command.nurseschedule;

import seedu.logic.command.Command;
import seedu.model.nurseschedule.NurseScheduleList;
import seedu.ui.NurseScheduleUI;

public class NurseScheduleHelpCommand extends Command {

    /**
     * Prints help message for Nurse Schedule menu.
     *
     * @param nurseSchedules Arraylist of nurse schedule objects
     * @param ui Program outputs
     */
    @Override
    public void execute(NurseScheduleList nurseSchedules, NurseScheduleUI ui) {
        ui.printNurseScheduleHelpList();
    }

    /**
     * Returns true if return command is given.
     *
     * @return false
     */
    @Override
    public boolean isExit() {
        return false;
    }
}
