package seedu.duke;

public class Links {

    protected int linkIndex;

    public Links(int linkIndex) {
        this.linkIndex = linkIndex;
    }

    public void execute() {
        int externalLinksCommand = 0;
        while (true) {
            switch (linkIndex) {
            case 1:
                Ui.printExternalLinksMessage();
                externalLinksCommand = Integer.parseInt(Ui.readCommand());
                while (externalLinksCommand != 4) {
                    ExternalLinks externalLinks = new ExternalLinks(externalLinksCommand);
                    externalLinks.execute();
                    Ui.printNextLinkMessage();
                    externalLinksCommand = Integer.parseInt(Ui.readCommand());
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
            }
        }
    }
}
