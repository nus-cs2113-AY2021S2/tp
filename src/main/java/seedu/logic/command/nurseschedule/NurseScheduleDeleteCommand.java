package seedu.logic.command.nurseschedule;

import seedu.exceptions.nurseschedules.InvalidScheduleException;
import seedu.exceptions.nurseschedules.NurseIdNotFound;
import seedu.logic.command.Command;
import seedu.model.nurseschedule.NurseScheduleList;
import seedu.ui.NurseScheduleUI;

public class NurseScheduleDeleteCommand extends Command {

    private String[] argArr;

    public NurseScheduleDeleteCommand(String [] args) {
        argArr = args;
    }

    @Override
    public void execute(NurseScheduleList nurseSchedules, NurseScheduleUI ui) {
        try {
            nurseSchedules.deleteSchedule(argArr);
        } catch (NurseIdNotFound | InvalidScheduleException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
