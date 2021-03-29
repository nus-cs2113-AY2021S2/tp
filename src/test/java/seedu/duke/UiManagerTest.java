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
}