package seedu.duke.command;

import seedu.duke.*;
import seedu.duke.exception.InvalidBlockException;
import seedu.duke.exception.InvalidDayException;
import seedu.duke.routing.Map;
import seedu.duke.routing.Router;

import java.util.ArrayList;
import java.util.LinkedList;

public class ShowDailyRouteCommand extends Command {
    public ShowDailyRouteCommand(String userInput) {
        super(userInput);
    }

    @Override
    public void execute(Map nusMap, UiManager ui, History history,
                        NotesManager notesManager, DailyRoute dailyRoute) {
        String day = null;
        try {
            day = ui.getDay();
            assert day != null;
            ArrayList<String> blocks = dailyRoute.getDailyRoute(day);
            StringBuilder dayRoute = new StringBuilder();
            for (int i = 0; i < blocks.size() - 1; i++) {
                try {
                    LinkedList<Block> route = new Router().execute(nusMap, blocks.get(i), blocks.get(i + 1));
                    String routeAsString = new Router().getRouteAsString(route);
                    dayRoute.append(routeAsString);
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