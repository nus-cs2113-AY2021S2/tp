package seedu.logic.instance;

import seedu.logic.command.DrugAction;
import seedu.logic.parser.drugparser;
import seedu.model.object.Drug;
import seedu.storage.DrugStorage;
import seedu.ui.DrugUI;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class DrugInstance {

    /**
     * Main entry-point for the java.duke.DrugInstance application.
     */
    protected DrugStorage drugStorage;
    protected DrugAction drugAction;
    protected ArrayList<Drug> Drugs;

    public DrugInstance(String filePath) {
        drugStorage = new DrugStorage(filePath);
        try {
            Drugs = drugStorage.uploadDrugs();
            drugAction = new DrugAction();
        } catch (FileNotFoundException e) {
            Drugs = drugStorage.createNewFile();
        }
    }

    public void run() {
        DrugUI.DrugCommandWelcome();
        drugparser drugparser = new drugparser(drugAction);
        drugparser.parseMethod();
        drugStorage.exitProgram();
    }

}
