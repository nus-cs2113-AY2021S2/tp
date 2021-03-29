package seedu.logic.command.nurseschedule;

import seedu.logic.command.Command;
import seedu.logic.command.NurseScheduleActions;
import seedu.ui.NurseScheduleUI;

public class NurseScheduleHelp extends Command {

    @Override
    public void execute(NurseScheduleActions nurseSchedules, NurseScheduleUI ui) {
        ui.printNurseScheduleHelpList();
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
