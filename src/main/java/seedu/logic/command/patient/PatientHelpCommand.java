package seedu.logic.command.patient;

import seedu.logic.command.Command;
import seedu.model.patient.PatientList;
import seedu.ui.PatientUI;

/**
 * Represents a command that allows users to access the list of commands for reference.
 */
public class PatientHelpCommand extends Command {

    @Override
    public void execute(PatientList patients, PatientUI ui) {
        ui.printPatientHelpList();
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
