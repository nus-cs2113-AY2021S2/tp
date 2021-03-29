package seedu.duke.command.aliascommand;

import seedu.duke.command.Command;
import seedu.duke.ui.AliasUi;

import seedu.duke.exception.InvalidBlockException;
import seedu.duke.exception.InvalidAliasException;

public class AddCustomAliasCommand extends Command {

    protected AliasUi ui;

    public AddCustomAliasCommand() {
        this.ui = new AliasUi();
    }

    @Override
    public void execute() {
        try {
            String[] blockAndAlias = ui.getAliasInfo();
            blockAlias.addAlias(blockAndAlias[0], blockAndAlias[1]);
        } catch (InvalidAliasException | InvalidBlockException e) {
            ui.showMessageWithDivider(e.getMessage());
        }
    }
}
