package seedu.logic.command.patient;

import seedu.logic.command.Command;
import seedu.model.patient.PatientList;
import seedu.ui.PatientUI;

/**
 * Represents a command that allows users to add a new patient to the list of patients.
 */
public class PatientAddCommand extends Command {

    private String[] argArr;

    public PatientAddCommand(String[] args) {
        argArr = args;
    }

    public void execute(PatientList patients, PatientUI ui) {
        patients.addPatient(argArr);
        ui.patientAddedMessage(argArr[1]);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
