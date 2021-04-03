//@@author SimBowen

package seedu.duke.command.dailyroutecommand;

import seedu.duke.command.Command;

import seedu.duke.exception.EmptyDailyRouteException;
import seedu.duke.exception.InvalidIndexException;
import seedu.duke.ui.DailyRouteUi;
import seedu.duke.router.Router;

import java.util.ArrayList;

public class ShowDailyRouteCommand extends Command {
    protected DailyRouteUi ui;

    public ShowDailyRouteCommand() {
        this.ui = new DailyRouteUi();
    }

    @Override
    public void execute() {
        try {
            ArrayList<String> selectableDays = dailyRoute.getSelectableDays();
            int dayEntry = ui.getDayEntry(selectableDays);
            String selectedDay = selectableDays.get(dayEntry);
            ArrayList<String> schedules = dailyRoute.getDailyRoute(selectedDay);
            StringBuilder routedSchedule = new StringBuilder();
            for (int i = 0; i < schedules.size() - 1; i++) {
                String route = new Router().execute(nusMap, schedules.get(i), schedules.get(i + 1));
                if (i < schedules.size() - 2) {
                    routedSchedule.append(route).append("\n");
                } else {
                    routedSchedule.append(route);
                }
            }
            ui.showMessageWithDivider(routedSchedule.toString());
        } catch (InvalidIndexException | EmptyDailyRouteException e) {
            ui.showMessageWithDivider(e.getMessage());
        }
    }
}