package seedu.nurseschedules.parser;

import org.junit.jupiter.api.Test;
import seedu.duke.exceptions.nurseschedules.WrongInputsException;


import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ParserTest {

    @Test
    void testGetFirstWord() {
        Parser parser = new Parser();
        assertEquals("test", parser.getFirstWord("test get first word"));
    }

    @Test
    void testGetDetails() throws WrongInputsException {
        Parser parser = new Parser();
        String[] details;
        details = parser.getDetails("add test details padding");
        assertEquals("test", details[0]);
    }

    @Test
    void testFormatDate() throws ParseException, WrongInputsException {
        Parser parser = new Parser();
        String input = "add N1 P1 20032021";
        assertEquals("20/03/2021", parser.formatDate(input));
    }
}