package command;

import canteens.Canteen;
import exceptions.DukeExceptions;
import stores.Store;
import ui.Ui;


import java.util.ArrayList;


public class ReadCommand extends Command {
    public int index;
    public ReadCommand(String input) {
        this.index = Integer.parseInt(input);
    }



    @Override
    public void execute(ArrayList<Canteen> canteens, Ui ui) {

        ArrayList<Store> stores = canteens.get(0).getStores();
        try {
            if (index > stores.size() || index < 0) {
                throw new ArrayIndexOutOfBoundsException();
            }
            stores.get(index - 1).displayReviews();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("☹ OOPS!!! Please enter a valid index after your command");
        }

    }


    @Override
    public boolean isExit() {
        return exit;
    }

}
