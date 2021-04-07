package seedu.fridgefriend.utilities;

//@@author kwokyto
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import seedu.fridgefriend.command.ByeCommand;
import seedu.fridgefriend.command.ListCommand;
import seedu.fridgefriend.exception.EmptyDescriptionException;
import seedu.fridgefriend.exception.InvalidInputException;
import seedu.fridgefriend.exception.InvalidQuantityException;

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

    //@@author Vinci-Hu
    @Test
    public void parse_removeCommandNoArgs_EmptyDescriptionException() {
        assertThrows(EmptyDescriptionException.class, () -> {
            Parser.getCommand("remove");
        });
    }

    @Test
    public void parse_searchCommandNoArg_EmptyDescriptionException() {
        assertThrows(EmptyDescriptionException.class, () -> {
            Parser.getCommand("search");
        });
    }

    //@@author SimJJ96
    @Test
    public void parse_largeQuantity_InvalidQuantityException() {
        assertThrows(InvalidQuantityException.class, () -> {
            Parser.parseIntegerQuantity("1000000000");
        });
    }

    @Test
    public void parse_negativeQuantity_InvalidQuantityException() {
        assertThrows(InvalidQuantityException.class, () -> {
            Parser.parseIntegerQuantity("-1000");
        });
    }

}
