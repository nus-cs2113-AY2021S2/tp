package seedu.fridgefriend.utilities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import seedu.fridgefriend.command.ByeCommand;
import seedu.fridgefriend.command.ListCommand;
import seedu.fridgefriend.exception.EmptyDescriptionException;
import seedu.fridgefriend.exception.InvalidInputException;

// Solution below adapted from https://github.com/se-edu/addressbook-level2/blob/157fcf19c6b73289dc4cc7b2dd1152bc2b8e197a/test/java/seedu/addressbook/parser/ParserTest.java
public class ParserTest {

    @Test
    public void parse_emptyInput_InvalidInputException() {
        assertThrows(InvalidInputException.class, () -> {
            Parser.parseInput("");
        });
    }

    @Test
    public void parse_listCommand_parsedCorrectly() {
        try {
            assertEquals(Parser.getCommand("list").getClass(), ListCommand.class);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void parse_byeCommand_parsedCorrectly() {
        try {
            assertEquals(Parser.getCommand("bye").getClass(), ByeCommand.class);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void parse_addCommandNoArgs_EmptyDescriptionException() {
        assertThrows(EmptyDescriptionException.class, () -> {
            Parser.getCommand("add");
        });
    }

    @Test
    public void parse_addCommandMissingArgs_InvalidInputException() {
        assertThrows(InvalidInputException.class, () -> {
            Parser.getCommand("add /cat meat");
        });
    }

    @Test
    public void parse_removeCommandNoArgs_EmptyDescriptionException() {
        assertThrows(EmptyDescriptionException.class, () -> {
            Parser.getCommand("remove");
        });
    }

    /*
    @Test
    public void parse_removeCommandAlphabeticalArgs_InvalidIndexException() {
        assertThrows(InvalidIndexException.class, () -> {
            Parser.getCommand("remove abc");
        });
    }

    @Test
    public void parse_removeCommandArgOutOfBounds_InvalidIndexException() {
        assertThrows(InvalidIndexException.class, () -> {
            Command command = Parser.getCommand("remove -1");
            command.execute();
        });
        assertThrows(InvalidIndexException.class, () -> {
            Command command = Parser.getCommand("remove 10000");
            command.execute();
        });
    }
   */

    @Test
    public void parse_searchCommandNoArg_EmptyDescriptionException() {
        assertThrows(EmptyDescriptionException.class, () -> {
            Parser.getCommand("search");
        });
    }
    
}
