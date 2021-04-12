package seedu.duke.features.capsimulator;

import seedu.duke.storage.Storage;
import seedu.duke.ui.Ui;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CapSimulatorManager {

    private static final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    /**
     * Executes the features under CAP Simulator/Calculator. Features includes,
     * adding current CAP and MCs counted into CAP,
     * viewing current CAP and MCs counted into CAP, and
     * simulating CAP.
     */
    public static void execute() {

        while (true) {
            Ui.printHelpGraduationMenu();
            String command = Ui.readCommand();

            try {
                int helpGraduationIndex = Integer.parseInt(command);
                switch (helpGraduationIndex) {
                case 1:
                    addCapAndMcs();
                    Ui.printRegisteredCapAndMCsTakenMessage();
                    break;
                case 2:
                    Ui.printRegisteredCapAndMCsTakenMessage();
                    break;
                case 3:
                    AcademicRecords academicRecords = new AcademicRecords();
                    academicRecords.capSimulator();
                    break;
                case 4:
                    return;
                default:
                    Ui.printInvalidInputMessage();
                }
            } catch (NumberFormatException e) {
                Ui.printInvalidInputMessage();
                Ui.printHorizontalLine();
            }
            try {
                Storage.saveAllFiles();
            } catch (IOException e) {
                Ui.printFilesCouldNotBeSavedMessage();
                logger.log(Level.WARNING, "Saving error in CAP Simulator Manager.");
            }
            Ui.printReturnToCapSimulatorMenuMessage();
        }
    }

    /**
     * Adds current CAP and the total number of MCs counted into the CAP score.
     */
    private static void addCapAndMcs() {
        Ui.getCurrentCapPrompt();
        double cap = Double.parseDouble(Ui.readCommand());
        boolean validCap = (cap >= 0.0 && cap <= 5.0);
        if (validCap) {
            assert cap >= 0.0 : "Not Valid";
            assert cap <= 5.0 : "Not Valid";
        } else {
            Ui.printInvalidCapMessage();
            return;
        }
        //assert false;

        Ui.getNumberOfGradedMCsTakenPrompt();
        int totalMcs = Integer.parseInt(Ui.readCommand());
        boolean validMc = ((cap > 0 && cap <= 5.0) && (totalMcs > 0 && totalMcs <= 220))
                || ((cap == 0) && (totalMcs == 0));
        if (validMc) {
            AcademicRecords.setCurrentCap(cap);
            AcademicRecords.setTotalMcs(totalMcs);
        } else {
            Ui.printInvalidMcsMessage();
        }
    }
}
