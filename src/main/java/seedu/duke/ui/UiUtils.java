package seedu.duke.ui;

public class UiUtils {
    private static final String LINE_SEPARATOR = System.lineSeparator();
    private static final String DIVIDER = "--------------------------------------------------------------------------";
    private static final String SPACING = "      ";
    private static final String INPUT_HEADER = "> ";
    private static final String LOGO =  " /$$   /$$ /$$   /$$  /$$$$$$  /$$      /$$\n"
            + "| $$$ | $$| $$  | $$ /$$__  $$| $$$    /$$$\n"
            + "| $$$$| $$| $$  | $$| $$  \\__/| $$$$  /$$$$  /$$$$$$  /$$$$$$$$  /$$$$$$\n"
            + "| $$ $$ $$| $$  | $$|  $$$$$$ | $$ $$/$$ $$ |____  $$|____ /$$/ /$$__  $$\n"
            + "| $$  $$$$| $$  | $$ \\____  $$| $$  $$$| $$  /$$$$$$$   /$$$$/ | $$$$$$$$\n"
            + "| $$\\  $$$| $$  | $$ /$$  \\ $$| $$\\  $ | $$ /$$__  $$  /$$__/  | $$_____/\n"
            + "| $$ \\  $$|  $$$$$$/|  $$$$$$/| $$ \\/  | $$|  $$$$$$$ /$$$$$$$$|  $$$$$$$\n"
            + "|__/  \\__/ \\______/  \\______/ |__/     |__/ \\_______/|________/ \\_______/";
    private static final String GREETING_MESSAGE = "Hello! Welcome to NUSMaze" + LINE_SEPARATOR
            + "Where do you want to go today?";
    private static final String BYE_MESSAGE = "Bye. Hope to see you again soon!";
    private static final String HELP_MESSAGE = "1. go:\n"
            + SPACING + "finds the route to go from one block to another\n"
            + "2. history:\n"
            + SPACING + "lists past 10 route searches\n"
            + "3. add note LOCATION/DESCRIPTION:\n"
            + SPACING + "adds and tags a note to a particular location\n"
            + "4. list notes LOCATION:\n"
            + SPACING + "list notes tagged to the given location\n"
            + "5. delete note LOCATION/NOTE INDEX:\n"
            + SPACING + "deletes notes based on index number tagged to the given location";

    public String getLineSeparator() {
        return LINE_SEPARATOR;
    }

    public String getDivider() {
        return DIVIDER;
    }

    public String getInputHeader() {
        return INPUT_HEADER;
    }

    public String getLogo() {
        return LOGO;
    }

    public String getGreetingMessage() {
        return GREETING_MESSAGE;
    }

    public String getByeMessage() {
        return BYE_MESSAGE;
    }

    public String getHelpMessage() {
        return HELP_MESSAGE;
    }

}
