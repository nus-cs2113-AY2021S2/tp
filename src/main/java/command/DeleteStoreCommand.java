package command;

import canteens.Canteen;
import exceptions.DukeExceptions;
import nusfoodreviews.NusFoodReviews;
import parser.Parser;
import storage.Storage;
import ui.Ui;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class DeleteStoreCommand extends Command {

    private Parser parser;
    private NusFoodReviews nusFoodReviews;

    public DeleteStoreCommand(NusFoodReviews nusFoodReviews, Parser parser) {
        this.nusFoodReviews = nusFoodReviews;
        this.parser = parser;
    }

    @Override
    public void execute(ArrayList<Canteen> canteens, Ui ui) throws IOException, DukeExceptions {
        nusFoodReviews.setCanteenIndex();
        int currentCanteenIndex = nusFoodReviews.getCanteenIndex();
        ui.showDisplaySelectStores(canteens.get(currentCanteenIndex));
        String line = ui.readCommand();
        if (line.equals("cancel")) {
            ui.showStoreNotDeleted();
            return;
        }
        int storeIndex = parser.parseInt(line, 1,
                canteens.get(currentCanteenIndex).getNumStores()) - 1;

        Canteen currentCanteen = canteens.get(currentCanteenIndex);
        String storeName = currentCanteen.getStore(storeIndex).getStoreName();
        currentCanteen.deleteStore(storeIndex);
        ui.showDeleteStore(storeName);
        Storage.save(new FileWriter(Storage.DEFAULT_STORAGE_FILEPATH),canteens);
    }
}
