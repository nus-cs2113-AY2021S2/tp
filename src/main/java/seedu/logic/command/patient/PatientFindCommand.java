package seedu.logic.command.patient;

import seedu.logic.command.Command;
import seedu.model.patient.PatientList;
import seedu.ui.PatientUI;

/**
 * Represents a command that allows users to find an existing patient from the list of patients.
 */
public class PatientFindCommand extends Command {

    private String args;

    public PatientFindCommand(String args) {
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
