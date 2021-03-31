package seedu.duke.goal.timemanager;

import seedu.duke.account.FitCenter;
import seedu.duke.common.Messages;
import seedu.duke.goal.PeriodType;
import seedu.duke.ui.UI;

import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TimeController {
    private static final Logger logger = Logger.getLogger("Time Control logger");
    private LocalDate appToday;
    private int appWeekOfYear;

    public TimeController() {
        appToday = getTodayFromTextFile();
        appWeekOfYear = getWeekOfYearFromTextFile();
    }

    public void checkForTime(FitCenter fitCenter) {
        if (isTodayANewDay()) {
            appToday = LocalDate.now();
            fitCenter.initializeGoalProgress(PeriodType.DAILY);
            UI.printMessage(Messages.MESSAGE_NEW_DAY + Messages.MESSAGE_CHECK_GOALS_PROMPT);
        } else {
            UI.printMessage(Messages.MESSAGE_SAME_DAY);
        }

        if (isThisWeekANewWeek()) {
            appWeekOfYear = getSystemWeekOfYear();
            fitCenter.initializeGoalProgress(PeriodType.WEEKLY);
            UI.printMessage(String.format(Messages.MESSAGE_NEW_WEEK, appWeekOfYear)
                    + Messages.MESSAGE_CHECK_GOALS_PROMPT);
        }
    }

    private boolean isTodayANewDay() {
        return appToday.isBefore(LocalDate.now());
    }

    private boolean isThisWeekANewWeek() {
        int currentWeekOfYear = getSystemWeekOfYear();
        return appWeekOfYear < currentWeekOfYear;
    }

    private int getSystemWeekOfYear() {
        LocalDate today = LocalDate.now();
        return today.get(WeekFields.of(Locale.getDefault()).weekOfYear());
    }

    private LocalDate getTodayFromTextFile() {
        LocalDate storedToday = LocalDate.now();
        logger.log(Level.INFO, storedToday.toString() + " is read from file as stored today!");
        return storedToday;
    }

    private int getWeekOfYearFromTextFile() {
        int storedWeekOfYear = 0;
        logger.log(Level.INFO, storedWeekOfYear + " is read from file as stored today!");
        return storedWeekOfYear;
    }
}
