package seedu.duke;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CommandManagerTest {
    @Test
    void getCommandType_go() {
        CommandManager cm = new CommandManager("go");
        Assertions.assertEquals("GoCommand", cm.getCommandType().toString());
    }

    @Test
    void getCommandType_go_with_trailing_space_and_caps() {
        CommandManager cm = new CommandManager("GO ");
        Assertions.assertEquals("GoCommand", cm.getCommandType().toString());
    }

    @Test
    void getCommandType_go_with_leading_space_and_caps() {
        CommandManager cm = new CommandManager(" GO");
        Assertions.assertEquals("GoCommand", cm.getCommandType().toString());
    }

    @Test
    void getCommandType_go_with_surrounding_space_and_caps() {
        CommandManager cm = new CommandManager(" GO ");
        Assertions.assertEquals("GoCommand", cm.getCommandType().toString());
    }

    @Test
    void getCommandType_history() {
        CommandManager cm = new CommandManager("history");
        Assertions.assertEquals("ShowHistoryCommand", cm.getCommandType().toString());
    }

    @Test
    void getCommandType_clear_history() {
        CommandManager cm = new CommandManager("clear history");
        Assertions.assertEquals("ClearHistoryCommand", cm.getCommandType().toString());
    }

    @Test
    void getCommandType_add_note() {
        CommandManager cm = new CommandManager("add note");
        Assertions.assertEquals("AddNoteCommand", cm.getCommandType().toString());
    }

    @Test
    void getCommandType_delete_note() {
        CommandManager cm = new CommandManager("delete note");
        Assertions.assertEquals("DeleteNoteCommand", cm.getCommandType().toString());
    }

    @Test
    void getCommandType_notes() {
        CommandManager cm = new CommandManager("notes");
        Assertions.assertEquals("DisplayNotesCommand", cm.getCommandType().toString());
    }

    @Test
    void getCommandType_bye() {
        CommandManager cm = new CommandManager("bye");
        Assertions.assertEquals("ByeCommand", cm.getCommandType().toString());
    }

    @Test
    void getCommandType_invalid() {
        CommandManager cm = new CommandManager("Any other commands");
        Assertions.assertEquals("InvalidCommand", cm.getCommandType().toString());
    }
}