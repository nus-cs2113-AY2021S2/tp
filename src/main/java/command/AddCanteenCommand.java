package command;

import canteens.Canteen;
import ui.Ui;

import java.util.ArrayList;

public class AddCanteenCommand extends Command {

    private String canteenName;

    public AddCanteenCommand(String canteenName) {
        this.canteenName = canteenName;
    }

    @Override
    public void execute(ArrayList<Canteen> canteens, Ui ui) {
        canteens.add(new Canteen(canteenName));
        ui.showAddCanteenSuccess(canteenName);
    }

}
