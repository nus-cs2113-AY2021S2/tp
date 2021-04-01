//@@author Rizavur

package seedu.duke.command.aliascommand;

import seedu.duke.command.Command;
import seedu.duke.ui.AliasUi;
import seedu.duke.exception.EmptyAliasesException;

public class ShowCustomAliasCommand extends Command {
    protected AliasUi ui;

    public ShowCustomAliasCommand() {
        this.ui = new AliasUi();
    }

    @Override
    public void execute() {
        try {
            ui.showCustomAliases(blockAlias);
        } catch (EmptyAliasesException e) {
            ui.showMessageWithDivider(e.getMessage());
        }
    }
}
