package seedu.duke.command.aliascommand;

import seedu.duke.command.Command;
import seedu.duke.ui.AliasUi;
import seedu.duke.exception.InvalidAliasException;

public class DeleteCustomAliasCommand extends Command {

    protected AliasUi ui;
    public DeleteCustomAliasCommand() {
        this.ui = new AliasUi();
    }

    @Override
    public void execute() {
        try {
            String aliasToDelete = ui.getDeleteAliasInfo();
            blockAlias.deleteAlias(aliasToDelete);
        } catch (InvalidAliasException e) {
            ui.showMessageWithDivider(e.getMessage());
        }
    }
}
