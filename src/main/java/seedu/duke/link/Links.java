package seedu.duke.link;

import seedu.duke.Ui;

public class Links {

    private static final int EXIT_COMMAND = 4;
    protected int linkIndex;

    public Links(int linkIndex) {
        this.linkIndex = linkIndex;
    }

    public void execute() {
        int externalLinksCommandNumber = 0;
        while (true) {
            switch (linkIndex) {
            case 1:
                while (externalLinksCommandNumber != EXIT_COMMAND) {
                    Ui.printExternalLinksMessage();
                    externalLinksCommandNumber = Ui.readCommandToInt();
                    ExternalLinks externalLinks = new ExternalLinks(externalLinksCommandNumber);
                    externalLinks.execute();
                }
                Ui.printLinksMessage();
                linkIndex = Ui.readCommandToInt();
                continue;
            case 2:
                // zoom menu
                break;
            case 3:
                //exit
                return;
            default:
                Ui.printInvalidIntegerMessage();
                Ui.printLinksMessage();
                linkIndex = Ui.readCommandToInt();
            }
        }
    }
}
