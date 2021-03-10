package seedu.duke.commands;

import seedu.duke.exceptions.CommandException;
import seedu.duke.module.Module;
import seedu.duke.module.ModuleList;
import seedu.duke.task.Task;
import seedu.duke.ui.UI;

public class AddTaskCommand extends Command {
    private final Task task;

    public AddTaskCommand(Task task) { //see if can add requireNonNull
        this.task = task;
    }

    @Override
    public void execute(ModuleList modules, UI ui) throws CommandException {
        Module module = modules.getSelectedModule();
        boolean isGraded = ui.getIsTaskGraded();
        task.setGraded(isGraded);
        module.addTaskToList(task); //future: check if there is space in task list to add
        String confirmation = "Added " + task.getDescription() + ".";
        ui.printMessage(confirmation);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
