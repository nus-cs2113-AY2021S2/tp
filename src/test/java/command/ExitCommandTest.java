package command;

import canteens.Canteen;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import storage.Storage;
import ui.Ui;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ExitCommandTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void execute_null_goodbyeMessage() {
        ArrayList<Canteen> canteens = new ArrayList<>();
        Ui ui = new Ui();
        Command c = new ExitCommand();
        String expectedString = "-----------------------\r\n" +
                "Thank you for using our application! See you again!\r\n" +
                "-----------------------";
        c.execute(canteens, ui);
        assertEquals(expectedString, outputStreamCaptor.toString().trim());
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }
}