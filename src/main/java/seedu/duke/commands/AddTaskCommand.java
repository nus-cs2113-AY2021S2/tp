package seedu.duke.commands;

import seedu.duke.exception.CommandException;
import seedu.duke.module.Module;
import seedu.duke.module.ModuleList;
import seedu.duke.task.Task;
import seedu.duke.ui.UI;

import static seedu.duke.common.Messages.MESSAGE_ADDED_TASK;

public class AddTaskCommand extends Command {
    private final Task task;

    public AddTaskCommand(Task task) { //see if can add requireNonNull
        this.task = task;
    }

    @Override
    public void execute(UI ui) throws CommandException {
        Module module = ModuleList.getSelectedModule();
        boolean isGraded = ui.getIsTaskGraded();
        task.setGraded(isGraded);
        module.addTaskToList(task);
        ui.printMessage(String.format(MESSAGE_ADDED_TASK, task.getDescription()));
        ModuleList.writeModule();
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
