package seedu.duke;

import seedu.duke.command.*;
import seedu.duke.command.aliascommand.AddCustomAliasCommand;
import seedu.duke.command.aliascommand.DeleteCustomAliasCommand;
import seedu.duke.command.aliascommand.ShowCustomAliasCommand;
import seedu.duke.command.favouritecommand.AddFavouriteCommand;
import seedu.duke.command.favouritecommand.DeleteFavouriteCommand;
import seedu.duke.command.favouritecommand.RepeatFavouriteCommand;
import seedu.duke.command.favouritecommand.ShowFavouriteCommand;
import seedu.duke.command.historycommand.ClearHistoryCommand;
import seedu.duke.command.historycommand.RepeatHistoryCommand;
import seedu.duke.command.historycommand.ShowHistoryCommand;
import seedu.duke.command.notecommand.AddNoteCommand;
import seedu.duke.command.notecommand.DeleteNoteCommand;
import seedu.duke.command.notecommand.ListNoteCommand;
import seedu.duke.command.routecommand.GoCommand;
import seedu.duke.exception.InvalidCommandException;

public class Parser {
    public static Command prepareForCommandExecution(String userInput) throws InvalidCommandException {
        assert userInput != null : "User input cannot be null";
        Command command;
        String filteredUserInput = userInput.trim().toLowerCase();
        if (filteredUserInput.equals("go")) {
            command = new GoCommand();
        } else if (filteredUserInput.equals("history")) {
            command = new ShowHistoryCommand();
        } else if (filteredUserInput.equals("repeat history")) {
            command = new RepeatHistoryCommand();
        } else if (filteredUserInput.equals("repeat favourite")) {
            command = new RepeatFavouriteCommand();
        } else if (filteredUserInput.equals("clear history")) {
            command = new ClearHistoryCommand();
        } else if (filteredUserInput.startsWith("list notes")) {
            command = new ListNoteCommand(userInput);
        } else if (filteredUserInput.startsWith("add note")) {
            command = new AddNoteCommand();
        } else if (filteredUserInput.startsWith("delete note")) {
            command = new DeleteNoteCommand(userInput);
        } else if (filteredUserInput.equals("bye")) {
            command = new ByeCommand();
        }  else if (filteredUserInput.equals("help")) {
            command = new HelpCommand();
        }  else if (filteredUserInput.startsWith("add day")) {
            command = new AddDailyRouteCommand();
        }  else if (filteredUserInput.equals("day")) {
            command = new ShowDailyRouteCommand();
        } else if (filteredUserInput.startsWith("show favourite")) {
            command = new ShowFavouriteCommand();
        } else if (filteredUserInput.startsWith("add favourite")) {
            command = new AddFavouriteCommand();
        } else if (filteredUserInput.startsWith("delete favourite")) {
            command = new DeleteFavouriteCommand();
        } else if (filteredUserInput.equals("add alias")) {
            command = new AddCustomAliasCommand();
        } else if (filteredUserInput.equals("show alias")) {
            command = new ShowCustomAliasCommand();
        } else if (filteredUserInput.equals("delete alias")) {
            command = new DeleteCustomAliasCommand();
        } else {
            throw new InvalidCommandException();
        }
        return command;
    }
}
