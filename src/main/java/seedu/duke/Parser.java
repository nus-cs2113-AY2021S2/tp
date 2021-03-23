package seedu.duke;


import seedu.duke.command.Command;
import seedu.duke.command.GoCommand;
import seedu.duke.command.RepeatCommand;
import seedu.duke.command.ShowHistoryCommand;
import seedu.duke.command.ClearHistoryCommand;
import seedu.duke.command.ListNoteCommand;
import seedu.duke.command.AddNoteCommand;
import seedu.duke.command.DeleteNoteCommand;
import seedu.duke.command.ByeCommand;
import seedu.duke.command.HelpCommand;
import seedu.duke.command.AddDailyRouteCommand;
import seedu.duke.command.ShowDailyRouteCommand;
import seedu.duke.exception.InvalidCommandException;

public class Parser {
    public static Command prepareForCommandExecution(String userInput) throws InvalidCommandException {
        assert userInput != null : "User input cannot be null";

        Command command;
        String filteredUserInput = userInput.trim().toLowerCase();
        if (filteredUserInput.equals("go")) {
            command = new GoCommand(filteredUserInput);
        } else if (filteredUserInput.equals("history")) {
            command = new ShowHistoryCommand(filteredUserInput);
        } else if (filteredUserInput.equals("repeat")) {
            command = new RepeatCommand(filteredUserInput);
        } else if (filteredUserInput.equals("clear history")) {
            command = new ClearHistoryCommand(filteredUserInput);
        } else if (filteredUserInput.startsWith("list notes")) {
            command = new ListNoteCommand(filteredUserInput);
        } else if (filteredUserInput.startsWith("add note")) {
            command = new AddNoteCommand(filteredUserInput);
        } else if (filteredUserInput.startsWith("delete note")) {
            command = new DeleteNoteCommand(filteredUserInput);
        } else if (filteredUserInput.equals("bye")) {
            command = new ByeCommand(filteredUserInput);
        }  else if (filteredUserInput.equals("help")) {
            command = new HelpCommand(filteredUserInput);
        }  else if (filteredUserInput.startsWith("add day")) {
            command = new AddDailyRouteCommand(filteredUserInput);
        }  else if (filteredUserInput.equals("day")) {
            command = new ShowDailyRouteCommand(filteredUserInput);
        } else {
            throw new InvalidCommandException();
        }
        return command;
    }
}
