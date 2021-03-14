package parser;

import command.Command;
import command.DisplayMenusCommand;
import command.DisplayStoresCommand;
import command.ExitCommand;
import command.ReadCommand;
import exceptions.DukeExceptions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


class ParserTest {

    private int maxStores = 1;

    @Test
    public void parse_list_displayCommand() throws DukeExceptions {
        Parser parser = new Parser();
        Command c = parser.parsePublicUserCommand("list", maxStores);
        assertTrue(c instanceof DisplayStoresCommand);
    }

    @Test
    public void parse_menu_success() throws DukeExceptions {
        Parser parser = new Parser();
        Command c = parser.parsePublicUserCommand("menu 1", maxStores);
        assertTrue(c instanceof DisplayMenusCommand);
    }

    @Test
    public void parse_menuExceedStoreIndex_exceptionThrown() {
        Parser parser = new Parser();
        try {
            Command c = parser.parsePublicUserCommand("menu 5", maxStores);
        } catch (Exception e) {
            assertEquals("Invalid index! Please enter a valid index for your 'menu' command.", e.getMessage());
        }
    }

    @Test
    public void parse_menuNoNumbers_exceptionThrown() {
        Parser parser = new Parser();
        try {
            Command c = parser.parsePublicUserCommand("menu abc", maxStores);
        } catch (Exception e) {
            assertEquals("Invalid index! Please enter a valid index for your 'menu' command.", e.getMessage());
        }
    }

    @Test
    public void parse_exit_displayCommand() throws DukeExceptions {
        Parser parser = new Parser();
        Command c = parser.parsePublicUserCommand("exit", maxStores);
        assertTrue(c instanceof ExitCommand);
    }

    @Test
    public void parse_faultyCommand_throwException() {
        Parser parser = new Parser();
        assertThrows(DukeExceptions.class, () -> {
            Command c = parser.parsePublicUserCommand("RandomInput", maxStores);
        });
    }

    @Test
    public void parse_read_displayCommand() throws DukeExceptions {
        Parser parser = new Parser();
        Command c = parser.parsePublicUserCommand("read 1", maxStores);
        assertTrue(c instanceof ReadCommand);
    }

    @Test
    public void parse_readIndexExceedReviewNo_exceptionThrown() {
        Parser parser = new Parser();
        try {
            Command c = parser.parsePublicUserCommand("read 5", maxStores);
        } catch (Exception e) {
            assertEquals("Invalid index! Please enter a valid index for your 'read' command.", e.getMessage());
        }
    }

    @Test
    public void parse_readIndexNoNumbers_exceptionThrown() {
        Parser parser = new Parser();
        try {
            Command c = parser.parsePublicUserCommand("read hi", maxStores);
        } catch (Exception e) {
            assertEquals("Invalid index! Please enter a valid index for your 'read' command.", e.getMessage());
        }
    }


}