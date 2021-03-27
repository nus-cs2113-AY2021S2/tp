package seedu.duke.command;

import seedu.duke.exception.InvalidBlockException;
import seedu.duke.exception.InvalidDayException;

import seedu.duke.Map;
import seedu.duke.ui.UiManager;
import seedu.duke.History;
import seedu.duke.DailyRoute;
import seedu.duke.BlockAlias;
import seedu.duke.FavouriteLocation;
import seedu.duke.Router;

import java.util.ArrayList;

public class ShowDailyRouteCommand extends Command {
    public ShowDailyRouteCommand(String userInput) {
        super(userInput);
    }

    @Override
    public void execute(Map nusMap, UiManager ui, History history, DailyRoute dailyRoute,
                        BlockAlias blockAlias, FavouriteLocation favouriteLocation) {
        String day;
        try {
            day = ui.getValidDay();
            assert day != null;
            ArrayList<String> blocks = dailyRoute.getDailyRoute(day);
            StringBuilder dayRoute = new StringBuilder();
            for (int i = 0; i < blocks.size() - 1; i++) {
                try {
                    String route = new Router().execute(nusMap, blockAlias, blocks.get(i), blocks.get(i + 1));
                    dayRoute.append(route);
                    if (i < blocks.size() - 2) {
                        dayRoute.append("\n");
                    }

                } catch (InvalidBlockException e) {
                    ui.showToUser(e.getMessage());
                }
            }
            ui.showToUser(dayRoute.toString());
        } catch (InvalidDayException e) {
            ui.showToUser(e.getMessage());
        }
    }
}