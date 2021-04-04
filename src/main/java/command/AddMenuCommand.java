package command;

import canteens.Canteen;
import exceptions.DukeExceptions;
import menus.Menu;
import nusfoodreviews.NusFoodReviews;
import stores.Store;
import storage.Storage;
import ui.Ui;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class AddMenuCommand extends Command {

    private NusFoodReviews nusFoodReviews;

    public AddMenuCommand(NusFoodReviews nusFoodReviews) {
        this.nusFoodReviews = nusFoodReviews;
    }

    @Override
    public void execute(ArrayList<Canteen> canteens, Ui ui) throws DukeExceptions {
        try {
            getMenu(canteens, ui);
        } catch (NumberFormatException | IOException | DukeExceptions e) {
            throw new DukeExceptions("Menu not added. Please input your Menu in proper format!");
        }
    }

    public void getMenu(ArrayList<Canteen> canteens, Ui ui) throws NumberFormatException, IOException, DukeExceptions {
        String menuName;
        double menuPrice;
        Integer currentStoreIndex;

        nusFoodReviews.setCanteenIndex();
        int currentCanteenIndex = nusFoodReviews.getCanteenIndex();
        if (currentCanteenIndex == -1) {
            ui.menuNotAdded();
            return;
        }
        ui.showDisplayStores(canteens.get(currentCanteenIndex));

        ui.chooseStore();
        String line = ui.readCommand();
        if (line.equals("cancel")) {
            ui.menuNotAdded();
            return;
        } else {
            currentStoreIndex = Integer.parseInt(line) - 1;
        }

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

        Canteen canteen = canteens.get(currentCanteenIndex);
        Menu menu = new Menu(menuName,menuPrice);
        canteen.getStore(currentStoreIndex).addMenu(menu);
        ui.menuAdded();

        System.out.println(menuName + " " + line);
        Storage.saveMenu(new FileWriter("data/storage.txt",true),
                canteen.getCanteenName(),canteen.getStore(currentStoreIndex).getStoreName(),menuName,line);
    }


}
