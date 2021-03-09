package seedu.duke;

public class Links {

    protected int linkIndex;

    public Links(int linkIndex) {
        this.linkIndex = linkIndex;
    }

    public void execute() {
        int externalLinksCommandNumber = 0;
        while (true) {
            switch (linkIndex) {
            case 1:
                Ui.printExternalLinksMessage();
                String externalLinksCommand = Ui.readCommand();
                if (externalLinksCommand.isEmpty()) {
                    return;
                }
                externalLinksCommandNumber = Integer.parseInt(externalLinksCommand);
                while (externalLinksCommandNumber != 4) {
                    ExternalLinks externalLinks = new ExternalLinks(externalLinksCommandNumber);
                    externalLinks.execute();
                    Ui.printNextLinkMessage();
                    externalLinksCommandNumber = Integer.parseInt(Ui.readCommand());
                }
                Ui.printLinksMessage();
                linkIndex = Integer.parseInt(Ui.readCommand());
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
                linkIndex = Integer.parseInt(Ui.readCommand());
            }
        }
    }
}
