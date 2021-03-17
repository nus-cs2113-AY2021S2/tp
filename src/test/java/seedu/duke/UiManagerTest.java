package seedu.duke;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UiManagerTest {

    @Test
    void showLogo_expectLogo() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        UiManager ui = new UiManager();
        ui.showLogo();

        String NEWLINE = System.lineSeparator();
        String DIVIDER = "--------------------------------------------------------------------------";
        String LOGO =  " /$$   /$$ /$$   /$$  /$$$$$$  /$$      /$$\n"
                + "| $$$ | $$| $$  | $$ /$$__  $$| $$$    /$$$\n"
                + "| $$$$| $$| $$  | $$| $$  \\__/| $$$$  /$$$$  /$$$$$$  /$$$$$$$$  /$$$$$$\n"
                + "| $$ $$ $$| $$  | $$|  $$$$$$ | $$ $$/$$ $$ |____  $$|____ /$$/ /$$__  $$\n"
                + "| $$  $$$$| $$  | $$ \\____  $$| $$  $$$| $$  /$$$$$$$   /$$$$/ | $$$$$$$$\n"
                + "| $$\\  $$$| $$  | $$ /$$  \\ $$| $$\\  $ | $$ /$$__  $$  /$$__/  | $$_____/\n"
                + "| $$ \\  $$|  $$$$$$/|  $$$$$$/| $$ \\/  | $$|  $$$$$$$ /$$$$$$$$|  $$$$$$$\n"
                + "|__/  \\__/ \\______/  \\______/ |__/     |__/ \\_______/|________/ \\_______/\n";
        assertEquals(DIVIDER + NEWLINE + LOGO + DIVIDER, outContent.toString().trim());
    }

    @Test
    void showByeMessage_expectByeMessage() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        UiManager ui = new UiManager();
        ui.showByeMessage();

        String LINE_SEPARATOR = System.lineSeparator();
        String DIVIDER = "--------------------------------------------------------------------------";
        String BYE_MESSAGE = "Bye. Hope to see you again soon!";
        assertEquals( BYE_MESSAGE + LINE_SEPARATOR + DIVIDER, outContent.toString().trim());
    }

    @Test
    void showGreetMessage_expectGreetMessage() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        UiManager ui = new UiManager();
        ui.showGreetMessage();

        String LINE_SEPARATOR = System.lineSeparator();
        String DIVIDER = "--------------------------------------------------------------------------";
        String GREETING_MESSAGE = "Hello! Welcome to NUSMaze" + LINE_SEPARATOR
                + "Where do you want to go today?";
        assertEquals( GREETING_MESSAGE + LINE_SEPARATOR + DIVIDER, outContent.toString().trim());
    }

    @Test
    void showHelpMessage_expectHelpMessage() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        UiManager ui = new UiManager();
        ui.showHelpMessage();

        String LINE_SEPARATOR = System.lineSeparator();
        String DIVIDER = "--------------------------------------------------------------------------";
        String SPACING = "      ";
        String HELP_MESSAGE = "1. go:\n" +
                SPACING + "finds the route to go from one block to another\n" +
                "2. history:\n" +
                SPACING + "lists past 10 route searches\n" +
                "3. add note LOCATION/DESCRIPTION:\n" +
                SPACING + "adds and tags a note to a particular location\n" +
                "4. list notes LOCATION:\n" +
                SPACING + "list notes tagged to the given location\n" +
                "5. delete note LOCATION/NOTE INDEX:\n" +
                SPACING + "deletes notes based on index number tagged to the given location\n";
        assertEquals( HELP_MESSAGE + LINE_SEPARATOR + DIVIDER, outContent.toString().trim());
    }
}