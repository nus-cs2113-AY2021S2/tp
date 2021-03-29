package seedu.logic.command.patient;

import seedu.logic.command.Command;
import seedu.logic.command.PatientActions;
import seedu.ui.PatientUI;

public class PatientAdd extends Command {

    private String[] argArr;

    public PatientAdd(String[] args) {
        argArr = args;
    }

    public void execute(PatientActions patients, PatientUI ui) {
        patients.addPatient(argArr);
        ui.patientAddedMessage(argArr[2]);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
