package command;

import canteens.Canteen;
import nusfoodreviews.NusFoodReviews;
import ui.Ui;

import java.util.ArrayList;

public class ResetStoreCommand extends Command {
    @Override
    public void execute(ArrayList<Canteen> canteens, Ui ui) {
        NusFoodReviews.resetStoreIndex();
    }
}
