package seedu.allinonenus.capcalculatorclasses;

import seedu.allinonenus.capcalculatorclasses.commandsforcapcalculator.AddNewModuleCommand;
import seedu.allinonenus.capcalculatorclasses.commandsforcapcalculator.CommandsForCapCalculator;
import seedu.allinonenus.capcalculatorclasses.exceptionsforcapcalculator.*;
import seedu.allinonenus.capcalculatorclasses.logicforcapcalculator.ModuleList;
import seedu.allinonenus.capcalculatorclasses.parserforcapcalculator.ParserForCapCalculator;
import seedu.allinonenus.capcalculatorclasses.storageforcapcalculator.ModuleStorage;
import seedu.allinonenus.capcalculatorclasses.uiforcapcalculator.UiText;

import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.logging.*;

public class CapCalculator {

    private final static Logger logr = Logger.getLogger(AddNewModuleCommand.class.getName());


    private final UiText uiText;
    private final ModuleStorage storage;

    private ModuleList moduleList;
    private final ParserForCapCalculator parser;

    public CapCalculator() {
        uiText = new UiText();
        parser = new ParserForCapCalculator();
        uiText.greetUser();
        uiText.separationLine();
        storage = new ModuleStorage();
        try {
            moduleList = new ModuleList(storage.load());

        } catch (NoSuchElementException | FileNotFoundException e) {
            prepareForNewUser();
        }

    }

    public void prepareForNewUser() {
        try {
            uiText.explainStepsForNewUser();
            uiText.promptForCommand();
            moduleList = new ModuleList();
            String studentYearAndSem = uiText.readCommand();
            storage.currentSem = moduleList.computeSem(studentYearAndSem);
            storage.totalSem = storage.currentSem;
            uiText.separationLine();
            uiText.listManual();
        } catch (InvalidYearAndSemException | EmptyLineException e) {
            uiText.separationLine();
            uiText.printException(e);
            uiText.separationLine();
            prepareForNewUser();

        } catch (StringIndexOutOfBoundsException e) {
            uiText.separationLine();
            uiText.tryAgain();
            uiText.separationLine();
            prepareForNewUser();
        }
    }

    public void run() {
        String fullCommand;
        boolean Exit = false;

        while (!Exit) {
            int sem = storage.totalSem;
            int currSem = storage.currentSem;
            String studentProfile = moduleList.printYearAndSem(sem);
            String currentSemView = moduleList.printYearAndSem(currSem);
            uiText.printStudentProfile(studentProfile);
            uiText.currentSemView(currentSemView);
            uiText.promptForCommand();
            try {
                fullCommand = uiText.readCommand();
                uiText.separationLine();
                CommandsForCapCalculator command = parser.parse(fullCommand);
                command.executeCommand(moduleList, storage, uiText, fullCommand);
                Exit = command.isExit();
            } catch (NullPointerException | ArrayIndexOutOfBoundsException | NumberFormatException
                    | StringIndexOutOfBoundsException e) {
                uiText.getHelp();

            } catch (InvalidYearAndSemException | EmptyLineException | IncorrectCommandsException |
                    InvalidGradeException | WrongModuleFormatException e) {
                uiText.printException(e);
                logr.log(Level.FINE, "Customised Exception has occurred\n");

                uiText.separationLine();
            }
        }
    }

}
