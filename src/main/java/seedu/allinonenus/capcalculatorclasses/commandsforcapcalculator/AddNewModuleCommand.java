package seedu.allinonenus.capcalculatorclasses.commandsforcapcalculator;

import seedu.allinonenus.capcalculatorclasses.exceptionsforcapcalculator.InvalidGradeException;
import seedu.allinonenus.capcalculatorclasses.exceptionsforcapcalculator.WrongModuleFormatException;
import seedu.allinonenus.capcalculatorclasses.logicforcapcalculator.ModuleList;
import seedu.allinonenus.capcalculatorclasses.storageforcapcalculator.ModuleStorage;
import seedu.allinonenus.capcalculatorclasses.uiforcapcalculator.UiText;

import java.io.FileNotFoundException;
import java.io.IOException;

public class AddNewModuleCommand extends CommandsForCapCalculator {

    public AddNewModuleCommand() {
        super();
    }

    /**
     * @param moduleList
     * @param storage
     * @param uiText
     * @param fullCommand
     */
    public void executeCommand(ModuleList moduleList, ModuleStorage storage, UiText uiText, String fullCommand)
            throws WrongModuleFormatException, InvalidGradeException {

        String[] moduleInfo = fullCommand.split(" ");
        int currentSem = storage.getSem();
        String moduleCodeUpper = moduleInfo[1].toUpperCase();
        String gradeUpper = moduleInfo[2].toUpperCase();
        ModuleData modules = new ModuleData(moduleCodeUpper, gradeUpper, Integer.parseInt(moduleInfo[3]), currentSem);
        checkGradeFormat(moduleList, moduleInfo[2]);
        if (!checkForModuleFormat(moduleCodeUpper) || !checkMcFormat(Integer.parseInt(moduleInfo[3]))) {
            throw new WrongModuleFormatException();
        }


        if (checkIfModuleExists(moduleList, moduleInfo[1], currentSem)) {
            moduleList.add(modules);
            uiText.confirmModuleUpdate(modules.moduleCode);
            saveToStorage(storage, moduleList);
        } else {
            uiText.moduleAlreadyExists();
        }
        uiText.separationLine();
    }

    /**
     * @param storage
     * @param moduleList
     */
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

    public boolean checkIfModuleExists(ModuleList list, String module, int sem) {
        for (int i = 0; i < list.size(); i++) {
            String checkMod = list.get(i).moduleCode;
            int checkSem = list.get(i).sem;
            if (checkMod.equals(module) && checkSem == sem) {
                return false;
            }
        }
        return true;
    }

    public boolean checkForModuleFormat(String mod) {
        boolean modCorrect = true;
        int startingIndexofChar = 0;
        int endingIndexofChar = 1;
        int startingIndexofNum = 3;
        int endingIndexofNum = 5;

        for (int i = startingIndexofChar; i <= endingIndexofChar; i++) {
            if (!Character.isLetter(mod.charAt(i))) {
                modCorrect = false;
            }
        }

        for (int j = startingIndexofNum; j <= endingIndexofNum; j++) {
            if (!Character.isDigit(mod.charAt(j))) {
                modCorrect = false;
            }
        }

        return modCorrect;

    }

    public boolean checkMcFormat(int mcs) {
        boolean mcsCorrect = true;

        if (mcs < 2 || mcs > 12) {
            mcsCorrect = false;
        }

        return mcsCorrect;
    }

    public void checkGradeFormat(ModuleList list, String grade) throws InvalidGradeException {
        list.gradesToPoints(grade);
    }

    public boolean isExit() {
        return exit;
    }
}
