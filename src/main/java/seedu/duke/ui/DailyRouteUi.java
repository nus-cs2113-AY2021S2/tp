//@@author SimBowen

package seedu.duke.ui;

import seedu.duke.data.NusMap;
import seedu.duke.exception.EmptyDailyRouteException;
import seedu.duke.exception.InvalidBlockException;
import seedu.duke.exception.InvalidIndexException;

import java.util.ArrayList;

public class DailyRouteUi extends UiManager {

    public ArrayList<String> getScheduleInfo() {
        ArrayList<String> dailyBlocks = new ArrayList<>();
        String block = "Invalid Block";
        while (!isValidBlock(block)) {
            showMessage("Enter location of the first activity of the day: ");
            try {
                block = getBlockEntry();
            } catch (InvalidBlockException e) {
                showMessage(e.getMessage());
            }
        }
        while (!block.equals("END")) {
            try {
                dailyBlocks.add(block);
                showMessage("Enter location of the next activity of the day: ");
                block = getBlockEntry();
            } catch (InvalidBlockException e) {
                showMessage(e.getMessage());
            }
        }
        showMessage(CommonMessage.DIVIDER);
        return dailyBlocks;
    }


    public boolean isValidBlock(String block) {
        NusMap nusMap = new NusMap();
        return nusMap.getBlock(block) != null;
    }

    public String getBlockEntry() throws InvalidBlockException {
        String block = getUserInput().toUpperCase();
        if (isValidBlock(block) || block.equals("END")) {
            return block;
        } else {
            throw new InvalidBlockException();
        }
    }

    public int getDayEntry(ArrayList<String> selectableDays) throws InvalidIndexException, EmptyDailyRouteException {
        showListOfDays(selectableDays);
        showMessage("SELECT ENTRY:");
        int dayIndex =  getEntryFromUser(selectableDays);
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
}
