package command;

import canteens.Canteen;
import exceptions.DukeExceptions;
import reviews.Review;
import stores.Store;
import ui.Ui;

import java.util.ArrayList;

public class AddReviewCommand extends Command {
    private Store store;

    public AddReviewCommand(Store store) {
        this.store = store;
    }

    @Override
    public void execute(ArrayList<Canteen> canteens, Ui ui) throws DukeExceptions {
        try {
            getReviewFromUser(ui);
        } catch (NumberFormatException e) {
            throw new DukeExceptions("Review not added. Please input your review in proper format!");
        }
    }

    public void getReviewFromUser(Ui ui) throws NumberFormatException {
        String description;
        double rating;
        String line;
        ui.enterReview();
        line = ui.readCommand();
        if (line.equals("cancel")) {
            ui.reviewNotAdded();
            return;
        } else {
            description = line;
        }
        ui.enterRating();
        line = ui.readCommand();
        if (line.equals("cancel")) {
            ui.reviewNotAdded();
            return;
        } else {
            rating = Double.parseDouble(line);
        }
        store.addReview(new Review(description, rating));
        ui.reviewAdded();
    }
}
