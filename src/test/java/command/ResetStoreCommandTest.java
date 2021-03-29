package command;

import nusfoodreviews.NusFoodReviews;
import org.junit.jupiter.api.Test;
import ui.Ui;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ResetStoreCommandTest {

    @Test
    public void execute_resetIndexes_success() {
        NusFoodReviews nusFoodReviews = new NusFoodReviews("data/storage.txt");
        ResetStoreCommand c = new ResetStoreCommand();
        c.execute(new ArrayList<>(), new Ui());
        assertEquals(-1, nusFoodReviews.getCanteenIndex());
        assertEquals(-1, nusFoodReviews.getStoreIndex());
    }
}
