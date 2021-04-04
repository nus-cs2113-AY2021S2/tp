package command;

import nusfoodreviews.NusFoodReviews;
import org.junit.jupiter.api.Test;
import ui.Ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HomeCommandTest {
    @Test
    public void execute_resetIndexes_success() throws IOException {

        InputStream inputStream = NusFoodReviews.class.getClassLoader().getResourceAsStream("storage.txt");
        InputStreamReader streamReader = new InputStreamReader(inputStream);
        BufferedReader reader = new BufferedReader(streamReader);

        NusFoodReviews nusFoodReviews = new NusFoodReviews(reader);
        HomeCommand c = new HomeCommand(nusFoodReviews);
        c.execute(new ArrayList<>(), new Ui());
        assertEquals(-1, nusFoodReviews.getCanteenIndex());
        assertEquals(-1, nusFoodReviews.getStoreIndex());
    }
}