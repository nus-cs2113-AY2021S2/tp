package seedu.duke.link;

import java.util.ArrayList;
import java.util.regex.*;
import seedu.duke.Ui;

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


    //@@author prashant srivastava
    //Reused from https://www.geeksforgeeks.org/check-if-an-url-is-valid-or-not-using-regular-expression/
    //with minor modifications
    public static boolean isValidLink(String linkDescription) {
        String regex = "((http|https)://)"
            + "(www.)"
            + "[a-zA-Z0-9@:%._\\+~#?&//=]"
            + "{2,256}\\.[a-z]"
            + "{2,6}\\b([-a-zA-Z0-9@:%"
            + "._\\+~#?&//=]*)";

        Pattern p = Pattern.compile(regex);

        if (linkDescription == null) {
            return false;
        }
        Matcher m = p.matcher(linkDescription);

        return m.matches();
    }
    //@@author
}
