package seedu.logic.command.startmenu;

import seedu.logic.command.Command;
import seedu.logic.instance.PatientCommandInstance;

import static seedu.duke.Constants.PATIENT_FILE_PATH;

public class ToPatientInstance extends Command {

    public void execute() {
        PatientCommandInstance patients = new PatientCommandInstance(PATIENT_FILE_PATH);
        patients.run();
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
