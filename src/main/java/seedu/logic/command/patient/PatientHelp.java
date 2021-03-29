package seedu.logic.command.patient;

import seedu.logic.command.Command;
import seedu.logic.command.PatientActions;
import seedu.ui.PatientUI;

public class PatientHelp extends Command {

    @Override
    public void execute(PatientActions patients, PatientUI ui) {
        ui.printPatientHelpList();
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
