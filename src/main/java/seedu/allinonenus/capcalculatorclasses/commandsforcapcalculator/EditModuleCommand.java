package seedu.allinonenus.capcalculatorclasses.commandsforcapcalculator;

import seedu.allinonenus.capcalculatorclasses.exceptionsforcapcalculator.EmptyLineException;
import seedu.allinonenus.capcalculatorclasses.logicforcapcalculator.ModuleList;
import seedu.allinonenus.capcalculatorclasses.storageforcapcalculator.ModuleStorage;
import seedu.allinonenus.capcalculatorclasses.uiforcapcalculator.UiText;

import java.io.FileNotFoundException;
import java.io.IOException;

public class EditModuleCommand extends CommandsForCapCalculator {

    public EditModuleCommand() {
        super();
    }

    public void executeCommand(ModuleList moduleList, ModuleStorage storage, UiText uiText, String fullCommand)
            throws EmptyLineException {
        String[] moduleInfo = fullCommand.split(" ");
        String moduleToEdit = moduleInfo[1];
        int index;


        uiText.requestForGrade();
        String newGrade = uiText.readCommand();

        index = moduleList.edit(moduleToEdit, newGrade);

        uiText.showEditedData(moduleList.get(index));


        saveToStorage(storage, moduleList);
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

    public boolean isExit() {
        return exit;
    }
}
