package command;

import canteens.Canteen;
import ui.Ui;

import java.util.ArrayList;

public abstract class Command {
    protected boolean exit;

    public Command() {
        exit = false;
    }

    public abstract void execute(ArrayList<Canteen> canteens, Ui ui);

    public abstract boolean isExit();
}
