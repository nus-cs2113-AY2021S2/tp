package seedu.duke.common;

//@@author isaharon
public enum DashboardCommands implements CommandList {

    HELP("help", "Lists all commands available when no module is selected."),
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
