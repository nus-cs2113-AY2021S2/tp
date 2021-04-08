package seedu.logic.command.nurseschedule;

import seedu.exceptions.nurseschedules.EmptyListException;
import seedu.exceptions.nurseschedules.NurseIdNotFound;
import seedu.logic.command.Command;
import seedu.ui.NurseScheduleUI;

public class NurseScheduleList extends Command {

    private String[] argArr;

    public NurseScheduleList(String [] args) {
        argArr = args;
    }

    @Override
    public void execute(seedu.model.nurseschedule.NurseScheduleList nurseSchedules, NurseScheduleUI ui) {
        try {
            nurseSchedules.listSchedules(argArr);
        } catch (EmptyListException e) {
            System.out.println(e.getMessage());
        } catch (NurseIdNotFound e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
