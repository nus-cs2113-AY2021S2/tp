package command;

import canteens.Canteen;
import exceptions.DukeExceptions;
import parser.Parser;
import storage.Storage;
import ui.Ui;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import static ui.Ui.LINESPACING;

public class DeleteCanteenCommand extends Command {

    private Parser parser;
    private String savePath;

    public DeleteCanteenCommand(Parser parser, String savePath) {
        this.parser = parser;
        this.savePath = savePath;
    }

    @Override
    public void execute(ArrayList<Canteen> canteens, Ui ui) throws IOException, DukeExceptions {
        int numCanteens = canteens.size();
        if (numCanteens > 0) {
            ui.showDisplaySelectCanteens(canteens, "delete");
            String line = ui.readCommand();
            if (line.equals("cancel")) {
                ui.showCanteenNotDeleted();
                return;
            }
            int canteenIndex = parser.parseInt(line, Math.min(1, numCanteens), numCanteens) - 1;

            assert canteenIndex >= 0 && canteenIndex < canteens.size() : "DeleteCanteenCommand canteenIndex invalid";
            Canteen removedCanteen = canteens.remove(canteenIndex);
            ui.showCanteenDeleted(removedCanteen, canteens.size());
            Storage.save(new FileWriter(savePath), canteens);
        } else {
            System.out.println("There are no canteens left!");
            System.out.println(LINESPACING);
        }

    }
}
