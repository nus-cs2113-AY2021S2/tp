package command;

import canteens.Canteen;
import exceptions.DukeExceptions;
import stores.Store;
import ui.Ui;
import java.util.ArrayList;



public class DeleteMenu extends Command {
    private int storeIndex;
    private int menu;
    private int canteenIndex;

    public DeleteMenu(int canteenIndex, int storeIndex, int menu) {
        this.canteenIndex = canteenIndex;
        this.storeIndex = storeIndex;
        this.menu = menu;
    }

    public void execute(ArrayList<Canteen> canteens, Ui ui) throws DukeExceptions {
        Canteen currentCanteen = canteens.get(canteenIndex);
        Store store = currentCanteen.getStore(storeIndex);
        store.deleteMenu(menu);
        ui.menuDeleted();
    }

}

