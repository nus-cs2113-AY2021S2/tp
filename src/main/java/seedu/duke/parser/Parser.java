package seedu.duke.parser;

import seedu.duke.command.dailyroutecommand.ClearDailyRouteCommand;
import seedu.duke.command.generalcommand.ByeCommand;
import seedu.duke.command.Command;
import seedu.duke.command.generalcommand.HelpCommand;
import seedu.duke.command.aliascommand.AddCustomAliasCommand;
import seedu.duke.command.aliascommand.DeleteCustomAliasCommand;
import seedu.duke.command.aliascommand.ShowCustomAliasCommand;
import seedu.duke.command.dailyroutecommand.AddDailyRouteCommand;
import seedu.duke.command.dailyroutecommand.ShowDailyRouteCommand;
import seedu.duke.command.favouritecommand.AddFavouriteCommand;
import seedu.duke.command.favouritecommand.DeleteFavouriteCommand;
import seedu.duke.command.favouritecommand.RepeatFavouriteCommand;
import seedu.duke.command.favouritecommand.ShowFavouriteCommand;
import seedu.duke.command.historycommand.ClearHistoryCommand;
import seedu.duke.command.historycommand.RepeatHistoryCommand;
import seedu.duke.command.historycommand.ShowHistoryCommand;
import seedu.duke.command.notecommand.AddNoteCommand;
import seedu.duke.command.notecommand.DeleteNoteCommand;
import seedu.duke.command.notecommand.ShowNoteCommand;
import seedu.duke.command.routecommand.GoCommand;
import seedu.duke.exception.InvalidCommandException;

public class Parser {
    public static Command prepareForCommandExecution(String userInput) throws InvalidCommandException {
        assert userInput != null : "User input cannot be null";
        Command command;
        String filteredUserInput = userInput.trim().toLowerCase();
        if (filteredUserInput.equals("bye")) {
            command = new ByeCommand();
        }  else if (filteredUserInput.equals("help")) {
            command = new HelpCommand();

            //route
        } else if (filteredUserInput.equals("go")) {
            command = new GoCommand();

            //alias
        } else if (filteredUserInput.equals("add alias")) {
            command = new AddCustomAliasCommand();
        } else if (filteredUserInput.equals("show alias")) {
            command = new ShowCustomAliasCommand();
        } else if (filteredUserInput.equals("delete alias")) {
            command = new DeleteCustomAliasCommand();

            //history
        } else if (filteredUserInput.equals("history")) {
            command = new ShowHistoryCommand();
        } else if (filteredUserInput.equals("repeat history")) {
            command = new RepeatHistoryCommand();
        } else if (filteredUserInput.equals("clear history")) {
            command = new ClearHistoryCommand();

            //favourite
        } else if (filteredUserInput.equals("show favourite")) {
            command = new ShowFavouriteCommand();
        } else if (filteredUserInput.equals("add favourite")) {
            command = new AddFavouriteCommand();
        } else if (filteredUserInput.equals("delete favourite")) {
            command = new DeleteFavouriteCommand();
        } else if (filteredUserInput.equals("repeat favourite")) {
            command = new RepeatFavouriteCommand();

            //daily route
        }  else if (filteredUserInput.equals("add daily route")) {
            command = new AddDailyRouteCommand();
        }  else if (filteredUserInput.equals("show daily route")) {
            command = new ShowDailyRouteCommand();
        }  else if (filteredUserInput.equals("clear daily route")) {
            command = new ClearDailyRouteCommand();

            //note
        } else if (filteredUserInput.equals("add note")) {
            command = new AddNoteCommand();
        } else if (filteredUserInput.equals("show note")) {
            command = new ShowNoteCommand();
        } else if (filteredUserInput.equals("delete note")) {
            command = new DeleteNoteCommand();

        } else {
            throw new InvalidCommandException();
        }
        return command;
    }
}
