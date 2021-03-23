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
                LinkInfo.initialiseList();
                while (externalLinksCommandNumber != EXIT_COMMAND) {
                    Ui.printExternalLinksMessage();
                    externalLinksCommandNumber = Ui.readCommandToInt();
                    ExternalLinks externalLinks = new ExternalLinks(externalLinksCommandNumber);
                    externalLinks.execute();
                }
                externalLinksCommandNumber = -1;
                Ui.printLinksMessage();
                linkIndex = Ui.readCommandToInt();
                continue;
            case 2:
                // add zoom links
                Ui.printEnterZoomLinkMessage();
                String instruction = Ui.readCommand();
                String[] words = instruction.split(" ");
                try {
                    ZoomLinkInfo.addZoomLink(words[0], words[1]);
                } catch (ArrayIndexOutOfBoundsException e) {
                    Ui.printNoInputDetected();
                    continue;
                }
                Ui.printZoomLinksAdded(words[0], words[1]);
                Ui.printLinksMessage();
                linkIndex = Ui.readCommandToInt();
                break;
            case 3:
                // delete zoom links
                viewLinks();
                Ui.printLinkToDelete();
                ZoomLinkInfo.deleteZoomLink();
                Ui.printLinksMessage();
                linkIndex = Ui.readCommandToInt();
                break;
            case 4:
                // view zoom links
                viewLinks();
                Ui.printLinksMessage();
                linkIndex = Ui.readCommandToInt();
                break;
            case 5:
                // exit
                return;
            default:
                Ui.printInvalidIntegerMessage();
                Ui.printLinksMessage();
                linkIndex = Ui.readCommandToInt();
            }
        }
    }

    public void viewLinks() {
        if (ZoomLinkInfo.zoomLinksList.isEmpty()) {
            Ui.printListIsEmpty();
            return;
        }
        Ui.printZoomLinks(ZoomLinkInfo.zoomLinksList);
    }
}
