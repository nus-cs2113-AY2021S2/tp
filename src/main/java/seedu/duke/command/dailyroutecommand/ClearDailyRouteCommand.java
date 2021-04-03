package seedu.duke.command.dailyroutecommand;

import seedu.duke.command.Command;
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
        ArrayList<String> selectableDays = dailyRoute.getSelectableDays();
        if (selectableDays.size() == 0) {
            ui.showMessageWithDivider("There are no daily routes planned!");
            return;
        }
        try {
            int dayEntry = ui.getDayEntry(selectableDays);
            String selectedDay = selectableDays.get(dayEntry);
            dailyRoute.addDailyRoute(selectedDay, new ArrayList<>());
            ui.showMessageWithDivider(String.format(MESSAGE_SUCCESS,selectedDay));
        } catch (InvalidIndexException e) {
            ui.showMessageWithDivider(e.getMessage());
        }
    }
}