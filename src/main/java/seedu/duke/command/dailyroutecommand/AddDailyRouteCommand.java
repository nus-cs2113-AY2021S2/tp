package seedu.duke.command.dailyroutecommand;

import seedu.duke.command.Command;
import seedu.duke.exception.InvalidIndexException;
import seedu.duke.ui.DailyRouteUi;
import seedu.duke.exception.InvalidBlockException;

import java.util.ArrayList;

public class AddDailyRouteCommand extends Command {

    protected DailyRouteUi ui;
    private static String MESSAGE_SUCCESS = "Got it! Successfully added %s's schedule!";

    public AddDailyRouteCommand() {
        this.ui = new DailyRouteUi();
    }

    @Override
    public void execute() {
        ArrayList<String> validDays = dailyRoute.getValidDays();
        try {
            int index = ui.getDayEntryForAdd(validDays);
            String day = validDays.get(index);
            ArrayList<String> schedule = ui.getScheduleInfo();
            dailyRoute.addDailyRoute(day, schedule);
            if (schedule.size() == 0) {
                MESSAGE_SUCCESS = "Got it! Successfully cleared %s's schedule!";
            }
            ui.showMessageWithDivider(String.format(MESSAGE_SUCCESS, day));
        } catch (InvalidBlockException | InvalidIndexException e) {
            ui.showMessageWithDivider(e.getMessage());
        }
    }
}