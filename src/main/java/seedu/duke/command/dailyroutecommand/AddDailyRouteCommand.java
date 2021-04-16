//@@author SimBowen

package seedu.duke.command.dailyroutecommand;

import seedu.duke.command.Command;
import seedu.duke.exception.EmptyDailyRouteException;
import seedu.duke.exception.InvalidIndexException;
import seedu.duke.ui.DailyRouteUi;


import java.util.ArrayList;

/**
 * Adds a daily schedule.
 */
public class AddDailyRouteCommand extends Command {

    protected DailyRouteUi ui;
    private static String MESSAGE_SUCCESS = "Got it! Successfully added %s's schedule!";

    public AddDailyRouteCommand() {
        this.ui = new DailyRouteUi();
    }


    /**
     * Gets the day and schedule specified by the user and maps it in dailyRoute
     * Success message is printed using ui at the end.
     */
    @Override
    public void execute() {
        ArrayList<String> validDays = dailyRoute.getValidDays();
        try {
            int index = ui.getDayEntry(validDays);
            String day = validDays.get(index);
            ArrayList<String> schedule = ui.getScheduleInfo();
            dailyRoute.addDailyRoute(day, schedule);
            ui.showMessageWithDivider(String.format(MESSAGE_SUCCESS, day));
        } catch (InvalidIndexException | EmptyDailyRouteException e) {
            ui.showMessageWithDivider(e.getMessage());
        }
    }
}