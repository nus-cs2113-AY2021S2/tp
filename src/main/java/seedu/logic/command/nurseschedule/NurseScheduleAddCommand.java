package seedu.logic.command.nurseschedule;

import seedu.exceptions.DuplicateIDException;
import seedu.exceptions.nurseschedules.*;
import seedu.logic.command.Command;
import seedu.model.nurseschedule.NurseScheduleList;
import seedu.ui.NurseScheduleUI;

public class NurseScheduleAddCommand extends Command {

    private String[] argArr;

    public NurseScheduleAddCommand(String [] args) {
        argArr = args;
    }

    @Override
    public void execute(NurseScheduleList nurseSchedules, NurseScheduleUI ui) throws NurseIdNotFound, InvalidIDTypeException,
            NurseCrossValidationError, DuplicateIDException, PatientIdNotFound, PatientCrossValidationError, DuplicateScheduleException {
        nurseSchedules.addSchedule(argArr);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
