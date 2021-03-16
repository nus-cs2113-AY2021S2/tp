package seedu.duke.command;

import seedu.duke.Constants;
import seedu.duke.Data;
import seedu.duke.Ui;

import java.util.HashMap;

public class HelpCommand extends Command {
    /**
     * This is the constructor of the command. Arguments are passed to parent class.
     * @param ui Instance of Ui class, for UI input/output
     * @param data Instance of Data class, for manipulating patient list and read/write miscellaneous config
     * @param arguments Arguments decomposed from the full command given by the user
     */
    public HelpCommand(Ui ui, Data data, HashMap<String, String> arguments) {
        super(ui, data, arguments);
    }

    @Override
    public void execute() {
        String[] commands = arguments.get("payload").toLowerCase().split(" ");
        if (commands[0].isEmpty()) {
            ui.printMessage(Constants.ADD_INFO_MESSAGE + System.lineSeparator()
                    + Constants.LIST_INFO_MESSAGE + System.lineSeparator()
                    + Constants.LOAD_INFO_MESSAGE + System.lineSeparator()
                    + Constants.RECORD_CONSULTATION_INFO_MESSAGE + System.lineSeparator()
                    + Constants.RETRIEVE_INFO_MESSAGE + System.lineSeparator()
                    + Constants.CURRENT_INFO_MESSAGE + System.lineSeparator()
                    + Constants.HELP_INFO_MESSAGE + System.lineSeparator()
                    + Constants.EXIT_INFO_MESSAGE
            );
        } else {
            for (String command : commands) {
                switch (command) {
                case "add":
                    ui.printMessage(Constants.ADD_INFO_MESSAGE);
                    break;
                case "list":
                    ui.printMessage(Constants.LIST_INFO_MESSAGE);
                    break;
                case "load":
                    ui.printMessage(Constants.LOAD_INFO_MESSAGE);
                    break;
                case "record":
                    ui.printMessage(Constants.RECORD_CONSULTATION_INFO_MESSAGE);
                    break;
                case "retrieve":
                    ui.printMessage(Constants.RETRIEVE_INFO_MESSAGE);
                    break;
                case "current":
                    ui.printMessage(Constants.CURRENT_INFO_MESSAGE);
                    break;
                case "help":
                    ui.printMessage(Constants.HELP_INFO_MESSAGE);
                    break;
                case "exit":
                    ui.printMessage(Constants.EXIT_INFO_MESSAGE);
                    break;
                default:
                    ui.printMessage(String.format(Constants.INVALID_COMMAND_MESSAGE, command) + System.lineSeparator());
                }
            }
        }
    }
}
