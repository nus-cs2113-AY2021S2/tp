package seedu.duke.goal.timemanager;

import seedu.duke.account.FitCenter;
import seedu.duke.common.Messages;
import seedu.duke.goal.PeriodType;
import seedu.duke.storage.Storage;
import seedu.duke.ui.UI;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TimeController {
    private static final Logger logger = Logger.getLogger("Time Control logger");
    private LocalDate appToday;
    private int appWeekOfYear;
    private Storage storage;
    private boolean isInitialStart = false;

    public TimeController() {
        try {
            String timePath = "data" + File.separator + "appTime.txt";
            storage = new Storage(timePath);
            String[] timeStrParams = getTimeStrParamsFromFile();
            if (timeStrParams != null && timeStrParams.length == 2) {
                appToday = LocalDate.parse(timeStrParams[0]);
                appWeekOfYear = Integer.parseInt(timeStrParams[1]);
            } else {
                appToday = LocalDate.now();
                appWeekOfYear = getSystemWeekOfYear();
            }
        } catch (IOException e) {
            UI.printMessage(Messages.MESSAGE_CANT_INIT_STORAGE);
        }
    }

    public void checkForTime(FitCenter fitCenter) {
        boolean toUpdateFile = false;
        if (isTodayANewDay()) {
            appToday = LocalDate.now();
            toUpdateFile = true;
            fitCenter.resetGoalProgress(PeriodType.DAILY);
            UI.printMessage(Messages.MESSAGE_NEW_DAY + Messages.MESSAGE_CHECK_GOALS_PROMPT);
        } else {
            if (!isInitialStart) {
                UI.printMessage(Messages.MESSAGE_SAME_DAY);
            }
        }

        if (isThisWeekANewWeek()) {
            appWeekOfYear = getSystemWeekOfYear();
            toUpdateFile = true;
            fitCenter.resetGoalProgress(PeriodType.WEEKLY);
            UI.printMessage(String.format(Messages.MESSAGE_NEW_WEEK, appWeekOfYear)
                    + Messages.MESSAGE_CHECK_GOALS_PROMPT);
        }

        if (toUpdateFile || isInitialStart) {
            storeTimeToTextFile();
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

    private String[] getTimeStrParamsFromFile() {
        try {
            String[] timeStrParams = storage.getTimeStrParams();
            if (timeStrParams.length == 1) {
                isInitialStart = true;
            } else {
                logger.log(Level.INFO, "Param 0: " + timeStrParams[0] + " Param 1: " + timeStrParams[1]);
            }
            return timeStrParams;
        } catch (FileNotFoundException e) {
            UI.printMessage("Time file not found!");
            isInitialStart = true;
            return null;
        }
    }

    private void storeTimeToTextFile() {
        try {
            String[] timeStringParams = new String[2];
            timeStringParams[0] = appToday.toString();
            timeStringParams[1] = String.valueOf(appWeekOfYear);
            storage.storeTime(timeStringParams);
        } catch (IOException e) {
            UI.printMessage(Messages.MESSAGE_CANT_STORE_TIME);
        }
    }

}
