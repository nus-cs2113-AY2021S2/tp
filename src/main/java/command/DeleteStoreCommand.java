package command;

import canteens.Canteen;
import storage.Storage;
import ui.Ui;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class DeleteStoreCommand extends Command {

    private int canteenIndex;
    private int storeIndex;

    public DeleteStoreCommand(int canteenIndex, int storeIndex) {
        this.storeIndex = storeIndex;
        this.canteenIndex = canteenIndex;
    }

    @Override
    public void execute(ArrayList<Canteen> canteens, Ui ui) throws IOException {
        Canteen currentCanteen = canteens.get(canteenIndex);
        String storeName = currentCanteen.getStore(storeIndex).getStoreName();
        currentCanteen.deleteStore(storeIndex);
        ui.showDeleteStore(storeName);
        Storage.save(new FileWriter("data/storage.txt"),canteens);
    }
}
