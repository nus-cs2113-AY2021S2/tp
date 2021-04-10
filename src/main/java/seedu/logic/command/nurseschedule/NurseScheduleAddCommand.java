package seedu.logic.command.nurseschedule;

import seedu.exceptions.DuplicateIdException;
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

    /**
     * Constructor for NurseScheduleAddCommand.
     *
     * @param args Array of inputs for NurseSchedule objects
     */
    public NurseScheduleAddCommand(String [] args) {
        argArr = args;
    }

    /**
     * Adds a NurseSchedule object to the arraylist.
     *
     * @param nurseSchedules arraylist of objects
     * @param ui Program outputs
     * @throws NurseIdNotFound if nurseID does not exist
     * @throws InvalidiDTypeException if ID is invalid
     * @throws NurseCrossValidationError if Staff.txt cannot be loaded
     * @throws DuplicateIdException if id has been taken
     * @throws PatientIdNotFound if patientID does not exit
     * @throws PatientCrossValidationError if Patients.txt cannot be loaded
     * @throws DuplicateScheduleException if schedules are duplicated
     */
    @Override
    public void execute(NurseScheduleList nurseSchedules, NurseScheduleUI ui)
            throws NurseIdNotFound, InvalidiDTypeException,
            NurseCrossValidationError, DuplicateIdException,
            PatientIdNotFound, PatientCrossValidationError, DuplicateScheduleException {
        nurseSchedules.addSchedule(argArr);
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
