package seedu.duke.command.dailyroutecommand;

import seedu.duke.command.Command;
import seedu.duke.exception.EmptyDailyRouteException;
import seedu.duke.exception.InvalidIndexException;
import seedu.duke.ui.DailyRouteUi;


import java.util.ArrayList;

public class ClearDailyRouteCommand extends Command {
    protected DailyRouteUi ui;
    private static String MESSAGE_SUCCESS = "Got it! Successfully cleared %s's schedule!";

    public ClearDailyRouteCommand() {
        this.ui = new DailyRouteUi();
    }

    @Override
    public void execute() {
        try {
            ArrayList<String> selectableDays = dailyRoute.getSelectableDays();
            int dayEntry = ui.getDayEntry(selectableDays);
            String selectedDay = selectableDays.get(dayEntry);
            dailyRoute.addDailyRoute(selectedDay, new ArrayList<>());
            ui.showMessageWithDivider(String.format(MESSAGE_SUCCESS,selectedDay));
        } catch (InvalidIndexException | EmptyDailyRouteException e) {
            ui.showMessageWithDivider(e.getMessage());
        }
    }
}