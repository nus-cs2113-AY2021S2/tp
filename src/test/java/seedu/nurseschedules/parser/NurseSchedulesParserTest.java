package seedu.nurseschedules.parser;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.fail;
import seedu.exceptions.nurseschedules.WrongInputsException;
import seedu.logic.parser.NurseSchedulesParser;


import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NurseSchedulesParserTest {

    @Test
    void testGetFirstWord() {
        NurseSchedulesParser parser = new NurseSchedulesParser();
        assertEquals("test", parser.getFirstWord("test get first word"));
    }

    @Test
    void testGetDetails() throws WrongInputsException {
        NurseSchedulesParser parser = new NurseSchedulesParser();
        String[] details;
        details = parser.getDetails("add test details padding");
        assertEquals("test", details[0]);
    }

    @Test
    void testGetDetails_WrongInputs() {
        NurseSchedulesParser parser = new NurseSchedulesParser();
        String[] details;
        try {
            details = parser.getDetails("wrong");
            assertEquals("wrong", details[0]);
            fail();
        } catch (Exception e) {
            assertEquals("OOPS! Please check to see if your command is properly formatted!", e.getMessage());
        }
    }

    @Test
    void testFormatDate() throws ParseException {
        NurseSchedulesParser parser = new NurseSchedulesParser();
        String input = "20032021";
        assertEquals("20/03/2021", parser.formatDate(input));
    }

    @Test
    void testFormatDate_WrongDate() {
        String input = "20003020210";
        try {
            String datetime = NurseSchedulesParser.formatDate(input);
        } catch (ParseException e) {
            assertEquals(null, e.getMessage());
        }
    }
}