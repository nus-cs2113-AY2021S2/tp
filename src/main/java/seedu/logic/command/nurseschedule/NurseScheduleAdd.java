package seedu.logic.command.nurseschedule;

import seedu.exceptions.nurseschedules.CrossValidationError;
import seedu.exceptions.nurseschedules.InvalidIDTypeException;
import seedu.exceptions.nurseschedules.NurseIdNotFound;
import seedu.logic.command.Command;
import seedu.logic.command.NurseScheduleActions;
import seedu.ui.NurseScheduleUI;

public class NurseScheduleAdd extends Command {

    private String[] argArr;

    public NurseScheduleAdd(String [] args) {
        argArr = args;
    }

    @Override
    public void execute(NurseScheduleActions nurseSchedules, NurseScheduleUI ui) throws NurseIdNotFound, InvalidIDTypeException, CrossValidationError {
        nurseSchedules.addSchedule(argArr);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
