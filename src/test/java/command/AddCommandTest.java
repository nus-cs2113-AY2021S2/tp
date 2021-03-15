package command;

import canteens.Canteen;
import exceptions.DukeExceptions;
import org.junit.jupiter.api.Test;
import reviews.Review;
import stores.Store;
import ui.Ui;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddCommandTest {
    private ArrayList<Canteen> canteens = new ArrayList<>();

    AddCommandTest() {
        canteens.add(new Canteen("YIH"));
        canteens.get(0).addStore("Thai");
    }

    @Test
    public void addCommandIntoList() throws DukeExceptions {
        AddCommand command = new AddCommand(0, "I loved it",3.5);
        command.execute(canteens, new Ui());
        assertEquals(canteens.get(0).getStore(0).getReviews().get(0).toString(), "I loved it");
    }

}
