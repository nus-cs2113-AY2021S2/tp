package seedu.duke;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static seedu.duke.features.link.LinkInfo.linksList;
import static seedu.duke.features.link.ZoomLinkInfo.zoomLinksList;

import org.junit.jupiter.api.Test;
import seedu.duke.features.link.LinkInfo;
import seedu.duke.features.link.ZoomLinkInfo;

public class LinkTest {

    @Test
    public void isValidLink_invalidLinks_false() {
        assertEquals(false, LinkInfo.isValidLink("https://ww.youtube.com"));
        assertEquals(false, LinkInfo.isValidLink("https:/www.youtube.com"));
        assertEquals(false, LinkInfo.isValidLink("https:/www.youtube.com"));
        assertEquals(false, LinkInfo.isValidLink(null));
    }

    @Test
    public void isValidLink_validLinks_true() {
        assertEquals(true, LinkInfo.isValidLink("https://www.youtube.com"));
        assertEquals(true, LinkInfo.isValidLink("http://www.youtube.com"));
        assertEquals(true, LinkInfo.isValidLink("https://www.imf.org"));
    }

    public boolean isDuplicate(String linkToCheck) {
        for (LinkInfo link : LinkInfo.linksList) {
            if (linkToCheck.equals(link.getLink())) {
                return true;
            }
        }
        return false;
    }

    @Test
    public void isDuplicate_duplicates_true() {
        linksList.add(new LinkInfo("https://www.youtube.com"));
        assertEquals(true, isDuplicate("https://www.youtube.com"));
    }

    @Test
    public void isDuplicate_notDuplicates_false() {
        linksList.add(new LinkInfo("https://www.youtube.com"));
        assertEquals(false, isDuplicate("https://www.youtube.co"));
    }

    @Test
    public void testAddLink() {
        String link = "https://www.reddit.com";
        LinkInfo.addLink(link);
        assertEquals("https://www.reddit.com", linksList.get(0).getLink());

        LinkInfo newLink = new LinkInfo(link);
        LinkInfo.addLink(newLink);
        assertEquals("https://www.reddit.com", newLink.getLink());
    }

    @Test
    public void deleteZoomLink_isInvalidIndex_exceptionThrown() {
        zoomLinksList.add(new ZoomLinkInfo("testlink", "cs1010"));
        zoomLinksList.add(new ZoomLinkInfo("testlink2", "cs2020"));
        assertThrows(IndexOutOfBoundsException.class, () -> {
            ZoomLinkInfo.deleteZoomLink(15);
        });
        zoomLinksList.clear();
    }
}

