package seedu.duke.ui;

import seedu.duke.data.Block;
import seedu.duke.exception.InvalidIndexException;
import seedu.duke.exception.SameBlockException;

public class RouterUi extends UiManager {

    public String[] getRoutingInfo() throws SameBlockException {
        String[] startAndDestination = new String[2];

        showMessage("Starting Block:");
        startAndDestination[0] = getUserInput().toUpperCase();

        showMessage("Destination Block:");
        startAndDestination[1] = getUserInput().toUpperCase();

        showMessage(CommonMessage.DIVIDER);
        if (startAndDestination[0].equals(startAndDestination[1])) {
            throw new SameBlockException();
        }
        return startAndDestination;
    }

    public int getEateryIndex(Block[] eateries) throws InvalidIndexException {
        showMessage("Here are the list of eateries(from closest to furthest):");
        for (int i = 0; i < eateries.length; i++) {
            showMessage((i + 1) + ". " + eateries[i].getName());
        }
        showMessage(
                CommonMessage.DIVIDER,
                "Select entry to go:"
        );
        try {
            int eateryIndex = Integer.parseInt(getUserInput());
            showMessage(CommonMessage.DIVIDER);
            return eateryIndex;
        } catch (NumberFormatException e) {
            throw new InvalidIndexException();
        }
    }
}
