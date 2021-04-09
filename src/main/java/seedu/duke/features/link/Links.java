package seedu.duke.features.link;

import java.util.logging.Logger;
import seedu.duke.storage.Storage;
import seedu.duke.ui.Ui;

import java.io.IOException;
import java.util.logging.Level;

public class Links {

    private static final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    private static final int EXTERNAL_LINK_COMMAND = 1;
    private static final int ADD_ZOOM_LINK_COMMAND = 2;
    private static final int DELETE_ZOOM_LINK_COMMAND = 3;
    private static final int VIEW_ZOOM_LINK_COMMAND = 4;
    private static final int EXIT_COMMAND = 5;
    private static boolean isInvalid = false;
    private static boolean isInitialised = false;
    protected int linkIndex;

    public Links(int linkIndex) {
        this.linkIndex = linkIndex;
    }

    public void execute() {
        int externalLinksCommandNumber = 0;
        while (true) {
            switch (linkIndex) {
            case EXTERNAL_LINK_COMMAND:
                if (!isInitialised) {
                    LinkInfo.initialiseList();
                    isInitialised = true;
                }
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
                logger.log(Level.WARNING, "Saving error in zoom links");
            }
            Ui.printLinksMessage();
            linkIndex = Ui.readCommandToInt();
        }
    }

    public static void add() {
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
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            System.out.println("You have entered an invalid input! Please try again.");
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

    /**
     * checks for duplicate links in the links list.
     * @return true if linkToCheck is a duplicate.
     */
    public boolean isDuplicate(String linkToCheck) {
        for (LinkInfo link : LinkInfo.linksList) {
            if (linkToCheck.equals(link.getLink())) {
                return true;
            }
        }
        return false;
    }
}
