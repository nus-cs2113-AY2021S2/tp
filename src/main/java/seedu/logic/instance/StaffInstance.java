package seedu.logic.instance;

import seedu.exceptions.HealthVaultException;
import seedu.logic.command.Command;
import seedu.logic.command.StaffAggregation;
import seedu.logic.parser.StaffParser;
import seedu.storage.StaffStorage;
import seedu.ui.StaffUI;
import seedu.ui.UI;

public class StaffInstance {
    private StaffUI staffUI;
    private StaffAggregation staffAggregation;
    private StaffStorage staffStorage;
    private StaffParser staffParser;

    public StaffInstance(String filepath) {
        staffUI = new StaffUI();
        staffStorage = new StaffStorage(filepath);
        staffParser = new StaffParser();
        staffAggregation = new StaffAggregation();
    }


    public void run() {
        try {
            staffStorage.fileHandling(staffAggregation);
        } catch (HealthVaultException e) {
            StaffUI.corruptedFileErrorMessage();
            return;
        }
        StaffUI.staffMenuHeader();
        while (true) {
            String line;
            line = staffUI.getInput("Staff");
            try {
                Command c = staffParser.commandHandler(line, staffAggregation);
                if (c == null){
                    continue;
                }
                c.execute(staffAggregation, staffUI, staffStorage);
                if (c.isExit()) {
                    System.out.println("Returning to start Menu!\n");
                    break;
                }
            } catch (HealthVaultException e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException e) {
                StaffUI.invalidNumericErrorMessage();
            } catch (Exception e) {
                UI.unidentifiedErrorMessage();
            }
        }
    }
}
