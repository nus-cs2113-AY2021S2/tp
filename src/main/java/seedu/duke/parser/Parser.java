package seedu.duke.parser;

import seedu.duke.commands.Command;
import seedu.duke.exception.UnknownCommandException;
import seedu.duke.module.ModuleList;

import static seedu.duke.commands.Command.ADD_MODULE_COMMAND;
import static seedu.duke.commands.Command.DEL_MODULE_COMMAND;
import static seedu.duke.commands.Command.LIST_MODULE_COMMAND;
import static seedu.duke.commands.Command.ENTER_MODULE_COMMAND;
import static seedu.duke.commands.Command.PRINT_HELP_COMMAND;
import static seedu.duke.commands.Command.EXIT_PROGRAM_COMMAND;
import static seedu.duke.commands.Command.UNKNOWN_COMMAND;


public class Parser {

    public Command parse(String input) throws UnknownCommandException {
        Command parsedCommand;

        if (moduleIsSelected()) {
            parsedCommand = parseModuleSelectedCommands(input);
        } else {
            parsedCommand = parseOuterCommands(input);
        }

        return parsedCommand;
    }

    private Command parseOuterCommands(String input) throws UnknownCommandException {
        Command command;
        int commandCode = parseCommandFromInput(input);
        
        switch (commandCode) {
        case EXIT_PROGRAM_COMMAND:
            command = new ExitProgram();
            break;
        case PRINT_HELP_COMMAND:
            command = new PrintHelp();
            break;
        case LIST_MODULE_COMMAND:
            command = new ListModule();
            break;
        case ADD_MODULE_COMMAND:
            String moduleCode = getModuleCode(input);
            command = new AddModule(moduleCode);
            break;
        case DEL_MODULE_COMMAND:
            String moduleCode = getModuleCode(input);
            command = new DeleteModule(moduleCode);
            break;
        case ENTER_MODULE_COMMAND:
            command = new EnterModule(input);
            break;
        default:
            throw new UnknownCommandException();
        }

        return command;
    }

    private String getModuleCode(String input) {
        // TODO  - error handling
        String[] words = input.split(" ");

        return words[1];
    }


    // check if module is selected
    private boolean moduleIsSelected() {
        return ModuleList.selectedModule != null;
    }

    // check if module name is valid
    private boolean isValidModuleName(String name) {
        // TODO - add stricter checks
        boolean isValid;
        String[] words = name.split(" ");

        // ensure there is only one word
        isValid = words.length == 1;

        return isValid;
    }
    
    private int parseCommandFromInput (String input) {
        if (input.equalsIgnoreCase("exit")) {
            return EXIT_PROGRAM_COMMAND;
        } else if (input.equalsIgnoreCase("help")) {
           return PRINT_HELP_COMMAND;
        } else if (input.equalsIgnoreCase("list")) {
            return LIST_MODULE_COMMAND;
        } else if (startsWith(input, "add")) {
            return ADD_MODULE_COMMAND;
        } else if (startsWith(input, "delete")) {
            return DEL_MODULE_COMMAND;
        } else if (isValidModuleName(input)) {
            return ENTER_MODULE_COMMAND;
        } else {
            return UNKNOWN_COMMAND;
        }
    }

    private boolean startsWith(String input, String command) {
        return input.toUpperCase().startsWith(command.toUpperCase());
    }


    /**
     * After user has selected module.
     */
    private Command parseModuleSelectedCommands(String input) {
        // TODO - implement
        Command command;
        return null;
    }

}
