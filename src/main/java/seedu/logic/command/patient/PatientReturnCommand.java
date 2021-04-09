package seedu.logic.command.patient;

import seedu.logic.command.Command;

public class PatientReturnCommand extends Command {

    @Override
    public boolean isExit() {
        return true;
    }
}
