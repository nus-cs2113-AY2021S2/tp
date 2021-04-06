package seedu.duke.features.link;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import seedu.duke.ui.Ui;

public class LinkInfo {

    public static ArrayList<LinkInfo> linksList = new ArrayList<>();

    private String linkDescription;
    private static final String nusRedditLink = "https://www.reddit.com/r/nus";
    private static final String luminusLink = "https://www.luminus.nus.edu.sg";
    private static final String edurecLink = "https://www.myedurec.nus.edu.sg";

    public LinkInfo(String linkDescription) {
        this.linkDescription = linkDescription;
    }

    public static void initialiseList() {
        for (LinkInfo link : LinkInfo.linksList) {
            if (link.getLink().equals(nusRedditLink)
                || link.getLink().equals(luminusLink)
                || link.getLink().equals(edurecLink)) {
                return;
            }
        }
        LinkInfo nusLink = new LinkInfo(nusRedditLink);
        linksList.add(nusLink);
        LinkInfo luminus = new LinkInfo(luminusLink);
        linksList.add(luminus);
        LinkInfo edurec = new LinkInfo(edurecLink);
        linksList.add(edurec);
    }

    public static void addLink(String linkDescription) {
        LinkInfo link = new LinkInfo(linkDescription);
        linksList.add(link);
    }

    public static void addLink(LinkInfo linkDescription) {
        linksList.add(linkDescription);
    }

    public static void deleteLink(int deleteIndex) throws NumberFormatException, IndexOutOfBoundsException {
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
