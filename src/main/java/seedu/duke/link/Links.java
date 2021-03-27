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
                continue;
            case 2:
                // add zoom links
                add();
                break;
            case 3:
                // delete zoom links
                delete();
                break;
            case 4:
                // view zoom links
                viewLinks();
                break;
            case 5:
                // exit
                return;
            default:
                Ui.printInvalidIntegerMessage();
            }
            Ui.printLinksMessage();
            linkIndex = Ui.readCommandToInt();
        }
    }

    public static void add() {
        Ui.printEnterZoomLinkMessage();
        String instruction = Ui.readCommand();
        ZoomLinkInfo.addZoomLink(instruction);
        Ui.printZoomLinksAdded(instruction);
    }

    public static void delete () {
        viewLinks();
        Ui.printLinkToDelete();
        int deleteIndex = Integer.parseInt(Ui.readCommand()) - 1;
        try {
            ZoomLinkInfo.deleteZoomLink(deleteIndex);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Oops you have entered an invalid index number...");
        }
    }

    public static void viewLinks() {
        if (ZoomLinkInfo.zoomLinksList.isEmpty()) {
            Ui.printListIsEmpty();
            return;
        }
        Ui.printZoomLinks(ZoomLinkInfo.zoomLinksList);
    }
}
