package seedu.duke.command;

import seedu.duke.BlockAlias;
import seedu.duke.DailyRoute;
import seedu.duke.History;
import seedu.duke.NotesManager;
import seedu.duke.UiManager;
import seedu.duke.exception.InvalidAliasException;
import seedu.duke.exception.InvalidBlockException;
import seedu.duke.routing.Router;

import java.util.HashMap;

public class AddCustomAliasCommand extends Command {
    public AddCustomAliasCommand(String userInput) {
        super(userInput);
    }

    @Override
    public void execute(Router router, UiManager ui, History history,
                        NotesManager notesManager, DailyRoute dailyRoute, BlockAlias blockAlias) {
        try {
            HashMap<String, String> addAlias = ui.getAliasInfo(blockAlias.getAliasMap());
            assert addAlias != null;
            blockAlias.getAliasMap().putAll(addAlias);
        } catch (InvalidAliasException e) {
            ui.showToUser(e.getMessage());
        } catch (InvalidBlockException r) {
            ui.showToUser(r.getMessage());
        }
    }
}
