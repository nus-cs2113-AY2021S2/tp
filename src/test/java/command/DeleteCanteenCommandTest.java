package command;

import canteens.Canteen;
import org.junit.jupiter.api.Test;
import ui.Ui;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeleteCanteenCommandTest {

    @Test
    public void execute_deleteExistingCanteen_success() {
        ArrayList<Canteen> canteens = new ArrayList<Canteen>();
        Ui ui = new Ui();
        canteens.add(new Canteen("canteen name"));
        assertEquals(1, canteens.size());
        DeleteCanteenCommand c = new DeleteCanteenCommand(0);
        c.execute(canteens, ui);
        assertEquals(0, canteens.size());
    }
}
