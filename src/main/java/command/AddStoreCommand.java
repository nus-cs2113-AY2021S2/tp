package command;

import canteens.Canteen;
import ui.Ui;
import java.util.ArrayList;

public class AddStoreCommand extends Command {

    @Override
    public void execute(ArrayList<Canteen> canteens, Ui ui) {
        ui.showAddStore();
        String storeName = ui.readCommand();
        canteens.get(0).addStore(storeName);
        ui.printStoreAdded(storeName);

    }

}
