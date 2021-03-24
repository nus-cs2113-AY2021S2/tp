package seedu.duke.command;

import seedu.duke.DailyRoute;
import seedu.duke.History;
import seedu.duke.NotesManager;
import seedu.duke.routing.Router;
import seedu.duke.UiManager;
import seedu.duke.FavouriteLocation;
import seedu.duke.exception.InvalidBlockException;
import seedu.duke.exception.InvalidDayException;
import seedu.duke.routing.Router;

import java.util.ArrayList;

public class ShowDailyRouteCommand extends Command {
    public ShowDailyRouteCommand(String userInput) {
        super(userInput);
    }

    @Override
    public void execute(Router router, UiManager ui, History history,
                        NotesManager notesManager, DailyRoute dailyRoute, FavouriteLocation favouriteLocation) {
        String day = null;
        try {
            day = ui.getDay();
            assert day != null;
            ArrayList<String> blocks = dailyRoute.getDailyRoute(day);
            StringBuilder dayRoute = new StringBuilder();
            for (int i = 0; i < blocks.size() - 1; i++) {
                try {
                    String route = router.execute(blocks.get(i), blocks.get(i + 1));
                    dayRoute.append(route);
                    if (i < blocks.size() - 2) {
                        dayRoute.append("\n");
                    }
                    ui.showToUser(dayRoute.toString());
                } catch (InvalidBlockException e) {
                    ui.showToUser(e.getMessage());
                }
            }
        } catch (InvalidDayException e) {
            ui.showToUser(e.getMessage());
        }
    }
}