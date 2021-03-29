package seedu.logic.command.startmenu;

import seedu.logic.command.Command;
import seedu.logic.instance.NurseScheduleInstance;

public class ToNurseScheduleInstance extends Command {

    @Override
    public void execute() {
        NurseScheduleInstance schedules = new NurseScheduleInstance();
        schedules.runCommandLoopUntilExit();
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
