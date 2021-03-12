package seedu.igraduate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import seedu.igraduate.exception.IncorrectParameterCountException;
import seedu.igraduate.exception.InvalidCommandException;

public class ParserTest {
    @Test
    void parseCommand_emptyCommand_exceptionThrown() {
        String line = "";
        Exception exception = assertThrows(InvalidCommandException.class, () -> Parser.parseCommand(line));
        assertEquals("The command you have entered is incorrect. \nPlease double check and try again.",
                exception.getMessage());
    }

    @Test
    void executeAddCommand_tooManyParameters_exceptionThrown() {
        String line = "Add CS2113 -t core -c 4 hoi";
        String[] components = line.split(" ");
        Exception exception = assertThrows(IncorrectParameterCountException.class,
            () -> Parser.createAddCommand(components, components));
        assertEquals("The number of parameters"
                + " provided is incorrect. \nPlease double check and try again.", exception.getMessage());
    }

    @Test
    void executeDeleteCommand_tooFewParameters_exceptionThrown() {
        String line = "Delete";
        String[] components = line.split(" ");
        Exception exception = assertThrows(IncorrectParameterCountException.class,
            () -> Parser.createDeleteCommand(components));
        assertEquals("The number of parameters"
                + " provided is incorrect. \nPlease double check and try again.", exception.getMessage());
    }

    @Test
    void executeListCommand_invalidParameter_exceptionThrown() {
        String line = "done";
        Exception exception = assertThrows(IncorrectParameterCountException.class,
            () -> Parser.parseCommand(line));
        assertEquals("The number of parameters"
            + " provided is incorrect. \nPlease double check and try again.", exception.getMessage());

    }
}