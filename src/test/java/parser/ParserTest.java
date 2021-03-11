package parser;

import command.Command;
import command.DisplayCommand;
import command.ExitCommand;
import exceptions.DukeExceptions;
import org.junit.jupiter.api.Test;
import seedu.duke.Duke;

import static org.junit.jupiter.api.Assertions.*;

class ParserTest {

    @Test
    public void parse_list_displayCommand() throws DukeExceptions {
        Parser parser = new Parser();
        Command c = parser.parse("list");
        assertTrue(c instanceof DisplayCommand);
    }

    @Test
    public void parse_exit_displayCommand() throws DukeExceptions {
        Parser parser = new Parser();
        Command c = parser.parse("exit");
        assertTrue(c instanceof ExitCommand);
    }

    @Test
    public void parse_faultyCommand_throwException() throws DukeExceptions {
        Parser parser = new Parser();
        assertThrows(DukeExceptions.class, () -> {
            Command c = parser.parse("RandomInput");
        });
    }
}