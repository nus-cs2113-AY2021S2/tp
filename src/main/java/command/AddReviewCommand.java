package command;

import canteens.Canteen;
import exceptions.DukeExceptions;
import reviews.Review;
import stores.Store;
import ui.Ui;

import java.util.ArrayList;

public class AddReviewCommand extends Command {
    protected int storeIndex;
    protected String description;
    protected double rating;

    public AddReviewCommand(int storeIndex) {
        this.storeIndex = storeIndex;
        try {
            Ui.enterReview();
            this.description = Ui.readCommand();
            Ui.enterRating();
            this.rating = Double.parseDouble(Ui.readCommand());
            Ui.reviewAdded();
        } catch (NullPointerException e) {
            System.out.println("Input cannot empty.");
        }
    }

    @Override
    public void execute(ArrayList<Canteen> canteens, Ui ui) throws DukeExceptions {
        Store currentStore = canteens.get(0).getStore(storeIndex);
        Review currentStoreReview = new Review(description,rating);
        currentStore.addReview(currentStoreReview);
    }

}
