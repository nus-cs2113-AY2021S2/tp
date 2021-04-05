package seedu.duke.parser;

import seedu.duke.command.dailyroutecommand.DeleteDailyRouteCommand;
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
import seedu.duke.command.generalcommand.ShowVenuesCommand;
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
        switch (filteredUserInput) {
        case "bye":
            command = new ByeCommand();
            break;
        case "help":
            command = new HelpCommand();
            break;
        case "show venues":
            command = new ShowVenuesCommand();
            break;

            //route
        case "go":
            command = new GoCommand();
            break;

            //alias
        case "add alias":
            command = new AddCustomAliasCommand();
            break;
        case "show alias":
            command = new ShowCustomAliasCommand();
            break;
        case "delete alias":
            command = new DeleteCustomAliasCommand();
            break;

            //history
        case "history":
            command = new ShowHistoryCommand();
            break;
        case "repeat history":
            command = new RepeatHistoryCommand();
            break;
        case "clear history":
            command = new ClearHistoryCommand();
            break;

            //favourite
        case "show favourite":
            command = new ShowFavouriteCommand();
            break;
        case "add favourite":
            command = new AddFavouriteCommand();
            break;
        case "delete favourite":
            command = new DeleteFavouriteCommand();
            break;
        case "repeat favourite":
            command = new RepeatFavouriteCommand();
            break;

            //daily route
        case "add daily route":
            command = new AddDailyRouteCommand();
            break;
        case "show daily route":
            command = new ShowDailyRouteCommand();
            break;
        case "delete daily route":
            command = new DeleteDailyRouteCommand();
            break;

            //note
        case "add note":
            command = new AddNoteCommand();
            break;
        case "show note":
            command = new ShowNoteCommand();
            break;
        case "delete note":
            command = new DeleteNoteCommand();
            break;
        default:
            throw new InvalidCommandException();
        }
        return command;
    }
}
