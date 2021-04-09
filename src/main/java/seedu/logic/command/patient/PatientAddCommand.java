package seedu.logic.command.patient;

import seedu.logic.command.Command;
import seedu.model.patient.PatientList;
import seedu.ui.PatientUI;

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
