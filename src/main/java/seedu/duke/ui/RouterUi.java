package seedu.duke.ui;

import seedu.duke.data.Block;

public class RouterUi extends UiManager {

    public String[] getRoutingInfo() {
        String[] startAndDestination = new String[2];

        showMessage("Starting Block:");
        startAndDestination[0] = getUserInput().toUpperCase();

        showMessage("Destination Block:");
        startAndDestination[1] = getUserInput().toUpperCase();

        return startAndDestination;
    }

    public int getEateryEntry(Block[] eateries) {
        showMessage(
                CommonMessage.DIVIDER,
                "Here are the list of eateries(from closest to furthest):"
        );

        for (int i = 0; i < eateries.length; i++) {
            showMessage((i + 1) + ". " + eateries[i].getName());
        }

        showMessageWithDivider(
                CommonMessage.DIVIDER,
                "SELECT ENTRY TO GO:"
        );
        return Integer.parseInt(getUserInput());
    }
}
