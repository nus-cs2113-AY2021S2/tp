package command;

import canteens.Canteen;
import exceptions.DukeExceptions;
import org.junit.jupiter.api.Test;
import ui.Ui;

import java.util.ArrayList;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddCanteenCommandTest {

    @Test
    public void execute_validCanteenName_success() {
        ArrayList<Canteen> canteens = new ArrayList<>();
        Ui ui = new Ui();
        String canteenName = "Valid Canteen Name";
        AddCanteenCommand c = new AddCanteenCommand(canteenName);
        c.execute(canteens, ui);
        assertEquals(canteens.get(0).getCanteenName(), canteenName);
    }

}
