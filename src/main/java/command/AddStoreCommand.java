package command;

import canteens.Canteen;
import storage.Storage;
import ui.Ui;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class AddStoreCommand extends Command {

    private int canteenIndex;
    private String storeName;

    public AddStoreCommand(int canteenIndex, String storeName) {
        this.canteenIndex = canteenIndex;
        this.storeName = storeName;
    }

    @Override
    public void execute(ArrayList<Canteen> canteens, Ui ui) throws IOException {
        canteens.get(canteenIndex).addStore(storeName);
        ui.printStoreAdded(storeName);
        Storage.saveStore(new FileWriter("data/storage.txt",true),
                canteens.get(canteenIndex).getCanteenName(),storeName);
    }

}
