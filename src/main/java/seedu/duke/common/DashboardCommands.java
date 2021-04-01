package seedu.duke.common;

//@@author isaharon
public enum DashboardCommands implements CommandList {

    HELP("help", "Lists all commands available when no module is selected."),
    EXIT("exit", "Exits the program."),
    OPEN("open", "MODULE_CODE", "Opens the specified module."),
    ADD("add", "MODULE_CODE", "Adds a new module with specified module code."),
    DELETE("del", "Deletes the specified module."),
    MODULES("mods", "Lists all modules.");

    private final String word;
    private final String argumentsFormat;
    private final String description;

    DashboardCommands(String word, String description) {
        this.word = word;
        this.argumentsFormat = Constants.EMPTY_STRING;
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

    //@@author ivanchongzhien
    /**
     * Converts given string to a dashboard command.
     *
     * @param commandWord word string
     * @return the enum type of DashboardCommands representing the command specified
     */
    public static DashboardCommands getDashboardCommandFromString(String commandWord) {
        if (commandWord.equalsIgnoreCase(DashboardCommands.HELP.getWord())) {
            return DashboardCommands.HELP;
        } else if (commandWord.equalsIgnoreCase(EXIT.getWord())) {
            return EXIT;
        } else if (commandWord.equalsIgnoreCase(MODULES.getWord())) {
            return MODULES;
        } else if (commandWord.equalsIgnoreCase(ADD.getWord())) {
            return ADD;
        } else if (commandWord.equalsIgnoreCase(DELETE.getWord())) {
            return DELETE;
        } else if (commandWord.equalsIgnoreCase(OPEN.getWord())) {
            return OPEN;
        }
        return null;
    }
}
