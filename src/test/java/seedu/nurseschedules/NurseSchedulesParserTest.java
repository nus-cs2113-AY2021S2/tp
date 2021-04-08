package seedu.nurseschedules;

import org.junit.jupiter.api.Test;
import seedu.exceptions.ExcessInputException;
import seedu.exceptions.InsufficientInputException;
import seedu.exceptions.InvalidDateException;
import seedu.exceptions.NoInputException;
import seedu.exceptions.nurseschedules.WrongInputsException;
import seedu.exceptions.IllegalCharacterException;
import seedu.logic.parser.NurseSchedulesParser;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;

class NurseSchedulesParserTest {

    @Test
    void testGetFirstWord() {
        NurseSchedulesParser parser = new NurseSchedulesParser();
        assertEquals("test", parser.getFirstWord("test get first word"));
    }

    @Test
    void testGetDetails() throws WrongInputsException, NoInputException, InsufficientInputException, ExcessInputException, IllegalCharacterException, InvalidDateException {
        NurseSchedulesParser parser = new NurseSchedulesParser();
        String[] details;
        details = parser.getDetails("add test details padding", "add");
        assertEquals("test", details[0]);
    }

    @Test
    void testGetDetails_WrongInputs() {
        NurseSchedulesParser parser = new NurseSchedulesParser();
        String[] details;
        try {
            details = parser.getDetails("wrong", "wrong");
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
        assertEquals("20/03/2021", NurseSchedulesParser.formatDate(input));
    }

    @Test
    void testFormatDate_WrongDate() {
        String input = "20003020210";
        try {
            String datetime = NurseSchedulesParser.formatDate(input);
        } catch (ParseException e) {
            assertNull(e.getMessage());
        }
    }
}