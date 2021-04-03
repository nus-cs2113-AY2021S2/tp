package command;

import canteens.Canteen;
import exceptions.DukeExceptions;
import nusfoodreviews.NusFoodReviews;
import storage.Storage;
import ui.Ui;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class AddStoreCommand extends Command {

    private NusFoodReviews nusFoodReviews;

    public AddStoreCommand(NusFoodReviews nusFoodReviews) {
        this.nusFoodReviews = nusFoodReviews;
    }

    @Override
    public void execute(ArrayList<Canteen> canteens, Ui ui) throws IOException, DukeExceptions {
        nusFoodReviews.setCanteenIndex();
        int currentCanteenIndex = nusFoodReviews.getCanteenIndex();
        if (currentCanteenIndex == -1) {
            ui.showStoreNotAdded();
            return;
        }
        ui.showDisplayStores(canteens.get(currentCanteenIndex));
        ui.showAddStore();
        String storeName = ui.readCommand();
        if (storeName.equals("cancel")) {
            ui.showStoreNotAdded();
            return;
        }
        canteens.get(currentCanteenIndex).addStore(storeName);
        ui.printStoreAdded(storeName);
        Storage.saveStore(new FileWriter("data/storage.txt",true),
                canteens.get(currentCanteenIndex).getCanteenName(),storeName);
    }

}
