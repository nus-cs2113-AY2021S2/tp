package seedu.nurseschedules.parser;

import org.junit.jupiter.api.Test;
import seedu.duke.exceptions.nurseschedules.WrongInputsException;
import seedu.duke.menuparser.NurseSchedulesParser;


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
    void testFormatDate() throws ParseException, WrongInputsException {
        NurseSchedulesParser parser = new NurseSchedulesParser();
        String input = "20032021";
        assertEquals("20/03/2021", parser.formatDate(input));
    }
}