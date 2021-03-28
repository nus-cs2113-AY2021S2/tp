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
        ArrayList<String> selectableDays = dailyRoute.getSelectableDays();
        if (selectableDays.size() == 0) {
            ui.showToUser("There are no schedules set!");
            return;
        }
        ui.showToUser("Here are the available days: ");
        StringBuilder dayIndexing = new StringBuilder();
        for (int i = 0; i < selectableDays.size(); i++) {
            dayIndexing.append(i + 1).append(". ").append(selectableDays.get(i));
            if (i < selectableDays.size() - 1) {
                dayIndexing.append("\n");
            }
        }
        ui.showToUser(dayIndexing.toString());
        ui.showToUser("Please enter the number of the day:");
        try {
            int index = getIndex(ui, selectableDays, dailyRoute);
            String routedSchedule = getRoutedSchedule(index, dailyRoute, nusMap, blockAlias);
            ui.showToUser(routedSchedule, ui.divider);
        } catch (InvalidBlockException e) {
            ui.showToUser(e.getMessage(), ui.divider);
        } catch (InvalidDayException r) {
            ui.showToUser(r.getMessage(), ui.divider);
        }
    }

    public String getRoutedSchedule(int index, DailyRoute dailyRoute, Map nusMap,
                                    BlockAlias blockAlias) throws InvalidDayException, InvalidBlockException {
        try {
            ArrayList<String> blocks = dailyRoute.getDailyRoute(index);
            StringBuilder dayRoute = new StringBuilder();
            for (int i = 0; i < blocks.size() - 1; i++) {
                String route = new Router().execute(nusMap, blockAlias, blocks.get(i), blocks.get(i + 1));
                dayRoute.append(route);
                if (i < blocks.size() - 2) {
                    dayRoute.append("\n");
                }
            }
            return dayRoute.toString();
        } catch (NumberFormatException e) {
            throw new InvalidDayException();
        }
    }

    public int getIndex(UiManager ui, ArrayList<String> selectableDays,
                        DailyRoute dailyRoute) throws InvalidDayException {
        try {
            int selection = Integer.parseInt(ui.getUserInput()) - 1;
            if (selection < 0 || selection > selectableDays.size() - 1) {
                throw new InvalidDayException();
            }
            String day = selectableDays.get(selection);
            return dailyRoute.getValidDays().indexOf(day);
        } catch (NumberFormatException e) {
            throw new InvalidDayException();
        }
    }

}