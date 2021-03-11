package seedu.duke.commands;

import seedu.duke.exception.CommandException;
import seedu.duke.module.Module;
import seedu.duke.module.ModuleList;
import seedu.duke.task.Task;
import seedu.duke.ui.UI;

import java.util.ArrayList;

import static seedu.duke.common.Messages.COMMAND_VERB_UNMARK;
import static seedu.duke.common.Messages.MESSAGE_MARKED_AS_UNDONE;
import static seedu.duke.common.Messages.MESSAGE_TASKS_TO_UNMARK;

public class MarkAsUndoneCommand extends Command {

    @Override
    public void execute(UI ui) throws CommandException {
        Module module = ModuleList.getSelectedModule();
        ArrayList<Task> chosenTasks = module.getTasksToMarkOrUnmark(ui,
                MESSAGE_TASKS_TO_UNMARK, COMMAND_VERB_UNMARK, true);
        for (Task task : chosenTasks) {
            String description = task.getDescription();
            ui.printMessage(String.format(MESSAGE_MARKED_AS_UNDONE,description));
            module.unmarkTaskInList(task);
        }
        ModuleList.writeModule();
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
