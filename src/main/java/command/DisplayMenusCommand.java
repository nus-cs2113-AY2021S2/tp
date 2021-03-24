package command;

import canteens.Canteen;
import exceptions.DukeExceptions;
import stores.Store;
import ui.Ui;
import menus.Menu;

import java.util.ArrayList;

public class DisplayMenusCommand extends Command {

    private Store store;

    public DisplayMenusCommand(Store store) {
        this.store = store;
    }

    public void execute(ArrayList<Canteen> canteens, Ui ui) {
        ArrayList<Menu> menus = store.getMenus();
        ui.showDisplayMenu(store.getStoreName(), menus);
    }
}
