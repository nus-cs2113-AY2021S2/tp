//@@author SimBowen

package seedu.duke.ui;

import seedu.duke.data.NusMap;
import seedu.duke.exception.EmptyDailyRouteException;
import seedu.duke.exception.InvalidBlockException;
import seedu.duke.exception.InvalidDailyRouteException;
import seedu.duke.exception.InvalidIndexException;
import seedu.duke.exception.RepeatedBlockException;

import java.util.ArrayList;

public class DailyRouteUi extends UiManager {

    public ArrayList<String> getScheduleInfo() {
        ArrayList<String> dailyBlocks = new ArrayList<>();
        String block = "Invalid Block";
        while (!isValidBlock(block)) {
            showMessage("Enter location of the first activity of the day: ");
            try {
                block = getBlockEntry(block);
                if (block.equals("END")) {
                    throw new InvalidDailyRouteException();
                }
                dailyBlocks.add(block);
            } catch (InvalidBlockException | RepeatedBlockException | InvalidDailyRouteException e) {
                showMessageWithDivider(CommonMessage.DIVIDER, e.getMessage());
            }
        }
        while (!block.equals("END")) {
            try {
                showMessage("Enter location of the next activity of the day: (Enter \"end\" to stop)");
                block = getBlockEntry(block);
                if (isValidBlock(block)) {
                    dailyBlocks.add(block);
                }
            } catch (InvalidBlockException | RepeatedBlockException e) {
                showMessageWithDivider(CommonMessage.DIVIDER, e.getMessage());
            }
        }
        showMessage(CommonMessage.DIVIDER);
        return dailyBlocks;
    }

    public String getBlockEntry(String previousBlock) throws InvalidBlockException, RepeatedBlockException {
        String block = getUserInput().toUpperCase();
        if (block.equals(previousBlock)) {
            throw new RepeatedBlockException();
        } else if (isValidBlock(block) || block.equals("END")) {
            return block;
        } else {
            throw new InvalidBlockException();
        }
    }

    public boolean isValidBlock(String block) {
        NusMap nusMap = new NusMap();
        return nusMap.getBlock(block) != null;
    }

    public int getDayEntry(ArrayList<String> selectableDays) throws InvalidIndexException, EmptyDailyRouteException {
        showListOfDays(selectableDays);
        showMessage("Select entry:");
        int dayIndex = getEntryFromUser(selectableDays);
        showMessage(CommonMessage.DIVIDER);
        return dayIndex;
    }

    public void showListOfDays(ArrayList<String> days) throws EmptyDailyRouteException {
        if (days.size() == 0) {
            throw new EmptyDailyRouteException();
        }
        showMessage("Here are the available days:");
        for (int i = 0; i < days.size(); i++) {
            showMessage((i + 1) + ". " + days.get(i));
        }
        showMessage(CommonMessage.DIVIDER);
    }

    public int getEntryFromUser(ArrayList<String> days) throws InvalidIndexException {
        try {
            int dayEntry = Integer.parseInt(getUserInput()) - 1;
            if (dayEntry < 0 || dayEntry > days.size() - 1) {
                throw new InvalidIndexException();
            }
            return dayEntry;
        } catch (NumberFormatException e) {
            throw new InvalidIndexException();
        }
    }

    public void showDailyRoute(ArrayList<String> schedule, ArrayList<String> routedSchedules) {
        for (int i = 0; i < schedule.size(); i++) {
            showMessage("Location of activity " + (i + 1) + ": " + schedule.get(i));
            String route = "";
            route = routedSchedules.get(i);
            if (i > 0 && i < schedule.size() - 1) {
                route += CommonMessage.LINE_SEPARATOR;
            }
            if (schedule.size() > 1) {
                showMessage(route);
            }
        }
        showMessage(CommonMessage.DIVIDER);
    }
}
