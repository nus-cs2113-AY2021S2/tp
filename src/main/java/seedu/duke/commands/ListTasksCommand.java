package seedu.duke.commands;

import seedu.duke.exceptions.CommandException;
import seedu.duke.module.Module;
import seedu.duke.module.ModuleList;
import seedu.duke.ui.UI;

public class ListTasksCommand extends Command {

    @Override
    public void execute(ModuleList modules, UI ui) throws CommandException {
        Module module = modules.getSelectedModule();
        String moduleCode = module.getModuleCode();
        ui.printTasks(moduleCode, module.getTaskList());
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
