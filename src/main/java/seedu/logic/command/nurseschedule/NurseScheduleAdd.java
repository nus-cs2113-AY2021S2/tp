package seedu.logic.command.nurseschedule;

import seedu.logic.command.Command;
import seedu.logic.command.NurseScheduleActions;
import seedu.model.NurseSchedule;
import seedu.ui.NurseScheduleUI;

import java.text.ParseException;

public class NurseScheduleAdd extends Command {

    private String[] argArr;

    public NurseScheduleAdd(String [] args) {
        argArr = args;
    }

    @Override
    public void execute(NurseScheduleActions nurseSchedules, NurseScheduleUI ui) {
        nurseSchedules.addSchedule(argArr);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
