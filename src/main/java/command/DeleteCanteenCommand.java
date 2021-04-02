package command;

import canteens.Canteen;
import storage.Storage;
import ui.Ui;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class DeleteCanteenCommand extends Command {

    private int canteenIndex;

    public DeleteCanteenCommand(int canteenIndex) {
        this.canteenIndex = canteenIndex;
    }

    @Override
    public void execute(ArrayList<Canteen> canteens, Ui ui) throws IOException {
        assert canteenIndex >= 0 && canteenIndex < canteens.size() : "DeleteCanteenCommand canteenIndex invalid";
        Canteen removedCanteen = canteens.remove(canteenIndex);
        ui.showCanteenDeleted(removedCanteen, canteens.size());
        Storage.save(new FileWriter("data/storage.txt"),canteens);
    }
}
