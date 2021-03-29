package command;

import canteens.Canteen;
import ui.Ui;
import java.util.ArrayList;

public class DeleteStoreCommand extends Command {

    private int canteenIndex;
    private int storeIndex;

    public DeleteStoreCommand(int canteenIndex, int storeIndex) {
        this.storeIndex = storeIndex;
        this.canteenIndex = canteenIndex;
    }

    @Override
    public void execute(ArrayList<Canteen> canteens, Ui ui) {
        canteens.get(canteenIndex).deleteStore(storeIndex);
    }
}
