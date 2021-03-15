package seedu.duke.link;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import seedu.duke.Ui;

public class LinkInfo {

    private static ArrayList<String> linksList = new ArrayList<>();
    private static ArrayList<ArrayList<String>> zoomLinksList = new ArrayList<ArrayList<String>>();

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
        String deletedString = linksList.get(deleteIndex);
        assert deleteIndex < 0 : "Index is invalid";
        linksList.remove(deleteIndex);
        Ui.printLinkDeleted(deletedString);
    }

    public void viewLinks() {
        if (linksList.isEmpty()) {
            Ui.printListIsEmpty();
            return;
        }
        Ui.printLinks(linksList);
    }

    public static void addZoomLink(String linkDescription, String moduleCode) {
        String passwordCommand = Ui.printEnterRequirePassword();
        if (passwordCommand.equals("y")) {
            String password = Ui.printEnterPassword();
            assert password.isEmpty() : "password cannot be empty";
            zoomLinksList
                .add(new ArrayList<>(Arrays.asList(linkDescription, moduleCode, password)));
        } else {
            assert !passwordCommand.equals("n") : "password should be y or n";
            zoomLinksList.add(new ArrayList<>(Arrays.asList(linkDescription, moduleCode)));
        }
    }

    public static void viewZoomLinks() {
        if (zoomLinksList.isEmpty()) {
            Ui.printListIsEmpty();
            return;
        }
        Ui.printZoomLinks(zoomLinksList);
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
