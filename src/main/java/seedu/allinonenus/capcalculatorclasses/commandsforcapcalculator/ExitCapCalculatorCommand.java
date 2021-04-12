package seedu.allinonenus.capcalculatorclasses.commandsforcapcalculator;

import seedu.allinonenus.capcalculatorclasses.logicforcapcalculator.ModuleList;
import seedu.allinonenus.capcalculatorclasses.storageforcapcalculator.ModuleStorage;
import seedu.allinonenus.capcalculatorclasses.uiforcapcalculator.UiText;

public class ExitCapCalculatorCommand extends CommandsForCapCalculator {


    public ExitCapCalculatorCommand() {
        this.exit = true;
    }

    public void executeCommand(ModuleList moduleList, ModuleStorage storage, UiText uiText, String fullCommand) {
        uiText.printExitMessage();
    }

    public boolean isExit() {
        return exit;
    }
}
