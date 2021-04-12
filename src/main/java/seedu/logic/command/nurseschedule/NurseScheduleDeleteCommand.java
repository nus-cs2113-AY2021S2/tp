package seedu.logic.command.nurseschedule;

import seedu.exceptions.nurseschedules.InvalidScheduleException;
import seedu.exceptions.nurseschedules.NurseIdNotFound;
import seedu.logic.command.Command;
import seedu.model.nurseschedule.NurseScheduleList;
import seedu.ui.NurseScheduleUI;

public class NurseScheduleDeleteCommand extends Command {

    private String[] argArr;

    /**
     * Constructor for NurseScheduleDeleteCommand.
     *
     * @param args Array of user inputs
     */
    public NurseScheduleDeleteCommand(String [] args) {
        argArr = args;
    }

    /**
     * Deletes a NurseSchedule object from the arraylist.
     *
     * @param nurseSchedules arraylist of NurseSchedule objects
     * @param ui Program outputs
     */
    @Override
    public void execute(NurseScheduleList nurseSchedules, NurseScheduleUI ui) {
        try {
            nurseSchedules.deleteSchedule(argArr);
        } catch (NurseIdNotFound | InvalidScheduleException e) {
            System.out.println(e.getMessage());
        }
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
