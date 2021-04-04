package seedu.logic.command.nurseschedule;

import seedu.exceptions.nurseschedules.InvalidScheduleException;
import seedu.exceptions.nurseschedules.NurseIdNotFound;
import seedu.logic.command.Command;
import seedu.logic.command.NurseScheduleActions;
import seedu.ui.NurseScheduleUI;

public class NurseScheduleDelete extends Command {

    private String[] argArr;

    public NurseScheduleDelete(String [] args) {
        argArr = args;
    }

    @Override
    public void execute(NurseScheduleActions nurseSchedules, NurseScheduleUI ui) {
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
