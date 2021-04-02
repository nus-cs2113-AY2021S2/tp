package command;

import canteens.Canteen;
import exceptions.DukeExceptions;
import org.junit.jupiter.api.Test;
import ui.Ui;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddCanteenCommandTest {

    @Test
    public void execute_validCanteenName_success() throws IOException {
        String canteenName = "Valid Canteen Name";

        InputStream sysInBackup = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream(canteenName.getBytes());
        System.setIn(in);

        ArrayList<Canteen> canteens = new ArrayList<>();
        Ui ui = new Ui();

        AddCanteenCommand c = new AddCanteenCommand("data/storage.txt");
        c.execute(canteens, ui);
        assertEquals(canteens.get(0).getCanteenName(), canteenName);
    }

}
