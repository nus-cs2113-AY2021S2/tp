package command;

import canteens.Canteen;
import nusfoodreviews.NusFoodReviews;
import ui.Ui;

import java.util.ArrayList;
import java.util.Map;

public class HomeCommand extends Command {
    @Override
    public void execute(ArrayList<Canteen> canteens, Ui ui) {
        NusFoodReviews.resetAllIndexes();
    }
}
