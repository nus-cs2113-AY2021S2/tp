package seedu.hdbuy.parser;

import seedu.hdbuy.command.CloseCommand;
import seedu.hdbuy.command.Command;
import seedu.hdbuy.command.DefaultCommand;
import seedu.hdbuy.command.FilterCommand;
import seedu.hdbuy.command.FindCommand;
import seedu.hdbuy.command.HelpCommand;

public class Parser {
    private String keyCommand;
    private String criteria;
    private String value;

    public Command parse(String fullLine) {
        Command command = new DefaultCommand(fullLine);
        extractInfo(fullLine);
        switch (keyCommand) {
        case "help":
            command = new HelpCommand();
            break;
        case "filter":
            command = new FilterCommand(criteria, value);
            break;
        case "find":
            command = new FindCommand();
            break;
        case "exit":
            command = new CloseCommand();
            break;
        default:
            break;
        }
        return command;
    }

    public void extractInfo(String fullLine) {
        String[] lineParts;
        lineParts = fullLine.split(" ");
        keyCommand = lineParts[0];
        switch (keyCommand) {
        case "filter":
            criteria = lineParts[1];
            value = lineParts[2];
            break;
        default:
            break;
        }
    }
}
