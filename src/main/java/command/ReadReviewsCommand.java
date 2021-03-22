package command;

import canteens.Canteen;
import reviews.Review;
import stores.Store;
import ui.Ui;


import java.util.ArrayList;


public class ReadReviewsCommand extends Command {
    public int index;
    private static double ratingSum = 0;
    private static int ratingCount = 0;
    private static double averageRating = 0;

    public ReadReviewsCommand(int index) {
        this.index = index;
    }


    @Override
    public void execute(ArrayList<Canteen> canteens, Ui ui) {
        Store currentStore = canteens.get(0).getStore(index);
        ArrayList<Review> reviews = currentStore.getReviews();
        for (Review rating : reviews) {
            ratingSum = ratingSum + rating.getRating();
            ratingCount++;
        }
        averageRating = ratingSum / ratingCount;
        ui.showReviews(currentStore.getStoreName(), reviews,averageRating);
    }
}
