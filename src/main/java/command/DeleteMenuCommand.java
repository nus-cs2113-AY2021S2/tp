package command;

import canteens.Canteen;
import exceptions.DukeExceptions;
import storage.Storage;
import stores.Store;
import ui.Ui;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;



public class DeleteMenuCommand extends Command {
    private int storeIndex;
    private int menu;
    private int canteenIndex;

    public DeleteMenuCommand(int canteenIndex, int storeIndex, int menu) {
        this.canteenIndex = canteenIndex;
        this.storeIndex = storeIndex;
        this.menu = menu;
    }

    public void execute(ArrayList<Canteen> canteens, Ui ui) throws IOException {
        Canteen currentCanteen = canteens.get(canteenIndex);
        Store store = currentCanteen.getStore(storeIndex);
        String menuName = store.getMenus().get(menu).getItemName();
        store.deleteMenu(menu);
        ui.menuDeleted(menuName);
        Storage.save(new FileWriter("data/storage.txt"),canteens);
    }

}

