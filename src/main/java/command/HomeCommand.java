package command;

import canteens.Canteen;
import nusfoodreviews.NusFoodReviews;
import ui.Ui;

import java.util.ArrayList;

/**
 * Represents an executor that will return the user to the home page
 */
public class HomeCommand extends Command {

    NusFoodReviews nusFoodReviews;

    /**
     * Constructor of this class. Initializes necessary objects to interact with
     * @param nusFoodReviews The main class containing logic
     */
    public HomeCommand(NusFoodReviews nusFoodReviews) {
        this.nusFoodReviews = nusFoodReviews;
    }

    /**
     * Returns user to the home page
     * @param canteens ArrayList of canteens
     * @param ui Ui object that handles interaction with user
     */
    @Override
    public void execute(ArrayList<Canteen> canteens, Ui ui) {
        nusFoodReviews.resetCanteenStoreIndex();
    }
}
