//@@author Rizavur

package seedu.duke.command.aliascommand;

import seedu.duke.command.Command;
import seedu.duke.ui.AliasUi;

import seedu.duke.exception.InvalidBlockException;
import seedu.duke.exception.InvalidAliasException;

public class AddCustomAliasCommand extends Command {

    protected AliasUi ui;
    private static final String MESSAGE_SUCCESS = "Got it! Successfully added %s as %s's alias";

    public AddCustomAliasCommand() {
        this.ui = new AliasUi();
    }

    @Override
    public void execute() {
        try {
            String[] blockAndAlias = ui.getAliasInfo();
            nusMap.checkIfValidBlock(blockAndAlias[0]);
            blockAlias.addAlias(blockAndAlias[0], blockAndAlias[1]);
            ui.showMessageWithDivider(String.format(MESSAGE_SUCCESS, blockAndAlias[1], blockAndAlias[0]));
        } catch (InvalidAliasException | InvalidBlockException e) {
            ui.showMessageWithDivider(e.getMessage());
        }
    }
}
