package seedu.igraduate.logic.command;

import seedu.igraduate.storage.Storage;
import seedu.igraduate.model.list.ModuleList;
import seedu.igraduate.ui.Ui;

import seedu.igraduate.exception.ModuleNotFoundException;
import seedu.igraduate.exception.PrerequisiteNotFoundException;
import seedu.igraduate.exception.SaveModuleFailException;
import seedu.igraduate.exception.UnableToDeletePrereqModuleException;

import seedu.igraduate.model.module.Module;

import java.util.logging.Logger;
import java.util.logging.Level;

/**
 * Handles delete command.
 */
public class DeleteCommand extends Command {
    /**
     * Module code of the module to be deleted.
     */
    protected String moduleCode;

    private static final Logger LOGGER = Logger.getLogger(DeleteCommand.class.getName());

    //@@author oscarlai1998
    /**
     * Constructs a new DeleteCommand object.
     * 
     * @param moduleCode Module code of module to be deleted.
     */
    public DeleteCommand(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    /**
     * Retrieves module from module list based on module code and deletes the module.
     * Prints module deleted message after deleting the module.
     * 
     * @param moduleList Module list consisting of all modules.
     * @param ui User interface for printing result.
     * @param storage Storage for storing module list data.
     * @throws ModuleNotFoundException If the module specified does not exists.
     * @throws SaveModuleFailException If module data fails to save to file.
     * @throws PrerequisiteNotFoundException If any of the pre-requisite module does not exists.
     * @throws UnableToDeletePrereqModuleException If module is a pre-requisite module for other modules.
     */
    @Override
    public void execute(ModuleList moduleList, Ui ui, Storage storage) throws ModuleNotFoundException,
            SaveModuleFailException, PrerequisiteNotFoundException, UnableToDeletePrereqModuleException {
        LOGGER.log(Level.INFO, "Executing delete command...");
        try {
            Module module = moduleList.getModuleByCode(moduleCode);
            String moduleType = moduleList.getModuleType(module);
            moduleList.delete(module);
            storage.saveModulesToFile(moduleList);
            ui.printDeleteModuleMessage(moduleCode, moduleType);
            LOGGER.log(Level.INFO, String.format("Successfully deleted %s module.", moduleCode));
        } catch (ModuleNotFoundException e) {
            LOGGER.log(Level.WARNING, "Failed to delete non-existence module.", e);
            throw new ModuleNotFoundException();
        } finally {
            LOGGER.log(Level.INFO, "End of delete command execution.");
        }
    }

    //@@author kewenlok
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
