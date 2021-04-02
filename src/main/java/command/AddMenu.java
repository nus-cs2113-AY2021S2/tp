package command;

import canteens.Canteen;
import exceptions.DukeExceptions;
import menus.Menu;
import stores.Store;
import storage.Storage;
import ui.Ui;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class AddMenu extends Command {

    private int canteenIndex;
    private int storeIndex;
    private Menu menu;
    private Canteen canteen;

    public AddMenu(int canteenIndex, int storeIndex,Canteen canteen) {
        this.canteenIndex = canteenIndex;
        this.storeIndex = storeIndex;
        this.canteen = canteen;
    }

    @Override
    public void execute(ArrayList<Canteen> canteens, Ui ui) throws DukeExceptions {
        try {
            getMenu(ui);
        } catch (NumberFormatException | IOException e) {
            throw new DukeExceptions("Menu not added. Please input your Menu in proper format!");
        }
    }

    public void getMenu(Ui ui) throws NumberFormatException, IOException {
        String menuName;
        double menuPrice;
        String line;
        ui.enterMenuName();
        line = ui.readCommand();
        if (line.equals("cancel")) {
            ui.menuNotAdded();
            return;
        } else {
            menuName = line;
        }
        ui.enterMenuPrice();
        line = ui.readCommand();
        if (line.equals("cancel")) {
            ui.menuNotAdded();
            return;
        } else {
            menuPrice = Double.parseDouble(line);
        }
        menu = new Menu(menuName,menuPrice);
        canteen.getStore(storeIndex).addMenu(menu);
        ui.menuAdded();

        System.out.println(menuName + " " + line);
        Storage.saveMenu(new FileWriter("data/storage.txt",true),
                canteen.getCanteenName(),canteen.getStore(storeIndex).getStoreName(),menuName,line);
    }


}
