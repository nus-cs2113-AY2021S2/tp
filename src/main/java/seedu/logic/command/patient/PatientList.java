package seedu.logic.command.patient;

import seedu.logic.command.Command;
import seedu.ui.PatientUI;

public class PatientList extends Command {

    @Override
    public void execute(seedu.model.patient.PatientList patients, PatientUI ui) {
        patients.listPatients();
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
