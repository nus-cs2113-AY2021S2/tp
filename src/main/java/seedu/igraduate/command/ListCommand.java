package seedu.igraduate.command;

import seedu.igraduate.Storage;
import seedu.igraduate.ModuleList;
import seedu.igraduate.Ui;

import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Handles list command.
 */
public class ListCommand extends Command {
    private static final Logger logger = Logger.getLogger(ListCommand.class.getName());

    /**
     * Print list of all modules.
     *
     * @param moduleList Module list consisting of all modules.
     * @param ui User interface for printing result.
     * @param storage Storage for storing module list data.
     */
    @Override
    public void execute(ModuleList moduleList, Ui ui, Storage storage) {
        if (moduleList.isEmpty()) {
            assert moduleList.isEmpty() : "List should be empty";
            logger.log(Level.INFO, "List is empty.");
            ui.printListEmptyMessage();
        } else {
            logger.log(Level.INFO, "List is not empty.");
            ui.printEntireList(moduleList.getModules());
        }
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
