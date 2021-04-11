//@@author Rizavur

package seedu.duke.command.aliascommand;

import seedu.duke.command.Command;
import seedu.duke.exception.NoAliasNameException;
import seedu.duke.ui.AliasUi;

public class DeleteCustomAliasCommand extends Command {

    protected AliasUi ui;
    private static final String MESSAGE_SUCCESS = "Got it! Successfully deleted %s from alias list!";

    public DeleteCustomAliasCommand() {
        this.ui = new AliasUi();
    }

    /**
     * This function executes the delete alias command. It gets the user's input for the alias to be deleted by calling
     * the ui class and after which calls the deleteAlias function in the BlockAlias class to delete it.
     */
    @Override
    public void execute() {
        try {
            String aliasToDelete = ui.getDeleteAliasInfo();
            blockAlias.deleteAlias(aliasToDelete);
            ui.showMessageWithDivider(String.format(MESSAGE_SUCCESS, aliasToDelete));
        } catch (NoAliasNameException e) {
            ui.showMessageWithDivider(e.getMessage());
        }
    }
}
