package seedu.duke;

public class Links {

    protected int linkIndex;

    public Links(int linkIndex) {
        this.linkIndex = linkIndex;
    }

    public void execute() {
        while (true) {
            switch (linkIndex) {
            case 1:
                //external links menu
                int externalLinksCommand = Integer.parseInt(Ui.readCommand());
                ExternalLinks externalLinks = new ExternalLinks(externalLinksCommand);
                break;
            case 2:
                // zoom menu
                break;
            case 3:
                //exit
            default:
                Ui.printInvalidIntegerMessage();
            }
        }
    }
}
