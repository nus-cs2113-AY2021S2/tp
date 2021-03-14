package command;

import canteens.Canteen;
import stores.Store;
import ui.Ui;

import java.util.ArrayList;

public class DisplayStoresCommand extends Command {

    @Override
    public void execute(ArrayList<Canteen> canteens, Ui ui) {
        ArrayList<Store> stores = canteens.get(0).getStores();
        if (stores.size() > 0) {
            System.out.println(Ui.LINESPACING);
            ui.showDisplayStoreMessage();
        }
        for (int i = 0; i < stores.size(); i++) {
            System.out.print((i + 1) + ".");
            stores.get(i).displayStore();
        }
        System.out.println(Ui.LINESPACING);
    }

    @Override
    public boolean isExit() {
        return exit;
    }
}
