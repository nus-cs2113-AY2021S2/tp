package seedu.duke;

import org.junit.jupiter.api.Test;
import seedu.duke.ui.UiManager;

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

        String lineSeparator = System.lineSeparator();
        String divider = "--------------------------------------------------------------------------";
        String logo =  " /$$   /$$ /$$   /$$  /$$$$$$  /$$      /$$\n"
                + "| $$$ | $$| $$  | $$ /$$__  $$| $$$    /$$$\n"
                + "| $$$$| $$| $$  | $$| $$  \\__/| $$$$  /$$$$  /$$$$$$  /$$$$$$$$  /$$$$$$\n"
                + "| $$ $$ $$| $$  | $$|  $$$$$$ | $$ $$/$$ $$ |____  $$|____ /$$/ /$$__  $$\n"
                + "| $$  $$$$| $$  | $$ \\____  $$| $$  $$$| $$  /$$$$$$$   /$$$$/ | $$$$$$$$\n"
                + "| $$\\  $$$| $$  | $$ /$$  \\ $$| $$\\  $ | $$ /$$__  $$  /$$__/  | $$_____/\n"
                + "| $$ \\  $$|  $$$$$$/|  $$$$$$/| $$ \\/  | $$|  $$$$$$$ /$$$$$$$$|  $$$$$$$\n"
                + "|__/  \\__/ \\______/  \\______/ |__/     |__/ \\_______/|________/ \\_______/";
        assertEquals(divider + lineSeparator + logo + lineSeparator + divider, outContent.toString().trim());
    }

    @Test
    void showByeMessage_expectByeMessage() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        UiManager ui = new UiManager();
        ui.showByeMessage();

        String lineSeparator = System.lineSeparator();
        String divider = "--------------------------------------------------------------------------";
        String byeMessage = "Bye. Hope to see you again soon!";
        assertEquals(byeMessage + lineSeparator + divider, outContent.toString().trim());
    }

    @Test
    void showGreetMessage_expectGreetMessage() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        UiManager ui = new UiManager();
        ui.showGreetMessage();

        String lineSeparator = System.lineSeparator();
        String divider = "--------------------------------------------------------------------------";
        String greetingMessage = "Hello! Welcome to NUSMaze" + lineSeparator
                + "Where do you want to go today?";
        assertEquals(greetingMessage + lineSeparator + divider, outContent.toString().trim());
    }

    @Test
    void showHelpMessage_expectHelpMessage() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        UiManager ui = new UiManager();
        ui.showHelpMessage();

        String lineSeparator = System.lineSeparator();
        String divider = "--------------------------------------------------------------------------";
        String spacing = "      ";
        String helpMessage = "1. go:\n"
                + spacing + "finds the route to go from one block to another\n"
                + "2. history:\n"
                + spacing + "lists past 10 route searches\n"
                + "3. add note LOCATION/DESCRIPTION:\n"
                + spacing + "adds and tags a note to a particular location\n"
                + "4. list notes LOCATION:\n"
                + spacing + "list notes tagged to the given location\n"
                + "5. delete note LOCATION/NOTE INDEX:\n"
                + spacing + "deletes notes based on index number tagged to the given location";
        assertEquals(helpMessage + lineSeparator + divider, outContent.toString().trim());
    }
}