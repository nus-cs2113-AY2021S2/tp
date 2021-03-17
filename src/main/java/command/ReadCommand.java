package command;

import canteens.Canteen;
import reviews.Review;
import stores.Store;
import ui.Ui;


import java.util.ArrayList;


public class ReadCommand extends Command {
    public int index;

    public ReadCommand(int index) {
        this.index = index;
    }


    @Override
    public void execute(ArrayList<Canteen> canteens, Ui ui) {
        Store currentStore = canteens.get(0).getStore(index);
        ArrayList<Review> reviews = currentStore.getReviews();
        ui.showReviews(currentStore.getStoreName(), reviews);
    }


    @Override
    public boolean isExit() {
        return exit;
    }

}
