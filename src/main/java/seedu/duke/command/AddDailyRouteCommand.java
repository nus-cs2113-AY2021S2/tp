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

import java.util.ArrayList;

public class AddDailyRouteCommand extends Command {
    public AddDailyRouteCommand(String userInput) {
        super(userInput);
    }

    @Override
    public void execute(Map nusMap, UiManager ui, History history, DailyRoute dailyRoute,
                        BlockAlias blockAlias, FavouriteLocation favouriteLocation) {
        ArrayList<String> selectableDays = dailyRoute.getValidDays();
        ui.showToUser("Please enter the number of the day you want to schedule for:");
        StringBuilder dayIndexing = new StringBuilder();
        for (int i = 0; i < 7; i++) {
            dayIndexing.append(i + 1).append(". ").append(selectableDays.get(i));
            if (i < 6) {
                dayIndexing.append("\n");
            }
        }
        ui.showToUser(dayIndexing.toString());
        try {
            int index = getIndex(ui);
            String day = selectableDays.get(index);
            ArrayList<String> schedule = ui.getSchedule();
            dailyRoute.addDailyRoute(day, schedule);
        } catch (InvalidDayException e) {
            ui.showToUser(e.getMessage());
        } catch (InvalidBlockException e) {
            ui.showToUser(e.getMessage());
        }
    }

    public int getIndex(UiManager ui) throws InvalidDayException {
        try {
            int selection = Integer.parseInt(ui.getUserInput()) - 1;
            if (selection < 0 || selection > 6) {
                throw new InvalidDayException();
            }
            return selection;
        } catch (NumberFormatException e) {
            throw new InvalidDayException();
        }
    }


}