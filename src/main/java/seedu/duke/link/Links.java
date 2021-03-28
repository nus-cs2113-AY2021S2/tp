package seedu.duke.link;

import seedu.duke.Ui;

public class Links {

    private static final int EXTERNAL_LINK_COMMAND = 1;
    private static final int ADD_ZOOM_LINK_COMMAND = 2;
    private static final int DELETE_ZOOM_LINK_COMMAND = 3;
    private static final int VIEW_ZOOM_LINK_COMMAND = 4;
    private static final int EXIT_COMMAND = 5;
    protected int linkIndex;

    public Links(int linkIndex) {
        this.linkIndex = linkIndex;
    }

    public void execute() {
        int externalLinksCommandNumber = 0;
        while (true) {
            switch (linkIndex) {
            case EXTERNAL_LINK_COMMAND:
                LinkInfo.initialiseList();
                Ui.printExternalLinksMessage();
                externalLinksCommandNumber = Ui.readCommandToInt();
                ExternalLinks externalLinks = new ExternalLinks(externalLinksCommandNumber);
                externalLinks.execute();
                break;
            case ADD_ZOOM_LINK_COMMAND:
                // add zoom links
                add();
                break;
            case DELETE_ZOOM_LINK_COMMAND:
                // delete zoom links
                delete();
                break;
            case VIEW_ZOOM_LINK_COMMAND:
                // view zoom links
                viewLinks();
                break;
            case EXIT_COMMAND:
                // exit
                Ui.printReturnToMainMenuMessage();
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

    public static void delete() {
        viewLinks();
        if (ZoomLinkInfo.zoomLinksList.isEmpty()) {
            return;
        }
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
