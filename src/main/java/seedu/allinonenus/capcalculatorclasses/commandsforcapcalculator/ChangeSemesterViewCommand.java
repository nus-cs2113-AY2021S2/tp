package seedu.allinonenus.capcalculatorclasses.commandsforcapcalculator;

import seedu.allinonenus.capcalculatorclasses.exceptionsforcapcalculator.InvalidYearAndSemException;
import seedu.allinonenus.capcalculatorclasses.logicforcapcalculator.ModuleList;
import seedu.allinonenus.capcalculatorclasses.storageforcapcalculator.ModuleStorage;
import seedu.allinonenus.capcalculatorclasses.uiforcapcalculator.UiText;

import java.io.FileNotFoundException;
import java.io.IOException;


public class ChangeSemesterViewCommand extends CommandsForCapCalculator {
    public ChangeSemesterViewCommand() {
        super();

    }

    public void executeCommand(ModuleList moduleList, ModuleStorage storage, UiText uiText, String fullCommand)
            throws InvalidYearAndSemException {
        String[] moduleData = fullCommand.split(" ");
        String newSem = moduleData[1];
        int newSemNum = moduleList.computeSem(newSem);
        if (newSemNum > storage.totalSem) {
            System.out.print("Please update your student status before proceeding\n");
        } else {
            storage.currentSem = newSemNum;
        }

        saveToStorage(storage, moduleList);
    }

    public void saveToStorage(ModuleStorage storage, ModuleList moduleList) {
        int currentSem = storage.currentSem;
        int totalSem = storage.totalSem;
        try {
            storage.writeToFile(moduleList, currentSem, totalSem);
        } catch (FileNotFoundException e) {
            storage.fileDoesntExist();
        } catch (IOException e) {
            System.out.print("File Error\n");
        }
    }

    public boolean isExit() {
        return exit;
    }
}
