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

class DisplayCommandTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void execute_canteenFromTestData_print() {
        Storage storage = new Storage("data/testStorage.txt");
        ArrayList<Canteen> canteens = storage.load();
        Ui ui = new Ui();
        Command c = new DisplayCommand();
        String expectedString = "Here's a list of the stores in the canteen: The Deck\r\n" +
                "1.chicken rice stall\r\n" +
                "2.Fish rice stall";
        c.execute(canteens, ui);
        assertEquals(expectedString, outputStreamCaptor.toString().trim());
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }
}