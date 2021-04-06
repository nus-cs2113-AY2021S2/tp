package seedu.duke.link;

import seedu.duke.Storage;
import seedu.duke.Ui;

import java.io.IOException;

public class ExternalLinks extends Links {

    private static final int ADD_LINK_COMMAND = 1;
    private static final int DELETE_LINK_COMMAND = 2;
    private static final int VIEW_LINK_COMMAND = 3;
    private static final int EXIT_COMMAND = 4;
    protected int linkIndex;

    public ExternalLinks(int linkIndex) {
        super(linkIndex);
        this.linkIndex = linkIndex;
    }

    @Override
    public void execute() {
        while (true) {
            switch (linkIndex) {
            case ADD_LINK_COMMAND:
                Ui.printEnterLinkMessage();
                String linkDescription = Ui.readCommand();
                if (!LinkInfo.isValidLink(linkDescription)) {
                    Ui.printInvalidLinkMessage();
                    continue;
                }
                if (isDuplicate(linkDescription)) {
                    Ui.printDuplicateMessage();
                    continue;
                }
                LinkInfo.addLink(linkDescription);
                Ui.printAddLinkMessage(linkDescription);
                break;
            case DELETE_LINK_COMMAND:
                viewLinks();
                Ui.printLinkToDelete();
                try {
                    int deleteIndex = Integer.parseInt(Ui.readCommand()) - 1;
                    LinkInfo.deleteLink(deleteIndex);
                } catch (NumberFormatException | IndexOutOfBoundsException e) {
                    Ui.printRepeatInputUntilValidMessage();
                    continue;
                }
                break;
            case VIEW_LINK_COMMAND:
                viewLinks();
                break;
            case EXIT_COMMAND:
                Ui.printReturnToLinkMenuMessage();
                return;
            default:
                Ui.printInvalidInputMessage();
            }
            try {
                Storage.saveAllFiles();
            } catch (IOException e) {
                Ui.printFilesCouldNotBeSavedMessage();
            }
            Ui.printExternalLinksMessage();
            linkIndex = Ui.readCommandToInt();
        }
    }

    public static void viewLinks() {
        if (LinkInfo.linksList.isEmpty()) {
            Ui.printListIsEmpty();
            return;
        }
        Ui.printLinks(LinkInfo.linksList);
    }
}
