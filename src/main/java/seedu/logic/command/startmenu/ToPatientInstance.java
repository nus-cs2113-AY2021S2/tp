package seedu.logic.command.startmenu;

import seedu.logic.command.Command;
import seedu.logic.instance.PatientInstance;

import static seedu.duke.Constants.PATIENT_FILE_PATH;

public class ToPatientInstance extends Command {

    public void execute() {
        PatientInstance patients = new PatientInstance(PATIENT_FILE_PATH);
        patients.run();
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
