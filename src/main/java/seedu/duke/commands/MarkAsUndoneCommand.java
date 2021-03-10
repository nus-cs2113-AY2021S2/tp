package seedu.duke.commands;

import seedu.duke.exceptions.CommandException;
import seedu.duke.module.Module;
import seedu.duke.module.ModuleList;
import seedu.duke.task.Task;
import seedu.duke.ui.UI;

import java.util.ArrayList;

import static seedu.duke.common.Messages.COMMAND_VERB_UNMARK;
import static seedu.duke.common.Messages.MESSAGE_TASKS_TO_UNMARK;

public class MarkAsUndoneCommand extends Command {

    @Override
    public void execute(ModuleList modules, UI ui) throws CommandException {
        Module module = modules.getSelectedModule();
        ArrayList<Task> doneTasks = module.getFilteredTasks(module.getTaskList(), true);
        ui.printGetChosenTasksPrompt(MESSAGE_TASKS_TO_UNMARK, COMMAND_VERB_UNMARK, doneTasks);
        ArrayList<Task> chosenTasks = module.getChosenTasks(doneTasks);
        for (Task task : chosenTasks) {
            String description = task.getDescription();
            String confirmation = "Marked " + description + " as undone.";
            ui.printMessage(confirmation);
            module.unmarkTaskInList(task);
        }
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
