package seedu.logic.command.patient;

import seedu.logic.command.Command;
import seedu.ui.PatientUI;

/**
 * Represents a command that allows users to view the list of existing patients.
 */
public class PatientListCommand extends Command {

    @Override
    public void execute(seedu.model.patient.PatientList patients, PatientUI ui) {
        patients.listPatients();
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
