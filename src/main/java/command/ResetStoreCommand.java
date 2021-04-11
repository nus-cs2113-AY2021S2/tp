package command;

import canteens.Canteen;
import nusfoodreviews.NusFoodReviews;
import ui.Ui;

import java.util.ArrayList;

/**
 * Represents an executor that will reset the stores chosen by the user
 */
public class ResetStoreCommand extends Command {
    NusFoodReviews nusFoodReviews;

    /**
     * Constructor of this class. Initializes necessary objects to interact with
     * @param nusFoodReviews The main class containing logic
     */
    public ResetStoreCommand(NusFoodReviews nusFoodReviews) {
        this.nusFoodReviews = nusFoodReviews;
    }

    /**
     * Resets the store index chosen by the user
     * @param canteens ArrayList of canteens
     * @param ui Ui object that handles interaction with user
     */
    @Override
    public void execute(ArrayList<Canteen> canteens, Ui ui) {
        nusFoodReviews.resetStoreIndex();
    }
}
