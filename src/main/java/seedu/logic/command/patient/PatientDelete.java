package seedu.logic.command.patient;

import seedu.logic.command.Command;
import seedu.model.patient.PatientList;
import seedu.ui.PatientUI;

public class PatientDelete extends Command {

    private String args;

    public PatientDelete(String args) {
        this.args = args;
    }

    public void execute(PatientList patients, PatientUI ui) {
        patients.deletePatient(args);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
