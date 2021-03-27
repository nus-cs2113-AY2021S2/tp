package seedu.duke.ui;

import seedu.duke.DaySchedulePair;
import seedu.duke.Map;
import seedu.duke.exception.InvalidBlockException;
import seedu.duke.exception.InvalidDayException;

import java.util.ArrayList;
import java.util.List;

public class DailyRouteUi extends Ui {
    public DailyRouteUi() {
    }

    public DaySchedulePair getDailyRouteInfo()
            throws InvalidDayException, InvalidBlockException {
        String day = getValidDay();
        ArrayList<String> dailyBlocks = getSchedule();
        return new DaySchedulePair(day, dailyBlocks);
    }

    public ArrayList<String> getSchedule() throws InvalidBlockException {
        showToUser("Enter Location of the first activity of the day: ");
        ArrayList<String> dailyBlocks = new ArrayList<>();
        String initialBlock = getValidBlock();
        dailyBlocks.add(initialBlock);
        while (true) {
            showToUser("Enter Location of the next activity of the day: ");
            String nextBlock = getValidBlock();
            if (nextBlock.equals("END")) {
                break;
            } else {
                dailyBlocks.add(nextBlock);
            }
        }
        return dailyBlocks;
    }

    public String getValidDay() throws InvalidDayException {
        showToUser("Enter the day: ");
        String day = getUserInput().toUpperCase().trim();
        List<String> daysList = List.of("MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY", "SUNDAY");
        ArrayList<String> days = new ArrayList<>(daysList);
        if (!days.contains(day)) {
            throw new InvalidDayException();
        }
        return day;
    }

    public String getValidBlock() throws InvalidBlockException {
        String block = getUserInput().toUpperCase().trim();
        Map nusMap = new Map();
        if (block.equals("END")) {
            showToUser(divider);
            return block;
        } else if (nusMap.getBlock(block) == null) {
            throw new InvalidBlockException();
        }
        return block;
    }
}
