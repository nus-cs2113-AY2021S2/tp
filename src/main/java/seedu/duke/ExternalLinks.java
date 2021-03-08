package seedu.duke;

public class ExternalLinks extends Links {

    int linkIndex;

    public ExternalLinks(int linkIndex) {
        super(linkIndex);
        this.linkIndex = linkIndex;
    }

    @Override
    public void execute() {
        LinkInfo link = new LinkInfo();

        switch (linkIndex) {
        case 1:
            Ui.printEnterLinkMessage();
            String linkDescription = Ui.readCommand();
            if (!LinkInfo.isValidLink(linkDescription)) {
                Ui.printInvalidLinkMessage();
                break;
            }
            link.addLink(linkDescription);
            Ui.printAddLinkMessage(linkDescription);
            break;
        case 2:
            link.deleteLink();
            break;
        case 3:
            link.viewLinks();
            break;
        case 4:
            return;
        default:
            Ui.printInvalidIntegerMessage();
        }
    }
}
