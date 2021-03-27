package seedu.duke.command;

import seedu.duke.Map;
import seedu.duke.ui.UiManager;
import seedu.duke.History;
import seedu.duke.DailyRoute;
import seedu.duke.BlockAlias;
import seedu.duke.FavouriteLocation;
import seedu.duke.DaySchedulePair;

import seedu.duke.exception.InvalidBlockException;
import seedu.duke.exception.InvalidDayException;

public class AddDailyRouteCommand extends Command {
    public AddDailyRouteCommand(String userInput) {
        super(userInput);
    }

    @Override
    public void execute(Map nusMap, UiManager ui, History history, DailyRoute dailyRoute,
                        BlockAlias blockAlias, FavouriteLocation favouriteLocation) {
        DaySchedulePair dayAndRoute;
        try {
            dayAndRoute = ui.getDailyRouteInfo();
            assert dayAndRoute != null;
            dailyRoute.addDailyRoute(dayAndRoute.getDay(), dayAndRoute.getSchedule());
        } catch (InvalidDayException e) {
            ui.showToUser(e.getMessage());
        } catch (InvalidBlockException r) {
            ui.showToUser(r.getMessage());
        }
    }
}