package seedu.connoisseur.messages;

public class Messages {
    public static final String LOGO = "   _____                        _                         \n"
            + "  / ____|                      (_)                        \n"
            + " | |     ___  _ __  _ __   ___  _ ___ ___  ___ _   _ _ __ \n"
            + " | |    / _ \\| '_ \\| '_ \\ / _ \\| / __/ __|/ _ \\ | | | '__|\n"
            + " | |___| (_) | | | | | | | (_) | \\__ \\__ \\  __/ |_| | |   \n"
            + "  \\_____\\___/|_| |_|_| |_|\\___/|_|___/___/\\___|\\__,_|_|   \n";

    public static final String WELCOME_MESSAGE = "                         Welcome to\n"
            + LOGO;

    public static final String COMMAND_PROMPT = "____________________________________________________________\n" 
            + "Please enter a command: ";
    public static final String HELP_MESSAGE = "Connoisseur is a review app to keep track of all your experiences!"
            + "\nCommands:\nhelp\tdisplays commands recognised by connoisseur\n"
            + "new\t\tadds a new review\nsort\tsets your preferred sorting method for your reviews"
            + "\nlist\tlists your stored reviews\ndelete\tdeletes a review\nexit\texits connoisseur";
    public static final String SORT_HELP_MESSAGE = "Sort will set your preferred sorting method for your reviews.\n"
            + "Currently recognised methods are:\nstars\ndate_earliest\ndate_latest\ntitle\n"
            + "\nCommand syntax: sort <method>";
    public static final String EXIT_MESSAGE = "Thanks for using Connoisseur, see you again!";
    public static final String ERROR_MESSAGE = "An error has occured";
    public static final String INVALID_COMMAND = "Invalid command.";

    // Storage
    public static final String FILE_ALREADY_EXISTS = "Data file already exists";
    public static final String FILE_SUCCESS = "Created new data file";
    public static final String FOLDER_ALREADY_EXISTS = "Data folder already exists";
    public static final String FOLDER_SUCCESS = "Created new data folder";
    public static final String CURRENT_DIRECTORY = "Present project directory is: " + System.getProperty("user.dir");

    // Add
    public static final String QUICK_PROMPT = "Do you want to add a quick review? (y/n)";
    public static final String TITLE_PROMPT = "Please enter title of review: ";
    public static final String CATEGORY_PROMPT = "Please enter category of experience: ";
    public static final String RATING_PROMPT = "Please enter rating of experience (out of 5): ";
    public static final String DESCRIPTION_PROMPT = "Please enter description of the experience: ";
    public static final String ADD_SUCCESS = " has been saved to your list.";

    // Sort
    public static final String MISSING_SORT_METHOD = "Please specify sort method";
    public static final String INVALID_SORT_METHOD = " is not valid sorting method, please try again.";
    public static final String SORT_METHOD_SUCCESS = "Success! Your preferred sorting method has been saved: ";

    // Delete
    public static final String MISSING_DELETE_TITLE = "Please specify title of review to be deleted";
    public static final String INVALID_DELETE_TITLE = "Specified review does not exist!";
    public static final String DELETE_SUCCESS = " has been deleted.";
}
