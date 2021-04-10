package seedu.logic.command.patient;

import seedu.logic.command.Command;

/**
 * Represents a command that allows users exit from the patient instance.
 */
public class PatientReturnCommand extends Command {

    @Override
    public boolean isExit() {
        return true;
    }
}
