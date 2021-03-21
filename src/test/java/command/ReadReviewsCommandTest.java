package command;

import canteens.Canteen;
import org.junit.jupiter.api.Test;
import reviews.Review;
import stores.Store;
import ui.Ui;


import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReadReviewsCommandTest {
    @Test
    public void testReadCommand() {
        Store store = new Store("Fish rice stall");
        ArrayList<Review> reviews = store.getReviews();
        for (Review review: reviews) {
            System.out.println(review.toString());
        }
        assertEquals(reviews, store.getReviews());


    }

}