package seedu.duke;

import java.util.ArrayList;
import org.apache.commons.validator.routines.UrlValidator;

public class LinkInfo {

    private static ArrayList<String> linksList = new ArrayList<>();

    public void addLink(String linkDescription) {
        linksList.add(linkDescription);
    }

    public void deleteLink() {
        if (linksList.isEmpty()) {
            Ui.printListIsEmpty();
            return;
        }
        Ui.printLinkToDelete();
        viewLinks();
        int deleteIndex = Integer.parseInt(Ui.readCommand()) - 1;
        linksList.remove(deleteIndex);
    }

    public void viewLinks() {
        if (linksList.isEmpty()) {
            Ui.printListIsEmpty();
            return;
        }
        Ui.printLinks(linksList);
    }

    public static boolean isValidLink(String linkDescription) {
        String[] schemes = {"http", "https"};
        UrlValidator urlValidator = new UrlValidator(schemes);
        if (urlValidator.isValid(linkDescription)) {
            return true;
        }
        return false;
    }
}
