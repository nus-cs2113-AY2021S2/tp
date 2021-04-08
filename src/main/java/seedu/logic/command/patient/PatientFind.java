package seedu.logic.command.patient;

import seedu.logic.command.Command;
import seedu.model.patient.PatientList;
import seedu.ui.PatientUI;

public class PatientFind extends Command {

    private String args;

    public PatientFind(String args) {
        this.args = args;
    }

    @Override
    public void execute(PatientList patients, PatientUI ui) {
        patients.findPatient(args);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
