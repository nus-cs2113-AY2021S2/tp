package command;

import canteens.Canteen;
import exceptions.DukeExceptions;
import reviews.Review;
import stores.Store;
import ui.Ui;

import java.util.ArrayList;

public class AddReviewCommand extends Command {
    private Store store;
    private Review review;

    public AddReviewCommand(Store store, Review review) {
        this.store = store;
        this.review = review;
    }

    @Override
    public void execute(ArrayList<Canteen> canteens, Ui ui) throws DukeExceptions {
        store.addReview(review);
        Ui.reviewAdded();
    }

}
