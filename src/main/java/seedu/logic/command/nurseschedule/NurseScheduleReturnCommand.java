package seedu.logic.command.nurseschedule;

import seedu.logic.command.Command;

public class NurseScheduleReturnCommand extends Command {

    /**
     * Returns true if return command is given.
     *
     * @return true
     */
    @Override
    public boolean isExit() {
        return true;
    }
}
