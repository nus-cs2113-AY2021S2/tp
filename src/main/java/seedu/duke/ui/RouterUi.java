package seedu.duke.ui;

import seedu.duke.data.Block;
import seedu.duke.exception.InvalidIndexException;

public class RouterUi extends UiManager {

    public String[] getRoutingInfo() {
        String[] startAndDestination = new String[2];

        showMessage("Starting Block:");
        startAndDestination[0] = getUserInput().toUpperCase();

        showMessage("Destination Block:");
        startAndDestination[1] = getUserInput().toUpperCase();

        showMessage(CommonMessage.DIVIDER);
        return startAndDestination;
    }

    public int getEateryIndex(Block[] eateries) throws InvalidIndexException {
        showMessage("Here are the list of eateries(from closest to furthest):");

        for (int i = 0; i < eateries.length; i++) {
            showMessage((i + 1) + ". " + eateries[i].getName());
        }

        showMessage(
                CommonMessage.DIVIDER,
                "SELECT ENTRY TO GO:"
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
