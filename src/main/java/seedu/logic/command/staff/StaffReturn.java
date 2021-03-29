package seedu.logic.command.staff;

import seedu.logic.command.Command;

public class StaffReturn extends Command {

    @Override
    public boolean isExit() {
        return true;
    }
}
