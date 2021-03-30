package command;

import canteens.Canteen;
import ui.Ui;
import java.util.ArrayList;

public class AddStoreCommand extends Command {

    private int canteenIndex;
    private String storeName;

    public AddStoreCommand(int canteenIndex, String storeName) {
        this.canteenIndex = canteenIndex;
        this.storeName = storeName;
    }

    @Override
    public void execute(ArrayList<Canteen> canteens, Ui ui) {
        canteens.get(canteenIndex).addStore(storeName);
        ui.printStoreAdded(storeName);
    }

}
