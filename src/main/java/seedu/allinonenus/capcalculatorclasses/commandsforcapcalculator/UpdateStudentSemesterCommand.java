package seedu.allinonenus.capcalculatorclasses.commandsforcapcalculator;

import seedu.allinonenus.capcalculatorclasses.exceptionsforcapcalculator.InvalidYearAndSemException;
import seedu.allinonenus.capcalculatorclasses.logicforcapcalculator.ModuleList;
import seedu.allinonenus.capcalculatorclasses.storageforcapcalculator.ModuleStorage;
import seedu.allinonenus.capcalculatorclasses.uiforcapcalculator.UiText;

import java.io.FileNotFoundException;
import java.io.IOException;

public class UpdateStudentSemesterCommand extends CommandsForCapCalculator {

    public UpdateStudentSemesterCommand() {
        super();
    }

    public void executeCommand(ModuleList moduleList, ModuleStorage storage, UiText uiText, String fullCommand)
            throws InvalidYearAndSemException {
        String[] moduleInfo = fullCommand.split(" ");
        int sem = moduleList.computeSem(moduleInfo[1]);
        if (storage.totalSem == sem - 1) {
            storage.totalSem = sem;
            storage.currentSem = sem;
            System.out.print("You are now viewing " + moduleList.printYearAndSem(storage.currentSem) + "\n");
            saveToStorage(storage, moduleList);
        } else {
            System.out.print("Please ensure your inputs are valid"
                    + " and it is an increment from your previous semester\n");
        }

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
