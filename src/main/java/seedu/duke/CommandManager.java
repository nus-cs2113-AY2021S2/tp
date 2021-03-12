package seedu.duke;

public class CommandManager {
    private CommandEnum commandType;

    public CommandManager(String input) {
        setCommandFromInput(input);
    }

    public CommandEnum getCommandType() {
        return commandType;
    }

    private void setCommandFromInput(String input) {
        // Trim input to remove unnecessary whitespaces
        // Convert input to lowercase to make command case insensitive
        String filteredInput = input.trim().toLowerCase();

        commandType = getCommandTypeFromInput(filteredInput);
    }

    private CommandEnum getCommandTypeFromInput(String filteredInput) {
        switch (filteredInput) {
        case "go":
            return CommandEnum.GoCommand;
        case "history":
            return CommandEnum.ShowHistoryCommand;
        case "clear history":
            return CommandEnum.ClearHistoryCommand;
        case "add note":
            return CommandEnum.AddNoteCommand;
        case "delete note":
            return CommandEnum.DeleteNoteCommand;
        case "notes":
            return CommandEnum.DisplayNotesCommand;
        case "bye":
            return CommandEnum.ByeCommand;
        default:
            return CommandEnum.InvalidCommand;
        }
    }
}
