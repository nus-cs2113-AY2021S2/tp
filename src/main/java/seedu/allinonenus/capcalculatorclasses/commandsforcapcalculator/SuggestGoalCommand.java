package seedu.allinonenus.capcalculatorclasses.commandsforcapcalculator;

import seedu.allinonenus.capcalculatorclasses.exceptionsforcapcalculator.InvalidGradeException;
import seedu.allinonenus.capcalculatorclasses.logicforcapcalculator.ModuleList;
import seedu.allinonenus.capcalculatorclasses.storageforcapcalculator.ModuleStorage;
import seedu.allinonenus.capcalculatorclasses.uiforcapcalculator.UiText;

public class SuggestGoalCommand extends CommandsForCapCalculator {

    public SuggestGoalCommand() {
        super();
    }

    public void executeCommand(ModuleList moduleList, ModuleStorage storage, UiText uiText, String fullCommand) throws InvalidGradeException {
        String[] moduleInfo = fullCommand.split(" ");
        int currentSem = storage.currentSem;
        double goalCAP = Double.parseDouble(moduleInfo[1]);
        double suggestedGrade = moduleList.suggest(currentSem, goalCAP);

        System.out.printf("You should aim to get a CAP of %.2f for your graded modules this semester\n"
                + "in order to get an overall CAP of %.2f\n", suggestedGrade, goalCAP);
        uiText.separationLine();
    }

    public boolean isExit() {
        return exit;
    }

}
