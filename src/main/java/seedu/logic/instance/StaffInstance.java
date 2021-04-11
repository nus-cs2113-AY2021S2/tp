package seedu.logic.instance;

import seedu.exceptions.HealthVaultException;
import seedu.logger.HealthVaultLogger;
import seedu.logic.command.Command;
import seedu.logic.parser.StaffParser;
import seedu.model.staff.StaffList;
import seedu.storage.StaffStorage;
import seedu.ui.StaffUI;
import seedu.ui.UI;

import java.util.logging.Level;
import java.util.logging.Logger;

public class StaffInstance {
    private StaffUI staffUI;
    private StaffList staffList;
    private StaffStorage staffStorage;
    private StaffParser staffParser;
    public Logger logger = HealthVaultLogger.getLogger();

    /**
     * Constructor for StaffInstance.
     *
     * @param filepath String of the filepath for StaffStorage.
     */
    public StaffInstance(String filepath) {
        staffUI = new StaffUI();
        staffStorage = new StaffStorage(filepath);
        staffParser = new StaffParser();
        staffList = new StaffList();
    }

    /**
     * Executes the Staff Menu.
     */
    public void run() {
        try {
            staffStorage.fileHandling(staffList);
        } catch (HealthVaultException | NumberFormatException | ArrayIndexOutOfBoundsException e) {
            logger.log(Level.WARNING, "Staff file corrupted.");
            StaffUI.corruptedFileErrorMessage();
            return;
        }
        StaffUI.staffMenuHeader();
        logger.log(Level.INFO, "Staff instance accessed.");
        while (true) {
            String line;
            UI.printEmptyLine();
            line = staffUI.getInput("Staff");
            try {
                Command c = staffParser.commandHandler(line, staffList);
                if (c == null) {
                    continue;
                }
                c.execute(staffList, staffUI, staffStorage);
                UI.printEmptyLine();
                if (c.isExit()) {
                    System.out.println("Returning to Start Menu!\n");
                    logger.log(Level.WARNING, "Handling HealthVaultException.");
                    break;
                }
            } catch (HealthVaultException e) {
                System.out.println(e.getMessage());
                UI.printEmptyLine();
                logger.log(Level.WARNING, "Handling HealthVaultException.");
            } catch (NumberFormatException e) {
                StaffUI.invalidNumericErrorMessage();
                UI.printEmptyLine();
                logger.log(Level.WARNING, "Handling NumberFormatException.");
            } catch (Exception e) {
                System.out.println("OOPS! Something went wrong!");
                logger.log(Level.WARNING, "Something went wrong that is not handled by Healthvault exception");
                UI.printEmptyLine();
            }
        }
    }
}
