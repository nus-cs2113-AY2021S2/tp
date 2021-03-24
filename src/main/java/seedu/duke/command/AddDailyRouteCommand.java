package seedu.duke.command;

import seedu.duke.DailyRoute;
import seedu.duke.History;
import seedu.duke.NotesManager;
import seedu.duke.UiManager;
import seedu.duke.exception.InvalidBlockException;
import seedu.duke.exception.InvalidDayException;
import seedu.duke.routing.Map;
import seedu.duke.routing.Router;

import java.util.AbstractMap;
import java.util.ArrayList;

public class AddDailyRouteCommand extends Command {


    public AddDailyRouteCommand(String userInput) {
        super(userInput);

    }

    @Override
    public void execute(Map nusMap, UiManager ui, History history,
                        NotesManager notesManager, DailyRoute dailyRoute) {
        AbstractMap.SimpleEntry<String, ArrayList<String>> dayAndRoute;
        try {
            dayAndRoute = ui.getDailyRouteInfo();
            assert dayAndRoute != null;
            dailyRoute.addDailyRoute(dayAndRoute.getKey(), dayAndRoute.getValue());
        } catch (InvalidDayException e) {
            ui.showToUser(e.getMessage());
        } catch (InvalidBlockException r) {
            ui.showToUser(r.getMessage());
        }
    }
}