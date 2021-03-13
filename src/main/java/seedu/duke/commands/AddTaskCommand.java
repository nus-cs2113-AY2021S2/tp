package seedu.duke.commands;

import seedu.duke.module.Module;
import seedu.duke.module.ModuleList;
import seedu.duke.task.Task;
import seedu.duke.ui.UI;

import static seedu.duke.common.Constants.NO_STRING;
import static seedu.duke.common.Constants.YES_STRING;
import static seedu.duke.common.Messages.MESSAGE_ADDED_TASK;
import static seedu.duke.common.Messages.MESSAGE_TASK_CHECK_GRADED;
import static seedu.duke.common.Messages.MESSAGE_TASK_CHECK_GRADED_INFO;

public class AddTaskCommand extends Command {

    private final Task task;

    public AddTaskCommand(Task task) {
        this.task = task;
    }

    //@@author aliciatay-zls
    /**
     * Adds new task to selected module.
     *
     * @param ui Instance of UI.
     */
    @Override
    public void execute(UI ui) {
        Module module = ModuleList.getSelectedModule();
        boolean isGraded = getIsTaskGraded(ui);
        task.setGraded(isGraded);
        module.addTask(task);
        ui.printMessage(String.format(MESSAGE_ADDED_TASK, task.getDescription()));
        ModuleList.writeModule();
    }

    @Override
    public boolean isExit() {
        return false;
    }

    //@@author aliciatay-zls
    /**
     * Reads user input for whether the task is graded.
     *
     * @param ui Instance of UI.
     * @return Boolean of is new task graded.
     */
    public boolean getIsTaskGraded(UI ui) {
        ui.printMessage(MESSAGE_TASK_CHECK_GRADED);
        String userInput = ui.readCommand();
        while (!userInput.equals(YES_STRING) && !userInput.equals(NO_STRING)) {
            ui.printMessage(MESSAGE_TASK_CHECK_GRADED_INFO);
            userInput = ui.readCommand();
        }
        return userInput.equals(YES_STRING);
    }
}
