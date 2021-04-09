package seedu.logic.command.nurseschedule;

import seedu.logic.command.Command;
import seedu.model.nurseschedule.NurseScheduleList;
import seedu.ui.NurseScheduleUI;

public class NurseScheduleHelpCommand extends Command {

    @Override
    public void execute(NurseScheduleList nurseSchedules, NurseScheduleUI ui) {
        ui.printNurseScheduleHelpList();
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
