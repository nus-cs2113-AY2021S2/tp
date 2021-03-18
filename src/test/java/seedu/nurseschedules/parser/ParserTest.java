package seedu.nurseschedules.parser;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParserTest {

    @Test
    void testGetFirstWord() {
        Parser parser = new Parser();
        assertEquals("test", parser.getFirstWord("test get first word"));
    }

    @Test
    void getDetails() {
        Parser parser = new Parser();
        String details[] = new String[3];
        details = parser.getDetails("add test details padding");
        assertEquals(details[0], "test");
    }
}