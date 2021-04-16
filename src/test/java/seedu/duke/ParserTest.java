package seedu.duke;

import org.junit.jupiter.api.Test;
import seedu.duke.command.Command;
import seedu.duke.command.routecommand.GoCommand;
import seedu.duke.command.historycommand.RepeatHistoryCommand;
import seedu.duke.command.historycommand.ShowHistoryCommand;
import seedu.duke.command.historycommand.ClearHistoryCommand;
import seedu.duke.command.notecommand.ShowNoteCommand;
import seedu.duke.command.notecommand.AddNoteCommand;
import seedu.duke.command.notecommand.DeleteNoteCommand;
import seedu.duke.command.generalcommand.ByeCommand;
import seedu.duke.command.generalcommand.HelpCommand;
import seedu.duke.exception.InvalidCommandException;
import seedu.duke.parser.Parser;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ParserTest {

    @Test
    void prepareForCommandExecution_go_expectGoCommand() throws InvalidCommandException {
        Command command = Parser.prepareForCommandExecution("go");
        assertTrue(command instanceof GoCommand);
    }

    @Test
    void prepareForCommandExecution_history_expectHistoryCommand() throws InvalidCommandException {
        Command command = Parser.prepareForCommandExecution("history");
        assertTrue(command instanceof ShowHistoryCommand);
    }

    @Test
    void prepareForCommandExecution_repeat_expectRepeatCommand() throws InvalidCommandException {
        Command command = Parser.prepareForCommandExecution("repeat history");
        assertTrue(command instanceof RepeatHistoryCommand);
    }

    @Test
    void prepareForCommandExecution_clearhistory_expectClearHistoryCommand() throws InvalidCommandException {
        Command command = Parser.prepareForCommandExecution("clear history");
        assertTrue(command instanceof ClearHistoryCommand);
    }

    @Test
    void prepareForCommandExecution_listnotes_expectListNoteCommand() throws InvalidCommandException {
        Command command = Parser.prepareForCommandExecution("show note");
        assertTrue(command instanceof ShowNoteCommand);
    }

    @Test
    void prepareForCommandExecution_addnote_expectAddNoteCommand() throws InvalidCommandException {
        Command command = Parser.prepareForCommandExecution("add note");
        assertTrue(command instanceof AddNoteCommand);
    }

    @Test
    void prepareForCommandExecution_deletenote_expectDeleteNoteCommand() throws InvalidCommandException {
        Command command = Parser.prepareForCommandExecution("delete note");
        assertTrue(command instanceof DeleteNoteCommand);
    }

    @Test
    void prepareForCommandExecution_bye_expectByeCommand() throws InvalidCommandException {
        Command command = Parser.prepareForCommandExecution("bye");
        assertTrue(command instanceof ByeCommand);
    }

    @Test
    void prepareForCommandExecution_help_expectHelpCommand() throws InvalidCommandException {
        Command command = Parser.prepareForCommandExecution("help");
        assertTrue(command instanceof HelpCommand);
    }

    @Test
    void prepareForCommandExecution_unknown_expectException() {
        assertThrows(InvalidCommandException.class,
            () -> Parser.prepareForCommandExecution("unknown command"));
    }
}