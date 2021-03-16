package seedu.duke.common;

//@@author isaharon
public enum DashboardCommands implements CommandList {

    HELP("help", "Lists all commands available when no module is selected."),
    EXIT("exit", "Exits the program."),
    OPEN("open", "MODULE_CODE", "Opens the specified module."),
    ADD("add", "MODULE_CODE", "Adds a new module with specified module code."),
    DELETE("delete", "MODULE_CODE", "Deletes the specified module."),
    MODULES("modules", "Lists all modules."),
    INVALID("unknown", "Unrecognized command.");

    private final String word;
    private final String argumentsFormat;
    private final String description;

    DashboardCommands(String word, String description) {
        this.word = word;
        this.argumentsFormat = "";
        this.description = description;
    }

    DashboardCommands(String word, String argumentsFormat, String description) {
        this.word = word;
        this.argumentsFormat = argumentsFormat;
        this.description = description;
    }

    public String getWord() {
        return word;
    }

    @Override
    public String getArgumentsFormat() {
        return argumentsFormat;
    }

    public String getDescription() {
        return description;
    }
}
