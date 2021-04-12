package seedu.allinonenus.capcalculatorclasses.parserforcapcalculator;

import seedu.allinonenus.capcalculatorclasses.commandsforcapcalculator.*;
import seedu.allinonenus.capcalculatorclasses.exceptionsforcapcalculator.IncorrectCommandsException;

public class ParserForCapCalculator {

    public ParserForCapCalculator() {

    }

    public CommandsForCapCalculator parse(String line) throws IncorrectCommandsException {
        String[] moduleInfo = line.split(" ");
        CommandsForCapCalculator newCommands;

        switch (moduleInfo[0]) {
        case "list":
            newCommands = new PrintModuleListCommand();
            break;
        case "show":
            newCommands = new ShowAllModulesCommand();
            break;

        case "delete":
            newCommands = new DeleteModuleCommand();
            break;

        case "edit":
            newCommands = new EditModuleCommand();
            break;
        case "view":
            newCommands = new ChangeSemesterViewCommand();
            break;

        case "add":
            newCommands = new AddNewModuleCommand();
            break;

        case "goal":
            newCommands = new SuggestGoalCommand();
            break;

        case "help":
            newCommands = new DisplayHelpCommand();
            break;

        case "update":
            newCommands = new UpdateStudentSemesterCommand();
            break;

        case "exit":
            newCommands = new ExitCapCalculatorCommand();
            break;

        default:
            throw new IncorrectCommandsException();

        }

        return newCommands;
    }

}
