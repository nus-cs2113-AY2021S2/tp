package seedu.logic.command.patient;

import seedu.logic.command.Command;
import seedu.logic.command.PatientActions;
import seedu.ui.PatientUI;

public class PatientFind extends Command {

    private String args;

    public PatientFind(String args) {
        this.args = args;
    }

    @Override
    public void execute(PatientActions patients, PatientUI ui) {
        patients.findPatient(args);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
