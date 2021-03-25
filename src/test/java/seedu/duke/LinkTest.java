package seedu.duke;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.duke.link.LinkInfo.linksList;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import seedu.duke.link.LinkInfo;
import seedu.duke.link.ZoomLinkInfo;

public class LinkTest {

    @Test
    public void isValidLink_invalidLinks_false() {
        assertEquals(false, LinkInfo.isValidLink("https://ww.youtube.com"));
        assertEquals(false, LinkInfo.isValidLink("https:/www.youtube.com"));
        assertEquals(false, LinkInfo.isValidLink(null));
    }

    @Test
    public void isValidLink_validLinks_true() {
        assertEquals(true, LinkInfo.isValidLink("https://www.youtube.com"));
        assertEquals(true, LinkInfo.isValidLink("http://www.youtube.com"));
        assertEquals(true, LinkInfo.isValidLink("https://www.imf.org"));
    }

    @Test
    public void testLinkConstructorsAndGetters() {
        LinkInfo link = new LinkInfo("https://www.reddit.com");
        assertEquals("https://www.reddit.com", link.getLink());
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
    public void testDeleteLink() {
        ArrayList<LinkInfo> linksList = new ArrayList<>();
        linksList.add(new LinkInfo("https://www.reddit.com"));
        LinkInfo.deleteLink(0);
        assertEquals("https://www.reddit.com", linksList.get(0).getLink());
    }

    @Test
    public void testZoomLinkConstructorsAndGetters() {
        ZoomLinkInfo link1 = new ZoomLinkInfo(
                "https://nus-sg.zoom.us/j/82190325074?pwd=M2NjZTRtQVpRc0loMnVIaUpsRU5TZz09",
                "cs2101", "secret");
        assertEquals("https://nus-sg.zoom.us/j/82190325074?pwd=M2NjZTRtQVpRc0loMnVIaUpsRU5TZz09",
                link1.getDescription());
        assertEquals("cs2101", link1.getModuleCode());
        assertEquals("secret", link1.getPassword());

        ZoomLinkInfo link2 = new ZoomLinkInfo(
                "https://nus-sg.zoom.us/j/87226556676?pwd=aDNXWkNtRWRGdFM0SHFPQnpJM2gzUT09",
                "cs2113t");
        assertEquals("https://nus-sg.zoom.us/j/87226556676?pwd=aDNXWkNtRWRGdFM0SHFPQnpJM2gzUT09",
                link2.getDescription());
        assertEquals("cs2113t", link2.getModuleCode());
    }

    @Test
    public void addZoomLink_invalidInput_exceptionThrown() {
        try {
            String instruction = "https://nus-sg.zoom.us/j/87226556676?pwd=aDNXWkNtRWRGdFM0SHFPQnpJM2gzUT09";
            String[] words = instruction.split(" ");
            ZoomLinkInfo.addZoomLink(words[0], words[1]);
        } catch (ArrayIndexOutOfBoundsException e) {
            assertEquals("Index 1 out of bounds for length 1", e.getMessage());
        }
    }

    @Test
    public void testAddZoomLink() {
        ZoomLinkInfo link1 = new ZoomLinkInfo(
                "https://nus-sg.zoom.us/j/82190325074?pwd=M2NjZTRtQVpRc0loMnVIaUpsRU5TZz09",
                "cs2101", "secret");
        ArrayList<ZoomLinkInfo> zoomLinksList = new ArrayList<>();
        zoomLinksList.add(link1);
        assertEquals("secret", zoomLinksList.get(0).getPassword());
        assertEquals("cs2101", zoomLinksList.get(0).getModuleCode());
        assertEquals("https://nus-sg.zoom.us/j/82190325074?pwd=M2NjZTRtQVpRc0loMnVIaUpsRU5TZz09", zoomLinksList.get(0).getDescription());
    }


}
