package seedu.duke;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import seedu.duke.link.LinkInfo;

public class LinkTest {

    @Test
    public void isValidLink_invalidLinks_false() {
        assertEquals(false, LinkInfo.isValidLink("https://ww.youtube.com"));
        assertEquals(false, LinkInfo.isValidLink("https:/www.youtube.com"));
    }

    @Test
    public void isValidLink_validLinks_true() {
        assertEquals(true, LinkInfo.isValidLink("https://www.youtube.com"));
        assertEquals(true, LinkInfo.isValidLink("http://www.youtube.com"));
        assertEquals(true, LinkInfo.isValidLink("https://www.imf.org"));
    }

}
