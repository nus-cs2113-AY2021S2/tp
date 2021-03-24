package command;

import canteens.Canteen;
import ui.Ui;

import java.util.ArrayList;

public class DeleteCanteenCommand extends Command {

    private int canteenIndex;

    public DeleteCanteenCommand(int canteenIndex) {
        this.canteenIndex = canteenIndex;
    }

    @Override
    public void execute(ArrayList<Canteen> canteens, Ui ui) {
        canteens.remove(canteenIndex);
    }
}
