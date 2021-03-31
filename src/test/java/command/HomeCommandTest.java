package command;

import nusfoodreviews.NusFoodReviews;
import org.junit.jupiter.api.Test;
import ui.Ui;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class HomeCommandTest {
    @Test
    public void execute_resetIndexes_success() {
        NusFoodReviews nusFoodReviews = new NusFoodReviews("data/storage.txt");
        HomeCommand c = new HomeCommand(nusFoodReviews);
        c.execute(new ArrayList<>(), new Ui());
        assertEquals(-1, nusFoodReviews.getCanteenIndex());
        assertEquals(-1, nusFoodReviews.getStoreIndex());
    }
}