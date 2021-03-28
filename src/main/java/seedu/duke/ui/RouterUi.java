package seedu.duke.ui;

public class RouterUi extends Ui {

    public RouterUi() {
    }

    public String[] getRoutingInfo() {
        String[] startAndDestination = new String[2];

        showToUser("Starting Block:");
        startAndDestination[0] = getUserInput().toUpperCase().trim();

        showToUser("Destination Block:");
        startAndDestination[1] = getUserInput().toUpperCase().trim();

        return startAndDestination;
    }
}
