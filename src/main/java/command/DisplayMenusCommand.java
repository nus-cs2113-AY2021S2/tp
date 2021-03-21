package command;

import canteens.Canteen;
import exceptions.DukeExceptions;
import stores.Store;
import ui.Ui;
import menus.Menu;

import java.util.ArrayList;

public class DisplayMenusCommand extends Command {

    private int storeIndex;

    public DisplayMenusCommand(int storeIndex) {
        this.storeIndex = storeIndex;
    }

    public void execute(ArrayList<Canteen> canteens, Ui ui) {
        Store currentStore = canteens.get(0).getStore(storeIndex);
        ArrayList<Menu> menus = currentStore.getMenus();
        ui.showDisplayMenu(currentStore.getStoreName(), menus);
    }
}
