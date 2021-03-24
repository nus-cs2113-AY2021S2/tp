package command;

import canteens.Canteen;
import stores.Store;
import ui.Ui;

import java.util.ArrayList;

public class DisplayStoresCommand extends Command {

    @Override
    public void execute(ArrayList<Canteen> canteens, Ui ui) {
        ArrayList<Store> stores = canteens.get(0).getStores();
        ui.showDisplaySelectStores(canteens.get(0));
    }
}
