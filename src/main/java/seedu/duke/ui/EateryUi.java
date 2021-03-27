package seedu.duke.ui;

import seedu.duke.Block;

public class EateryUi extends Ui {

    public EateryUi() {
    }

    public int getEateryEntry(Block[] eateries) {
        showToUser(divider);
        showToUser("Here are the list of eateries(from closest to furthest):");
        for (int i = 0; i < eateries.length; i++) {
            showToUser((i + 1) + ". " + eateries[i].getName());
        }
        showToUser(lineSeparator + "SELECT ENTRY TO GO:");
        return Integer.parseInt(getUserInput());
    }
}
