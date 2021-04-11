package seedu.duke.features.link;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import seedu.duke.ui.Ui;

/**
 * This class deals with the LinkInfo object and linksList which is an array of LinkInfo objects.
 */
public class LinkInfo {

    public static ArrayList<LinkInfo> linksList = new ArrayList<>();
    private static boolean isInitialised = false;

    private String linkDescription;
    private static final String nusRedditLink = "https://www.reddit.com/r/nus";
    private static final String luminusLink = "https://www.luminus.nus.edu.sg";
    private static final String edurecLink = "https://www.myedurec.nus.edu.sg";
    private static ArrayList<String> initialisedList = new ArrayList<String>(
            Arrays.asList(nusRedditLink, luminusLink, edurecLink));

    public LinkInfo(String linkDescription) {
        this.linkDescription = linkDescription;
    }

    /**
     * Populates the linksList with the default links at the start of every app launch.
     */
    public static void initialiseList() {
        for (String defaultLink : initialisedList) {
            for (LinkInfo link : LinkInfo.linksList) {
                if (link.getLink().equals(defaultLink)) {
                    isInitialised = true;
                    break;
                }
                isInitialised = false;
            }
            if (!isInitialised) {
                linksList.add(new LinkInfo(defaultLink));
            }
        }
    }

    public static void addLink(String linkDescription) {
        LinkInfo link = new LinkInfo(linkDescription);
        linksList.add(link);
    }

    public static void addLink(LinkInfo linkDescription) {
        linksList.add(linkDescription);
    }

    /**
     * Deletes a LinkInfo object from linksList.
     *
     * @param deleteIndex is the index of the object to be deleted.
     * @throws IndexOutOfBoundsException if the index is out of bounds.
     */
    public static void deleteLink(int deleteIndex) throws IndexOutOfBoundsException {
        assert deleteIndex >= 0 : "Index is invalid";
        LinkInfo deletedLinkInfo = linksList.get(deleteIndex);
        linksList.remove(deleteIndex);
        Ui.printLinkDeleted(deletedLinkInfo);
    }

    public String getLink() {
        return linkDescription;
    }

    // @@author prashant srivastava
    // Reused from
    // https://www.geeksforgeeks.org/check-if-an-url-is-valid-or-not-using-regular-expression/
    // with minor modifications
    public static boolean isValidLink(String linkDescription) {
        String regex =
                "((http|https)://)"
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
    // @@author
}
