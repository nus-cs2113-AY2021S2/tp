package seedu.logic.command.nurseschedule;

import seedu.exceptions.DuplicateIDException;
import seedu.exceptions.nurseschedules.DuplicateScheduleException;
import seedu.exceptions.nurseschedules.InvalidiDTypeException;
import seedu.exceptions.nurseschedules.NurseCrossValidationError;
import seedu.exceptions.nurseschedules.NurseIdNotFound;
import seedu.exceptions.nurseschedules.PatientCrossValidationError;
import seedu.exceptions.nurseschedules.PatientIdNotFound;
import seedu.logic.command.Command;
import seedu.model.nurseschedule.NurseScheduleList;
import seedu.ui.NurseScheduleUI;

public class NurseScheduleAddCommand extends Command {

    private String[] argArr;

    public NurseScheduleAddCommand(String [] args) {
        argArr = args;
    }

    @Override
    public void execute(NurseScheduleList nurseSchedules, NurseScheduleUI ui)
            throws NurseIdNotFound, InvalidiDTypeException,
            NurseCrossValidationError, DuplicateIDException,
            PatientIdNotFound, PatientCrossValidationError, DuplicateScheduleException {
        nurseSchedules.addSchedule(argArr);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
