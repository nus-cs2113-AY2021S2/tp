package seedu.nurseschedules.parser;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ParserTest {

    @Test
    void testGetFirstWord() {
        Parser parser = new Parser();
        assertEquals("test", parser.getFirstWord("test get first word"));
    }

    @Test
    void getDetails() {
        Parser parser = new Parser();
        String[] details;
        details = parser.getDetails("add test details padding");
        assertEquals(details[0], "test");
    }
}