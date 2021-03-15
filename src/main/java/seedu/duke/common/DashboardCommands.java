package seedu.duke.common;

public enum DashboardCommands implements CommandList {

    HELP("help", "Lists out all commands available when a module isn't selected."),
    EXIT("exit", "Exits the program."),
    OPEN("open", "Opens the specified module."),
    ADD("add", "Adds a new module with specified name."),
    DELETE("delete", "Deletes the specified module."),
    MODULES("modules", "Lists all modules."),
    INVALID("unknown", "Unrecognized command.");

    private final String word;
    private final String description;

    DashboardCommands(String word, String description) {
        this.word = word;
        this.description = description;
    }

    public String getWord() {
        return word;
    }

    public String getDescription() {
        return description;
    }
}
