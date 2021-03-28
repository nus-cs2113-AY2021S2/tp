package seedu.duke.ui;

import seedu.duke.Map;
import seedu.duke.exception.InvalidBlockException;

import java.util.ArrayList;

public class DailyRouteUi extends Ui {
    public DailyRouteUi() {
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
