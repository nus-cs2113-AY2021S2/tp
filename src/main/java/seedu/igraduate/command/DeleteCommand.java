package seedu.igraduate.command;

import seedu.igraduate.Storage;
import seedu.igraduate.ModuleList;
import seedu.igraduate.Ui;
import seedu.igraduate.exception.ModuleNotFoundException;
import seedu.igraduate.module.Module;
import seedu.igraduate.module.CoreModule;
import seedu.igraduate.module.MathModule;
import seedu.igraduate.module.ElectiveModule;
import seedu.igraduate.module.GeModule;

import java.util.ArrayList;


/**
 * Handles delete command.
 */
public class DeleteCommand extends Command {
    protected String moduleCode;


    public DeleteCommand(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    /**
     * Todo: Add comments here.
     *
     * @param moduleList Module list consisting of all modules.
     * @param ui User interface for printing result.
     * @param storage Storage for storing module list data.
     */
    @Override
    public void execute(ModuleList moduleList, Ui ui, Storage storage) throws ModuleNotFoundException {
        try {
            ArrayList<Module> modules = moduleList.getModules();
            if (!isModuleValid(modules,moduleCode)) {
                throw new ModuleNotFoundException();
            }
            deleteModule(moduleList, moduleCode, ui);
        } catch (ModuleNotFoundException e) {
            throw new ModuleNotFoundException();
        }

    }

    /**
     * Deletes modules from Module list.
     * @param moduleList module list consisting of all modules.
     * @param moduleCode module code.
     * @param ui User interface for printing result.
     * @throws ModuleNotFoundException if moduleCode is is not in list.
     */
    public void deleteModule(ModuleList moduleList, String moduleCode, Ui ui) throws ModuleNotFoundException {
        String moduleType = null;
        moduleList.delete(moduleList.getByCode(moduleCode));
        int moduleIndex = moduleList.getModuleIndex(moduleCode);
        Module module = moduleList.getByIndex(moduleIndex);
        if (module instanceof CoreModule) {
            moduleType = "Core";
        } else if (module instanceof MathModule) {
            moduleType = "Math";
        } else if (module instanceof GeModule) {
            moduleType = "GE";
        } else if (module instanceof ElectiveModule) {
            moduleType = "Elective";
        }
        ui.printDeletedModuleSuccess(moduleCode,moduleType);
    }

    /**
     * Determines if module is in module list.
     *
     * @param moduleCode Module code of module.
     * @return false if modules does not contain moduleCode and true if modules contains moduleCode.
     */
    public boolean isModuleValid(ArrayList<Module> modules, String moduleCode) {
        if (!modules.contains(moduleCode)) {
            return true;
        }
        return false;
    }

    /**
     * {@inheritDoc}
     *
     * @return false
     */
    @Override
    public boolean isExit() {
        return false;
    }
}
