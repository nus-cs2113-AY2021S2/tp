package seedu.duke.link;

import seedu.duke.Storage;
import seedu.duke.Ui;

import java.io.IOException;

public class Links {

    private static final int EXTERNAL_LINK_COMMAND = 1;
    private static final int ADD_ZOOM_LINK_COMMAND = 2;
    private static final int DELETE_ZOOM_LINK_COMMAND = 3;
    private static final int VIEW_ZOOM_LINK_COMMAND = 4;
    private static final int EXIT_COMMAND = 5;
    private static boolean isInvalid = false;
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
                if (isInvalid) {
                    continue;
                }
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
                Ui.printInvalidInputMessage();
            }
            try {
                Storage.saveAllFiles();
            } catch (IOException e) {
                Ui.printFilesCouldNotBeSavedMessage();
            }
            Ui.printLinksMessage();
            linkIndex = Ui.readCommandToInt();
        }
    }

    public static void add() {
        Ui.printEnterZoomLinkMessage();
        ZoomLinkInfo.addZoomLink();
    }

    public static void delete() {
        viewLinks();
        if (ZoomLinkInfo.zoomLinksList.isEmpty()) {
            return;
        }
        Ui.printLinkToDelete();
        try {
            int deleteIndex = Integer.parseInt(Ui.readCommand()) - 1;
            ZoomLinkInfo.deleteZoomLink(deleteIndex);
            isInvalid = false;
        } catch (IndexOutOfBoundsException | NumberFormatException e) {
            Ui.printRepeatInputUntilValidMessage();
            isInvalid = true;
        }
    }

    public static void viewLinks() {
        if (ZoomLinkInfo.zoomLinksList.isEmpty()) {
            Ui.printListIsEmpty();
            return;
        }
        Ui.printZoomLinks(ZoomLinkInfo.zoomLinksList);
    }

    public boolean isDuplicate(String linkToCheck) {
        for (LinkInfo link : LinkInfo.linksList) {
            if (linkToCheck.equals(link.getLink())) {
                return true;
            }
        }
        return false;
    }
}
