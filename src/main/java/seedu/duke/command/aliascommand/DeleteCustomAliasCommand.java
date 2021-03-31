//@@author Rizavur
package seedu.duke.command.aliascommand;

import seedu.duke.command.Command;
import seedu.duke.ui.AliasUi;
import seedu.duke.exception.InvalidAliasException;

public class DeleteCustomAliasCommand extends Command {

    protected AliasUi ui;
    private static final String MESSAGE_SUCCESS = "Got it! Successfully deleted %s from alias list!";

    public DeleteCustomAliasCommand() {
        this.ui = new AliasUi();
    }

    @Override
    public void execute() {
        try {
            String aliasToDelete = ui.getDeleteAliasInfo();
            blockAlias.deleteAlias(aliasToDelete);
            ui.showMessageWithDivider(String.format(MESSAGE_SUCCESS, aliasToDelete));
        } catch (InvalidAliasException e) {
            ui.showMessageWithDivider(e.getMessage());
        }
    }
}
