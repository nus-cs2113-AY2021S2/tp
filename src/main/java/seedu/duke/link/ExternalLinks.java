package seedu.duke.link;

import seedu.duke.Ui;

public class ExternalLinks extends Links {

    protected int linkIndex;

    public ExternalLinks(int linkIndex) {
        super(linkIndex);
        this.linkIndex = linkIndex;
    }

    @Override
    public void execute() {

        switch (linkIndex) {
        case 1:
            Ui.printEnterLinkMessage();
            String linkDescription = Ui.readCommand();
            if (!LinkInfo.isValidLink(linkDescription)) {
                Ui.printInvalidLinkMessage();
                break;
            }
            LinkInfo.addLink(linkDescription);
            Ui.printAddLinkMessage(linkDescription);
            break;
        case 2:
            viewLinks();
            Ui.printLinkToDelete();
            int deleteIndex = Integer.parseInt(Ui.readCommand()) - 1;
            LinkInfo.deleteLink(deleteIndex);
            break;
        case 3:
            viewLinks();
            break;
        case 4:
            return;
        default:
            Ui.printInvalidIntegerMessage();
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
