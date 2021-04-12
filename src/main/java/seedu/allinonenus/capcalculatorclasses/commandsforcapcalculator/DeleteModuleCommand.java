package seedu.allinonenus.capcalculatorclasses.commandsforcapcalculator;

import seedu.allinonenus.capcalculatorclasses.logicforcapcalculator.ModuleList;
import seedu.allinonenus.capcalculatorclasses.storageforcapcalculator.ModuleStorage;
import seedu.allinonenus.capcalculatorclasses.uiforcapcalculator.UiText;

import java.io.FileNotFoundException;
import java.io.IOException;

public class DeleteModuleCommand extends CommandsForCapCalculator {
    public DeleteModuleCommand() {
        super();
    }

    public void executeCommand(ModuleList moduleList, ModuleStorage storage, UiText uiText, String fullCommand) {
        String[] moduleInfo = fullCommand.split(" ");
        int currentSem = storage.getSem();
        String moduleToDelete = moduleInfo[1];
        if (checkIfModuleExists(moduleList, moduleInfo[1], currentSem)) {
            moduleList.delete(moduleToDelete);
            uiText.deletedModule(moduleToDelete);
            saveToStorage(storage, moduleList);
        } else {
            uiText.moduleDoesntExist();
        }

        uiText.separationLine();
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

    public boolean checkIfModuleExists(ModuleList modList, String module, int sem) {
        for (int i = 0; i < modList.size(); i++) {
            String checkMod = modList.get(i).moduleCode;
            int checkSem = modList.get(i).sem;
            if (checkMod.equals(module) && checkSem == sem) {
                return true;
            }
        }
        return false;
    }

    public boolean isExit() {
        return exit;
    }
}
