package command;

import canteens.Canteen;
import storage.Storage;
import ui.Ui;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class AddCanteenCommand extends Command {

    private String canteenName;

    public AddCanteenCommand(String canteenName) {

        this.canteenName = canteenName;
    }

    @Override
    public void execute(ArrayList<Canteen> canteens, Ui ui) throws IOException {
        canteens.add(new Canteen(canteenName));
        ui.showAddCanteenSuccess(canteenName);
        Storage.saveCanteen(new FileWriter("data/storage.txt",true),canteenName);
    }

}
