//@@author SimBowen

package seedu.duke.command.dailyroutecommand;

import seedu.duke.command.Command;
import seedu.duke.exception.EmptyDailyRouteException;
import seedu.duke.exception.InvalidIndexException;
import seedu.duke.ui.DailyRouteUi;

import java.util.ArrayList;


/**
 * Deletes a daily schedule.
 */
public class DeleteDailyRouteCommand extends Command {
    protected DailyRouteUi ui;
    private static String MESSAGE_SUCCESS = "Got it! Successfully cleared %s's schedule!";

    public DeleteDailyRouteCommand() {
        this.ui = new DailyRouteUi();
    }

    /**
     * Gets the day specified by the user and deletes the corresponding schedule entry by mapping an empty array list in dailyRoute.
     * Success message is printed using ui at the end.
     */
    @Override
    public void execute() {
        try {
            ArrayList<String> selectableDays = dailyRoute.getSelectableDays();
            int dayEntry = ui.getDayEntry(selectableDays);
            String selectedDay = selectableDays.get(dayEntry);
            dailyRoute.addDailyRoute(selectedDay, new ArrayList<>());
            ui.showMessageWithDivider(String.format(MESSAGE_SUCCESS, selectedDay));
        } catch (InvalidIndexException | EmptyDailyRouteException e) {
            ui.showMessageWithDivider(e.getMessage());
        }
    }
}