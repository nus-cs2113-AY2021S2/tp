package command;

import canteens.Canteen;
import reviews.Review;
import stores.Store;
import ui.Ui;


import java.util.ArrayList;


public class ReadReviewsCommand extends Command {
    private Store store;
    private static double ratingSum = 0;
    private static int ratingCount = 0;
    private static double averageRating = 0;

    public ReadReviewsCommand(Store store) {
        this.store = store;
    }


    @Override
    public void execute(ArrayList<Canteen> canteens, Ui ui) {
        ArrayList<Review> reviews = store.getReviews();
        for (Review rating : reviews) {
            ratingSum = ratingSum + rating.getRating();
            ratingCount++;
        }
        averageRating = ratingSum / ratingCount;
        ui.showReviews(store.getStoreName(), reviews,averageRating);
    }
}
