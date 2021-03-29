package seedu.duke.command.dailyroutecommand;

import seedu.duke.command.Command;
import seedu.duke.ui.DailyRouteUi;
import seedu.duke.exception.InvalidBlockException;
import seedu.duke.exception.InvalidDayException;

import java.util.ArrayList;

public class AddDailyRouteCommand extends Command {
    protected DailyRouteUi ui;

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
        } catch (InvalidDayException | InvalidBlockException e) {
            ui.showMessageWithDivider(e.getMessage());
        }
    }
}