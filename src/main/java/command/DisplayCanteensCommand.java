package command;

import canteens.Canteen;
import ui.Ui;

import java.util.ArrayList;

public class DisplayCanteensCommand extends Command {

    @Override
    public void execute(ArrayList<Canteen> canteens, Ui ui) {
        ui.showDisplayCanteens(canteens);
    }

}
