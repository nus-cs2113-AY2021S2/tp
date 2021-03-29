package seedu.logic.command.patient;

import seedu.logic.command.Command;
import seedu.logic.command.PatientActions;
import seedu.ui.PatientUI;

public class PatientDelete extends Command {

    private String args;

    public PatientDelete(String args) {
        this.args = args;
    }

    public void execute(PatientActions patients, PatientUI ui) {
        patients.deletePatient(args);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
