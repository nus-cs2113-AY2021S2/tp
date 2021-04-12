package seedu.allinonenus.capcalculatorclasses.commandsforcapcalculator;

import seedu.allinonenus.capcalculatorclasses.logicforcapcalculator.ModuleList;
import seedu.allinonenus.capcalculatorclasses.storageforcapcalculator.ModuleStorage;
import seedu.allinonenus.capcalculatorclasses.uiforcapcalculator.UiText;

public class ShowAllModulesCommand extends CommandsForCapCalculator {

    public ShowAllModulesCommand() {
        super();
    }

    public void executeCommand(ModuleList moduleList, ModuleStorage storage, UiText uiText, String fullCommand) {
        int totalSem = storage.totalSem;
        int currentSemIndex = 1;
        while (currentSemIndex <= totalSem) {

            System.out.print("Modules for " + moduleList.printYearAndSem(currentSemIndex) + ":\n");

            if (modulesExist(moduleList, currentSemIndex)) {


                System.out.print("[MODULES] [GRADEs] [MCs]\n");
                for (int i = 0; i < moduleList.size(); i++) {

                    if (moduleList.get(i).sem == currentSemIndex) {

                        System.out.printf("[%-7s]   [%-2s]    [%1d]%n",
                                moduleList.get(i).moduleCode, moduleList.get(i).grade, moduleList.get(i).mcs);
                    }

                }
            } else {
                uiText.warnUserOfEmptySemester();

            }
            currentSemIndex++;
            uiText.separationLine();
        }

    }

    public boolean modulesExist(ModuleList moduleList, int currentSem) {
        boolean exists = false;
        for (int i = 0; i < moduleList.size(); i++) {
            if (moduleList.get(i).sem == currentSem) {
                exists = true;
            }
        }
        return exists;
    }

    public boolean isExit() {
        return exit;
    }
}
