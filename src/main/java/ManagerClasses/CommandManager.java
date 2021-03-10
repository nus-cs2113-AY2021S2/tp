package ManagerClasses;

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
            return CommandEnum.GO;
        case "history":
            return CommandEnum.HISTORY;
        case "clear history":
            return CommandEnum.CLEARHISTORY;
        case "add note":
            return CommandEnum.ADDNOTE;
        case "delete note":
            return CommandEnum.DELETENOTE;
        case "notes":
            return CommandEnum.DISPLAYNOTES;
        case "bye":
            return CommandEnum.BYE;
        default:
            return CommandEnum.INVALID;
        }
    }
}
