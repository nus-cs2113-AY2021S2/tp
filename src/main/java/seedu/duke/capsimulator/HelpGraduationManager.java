package seedu.duke.capsimulator;

import seedu.duke.Storage;
import seedu.duke.Ui;

import java.io.IOException;

public class HelpGraduationManager {

    public static void execute() {

        while (true) {
            Ui.printHelpGraduationMenu();
            String command = Ui.readCommand();
            Ui.printHorizontalLine();
            try {
                int helpGraduationIndex = Integer.parseInt(command);
                switch (helpGraduationIndex) {
                case 1:
                    Ui.getCurrentCapPrompt();
                    //missing exception to catch <0 >5 CAP user input
                    double cap = Double.parseDouble(Ui.readCommand());
                    boolean validCap = (cap >= 0.0 && cap <= 5.0);
                    if (validCap) {
                        assert cap >= 0.0 : "Not Valid";
                        assert cap <= 5.0 : "Not Valid";
                    } else {
                        System.out.println("Invalid CAP score. Entries is not registered.");
                        continue;
                    }
                    //assert false;



                    Ui.getNumberOfGradedMCsTakenPrompt();
                    //missing exception to catch <0 >180? MCs user input
                    int totalMcs = Integer.parseInt(Ui.readCommand());
                    if (((cap > 0 && cap <= 5.0) && (totalMcs > 0 && totalMcs <= 180))
                            || ((cap == 0) && (totalMcs == 0))) {
                        HelpGraduation.setCurrentCap(cap);
                        HelpGraduation.setNumberOfGradedMCsTaken(totalMcs);
                    } else {
                        System.out.println("Invalid MCs. Entries is not registered.\n");
                    }

                    Ui.printRegisteredCapAndMCsTakenMessage();
                    break;
                case 2:
                    Ui.printRegisteredCapAndMCsTakenMessage();
                    break;
                case 3:
                    HelpGraduation helpGraduation = new HelpGraduation();
                    helpGraduation.capSimulator();
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
            }
            Ui.printReturnToHelpGraduationMenuMessage();
        }
    }
}
