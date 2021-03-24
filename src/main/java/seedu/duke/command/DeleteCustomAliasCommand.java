package seedu.duke.command;

import seedu.duke.BlockAlias;
import seedu.duke.DailyRoute;
import seedu.duke.History;
import seedu.duke.NotesManager;
import seedu.duke.UiManager;
import seedu.duke.Map;
import seedu.duke.exception.InvalidAliasException;

public class DeleteCustomAliasCommand extends Command {
    public DeleteCustomAliasCommand(String userInput) {
        super(userInput);
    }

    @Override
    public void execute(Map nusMap, UiManager ui, History history,
                        NotesManager notesManager, DailyRoute dailyRoute, BlockAlias blockAlias) {
        try {
            String aliasToDelete = ui.getDeleteAliasInfo(blockAlias);
            blockAlias.getAliasMap().remove(aliasToDelete);
        } catch (InvalidAliasException e) {
            ui.showToUser(e.getMessage());
        }

    }
}
