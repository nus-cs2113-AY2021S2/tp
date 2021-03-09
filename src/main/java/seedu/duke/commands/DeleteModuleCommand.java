package seedu.duke.commands;

import seedu.duke.common.Messages;
import seedu.duke.exceptions.CommandException;
import seedu.duke.module.ModuleList;
import seedu.duke.ui.UI;

import java.util.ArrayList;

import static java.util.Objects.requireNonNull;

public class DeleteModuleCommand extends Command {

    public static final String MESSAGE_PROMPT1 = "Which modules would you like to delete?\n";
    public static final String MESSAGE_PROMPT2 = "Please enter the indices of the modules you would like to delete.\n"
            + "Separate indices with a blank space.";
    public static final String MESSAGE_SUCCESS = "Removed %s from the module list.";

    private String firstStage(ModuleList modules) {
        StringBuilder sb = new StringBuilder(MESSAGE_PROMPT1);
        for (String moduleCode : modules.getModules()) {
            int moduleNumber = modules.getModules().indexOf(moduleCode) + 1;
            sb.append(String.format(Messages.FORMAT_LIST_ITEMS, moduleNumber, moduleCode));
            sb.append("\n");
        }
        sb.append("\n" + MESSAGE_PROMPT2);
        return sb.toString();
    }

    private String secondStage(ArrayList<String> deletedModules) {
        StringBuilder sb = new StringBuilder();
        for (String deletedModule : deletedModules) {
            sb.append(String.format(MESSAGE_SUCCESS, deletedModule));
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public void execute(ModuleList modules, UI ui) throws CommandException {
        requireNonNull(modules);

        String firstStageMessage = firstStage(modules);
        ui.printMessage(firstStageMessage);

        // TODO validate list of integers. Assume input is valid for now.
        ArrayList<Integer> integers = ui.readIntegers();
        ArrayList<String> deletedModules = modules.deleteModules(integers);

        String secondStageMessage = secondStage(deletedModules);
        ui.printMessage(secondStageMessage);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
