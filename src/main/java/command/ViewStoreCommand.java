package command;

import canteens.Canteen;
import exceptions.DukeExceptions;
import nusfoodreviews.NusFoodReviews;
import ui.Ui;

import java.io.IOException;
import java.util.ArrayList;

public class ViewStoreCommand extends Command {

    private final NusFoodReviews nusFoodReviews;

    public ViewStoreCommand(NusFoodReviews nusFoodReviews) {
        this.nusFoodReviews = nusFoodReviews;
    }

    @Override
    public void execute(ArrayList<Canteen> canteens, Ui ui) throws IOException, DukeExceptions {

        if (canteens.size() == 0) {
            System.out.println(Ui.LINESPACING);
            System.out.println("There are no canteens for you to view any stores yet.");
            System.out.println(Ui.LINESPACING);
            return;
        }

        nusFoodReviews.setCanteenIndex();
        int currentCanteenIndex = nusFoodReviews.getCanteenIndex();
        if (currentCanteenIndex == -1) {
            ui.showStoreNotAdded();
            return;
        }
        ui.showDisplayStores(canteens.get(currentCanteenIndex));

    }

}
