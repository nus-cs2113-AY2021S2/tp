package seedu.duke.commands;

import seedu.duke.module.Module;
import seedu.duke.module.ModuleList;
import seedu.duke.ui.UI;

public class ListTasksCommand extends Command {

    @Override
    public void execute(ModuleList modules, UI ui) {
        Module module = modules.getSelectedModule();
        String moduleCode = module.getModuleCode();
        ui.printTasks(moduleCode, module.getTaskList());
    }
}
