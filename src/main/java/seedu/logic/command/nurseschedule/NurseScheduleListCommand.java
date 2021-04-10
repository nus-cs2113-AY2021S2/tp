package seedu.logic.command.nurseschedule;

import seedu.exceptions.nurseschedules.EmptyListException;
import seedu.exceptions.nurseschedules.NurseIdNotFound;
import seedu.logic.command.Command;
import seedu.model.nurseschedule.NurseScheduleList;
import seedu.ui.NurseScheduleUI;

public class NurseScheduleListCommand extends Command {

    private String[] argArr;

    /**
     * Constructor of NurseScheduleListCommand.
     *
     * @param args Array of user inputs
     */
    public NurseScheduleListCommand(String [] args) {
        argArr = args;
    }

    /**
     * Lists schedules.
     *
     * @param nurseSchedules Arraylist of NurseSchedule objects
     * @param ui Program outputs
     */
    @Override
    public void execute(NurseScheduleList nurseSchedules, NurseScheduleUI ui) {
        try {
            nurseSchedules.listSchedules(argArr);
        } catch (EmptyListException e) {
            System.out.println(e.getMessage());
        } catch (NurseIdNotFound e) {
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
