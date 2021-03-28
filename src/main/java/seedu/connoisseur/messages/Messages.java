package seedu.connoisseur.messages;

public class Messages {
    public static final String LOGO = "   _____                        _                         \n"
            + "  / ____|                      (_)                        \n"
            + " | |     ___  _ __  _ __   ___  _ ___ ___  ___ _   _ _ __ \n"
            + " | |    / _ \\| '_ \\| '_ \\ / _ \\| / __/ __|/ _ \\ | | | '__|\n"
            + " | |___| (_) | | | | | | | (_) | \\__ \\__ \\  __/ |_| | |   \n"
            + "  \\_____\\___/|_| |_|_| |_|\\___/|_|___/___/\\___|\\__,_|_|   \n";

    public static final String WELCOME_MESSAGE = "                         Welcome to\n"
            + LOGO
            + "\n"
            + "Connoisseur is in review mode by default!\n"
            + "Enter 'review' or 'reco' to change mode at any point:) ";

    public static final String COMMAND_PROMPT = "_____________________________________________________________________"
            + "______________________\n"
            + "Please enter a command: ";

    public static final String EXIT_MESSAGE = "Thanks for using Connoisseur, see you again!";
    public static final String ERROR_MESSAGE = "An error has occured";
    public static final String INVALID_COMMAND = "Invalid command, please try again.";

    // Help
    public static final String HELP_MESSAGE = "Connoisseur is a review app to keep track of all your experiences!\n"
            + "\nCommands:\nhelp\tdisplays commands recognised by connoisseur\n"
            + "new\t\tadds a new review\nadd\t\tadds a new recommendation"
            + "\nsort\tsets your preferred sorting method for your reviews"
            + "\nlist\tlists your stored reviews ro recommendations\nedit\tedits an existing review in your list\n"
            + "delete\tdeletes a review\nexit\texits connoisseur\n"
            + "\nType <help> followed by <command> to learn more about how each command can be used.";
    public static final String SORT_HELP_MESSAGE = "Sort will set your preferred sorting method for your reviews.\n"
            + "Currently recognised methods are:\nstars\nearliest\nlatest\ntitle\n"
            + "\nCommand syntax: sort <method>";
    public static final String LIST_HELP_MESSAGE = "List will allow you to list all your reviews or recommendations.\n"
            + "\nCommand syntax to list reviews: list review\nCommand syntax to list recommendations: list reco\n";
    public static final String EDIT_HELP_MESSAGE = "Edit will allow you to edit an existing review in your list.\n\n"
            + "Command syntax: edit <title of review you would like to edit>";
    public static final String EXIT_HELP_MESSAGE = "Exit will allow you to exit the application.\n\n"
            + "Command syntax: bye";
    public static final String REVIEW_HELP_MESSAGE = "New will allow you to add a review.\n"
            + "\nDetails to include in the review:\n\tTitle of Review\n\tQuick Review: y/n\n\tCategory of Experience"
            + "\n\tRating\n\tIf it is not a quick review, you can also enter a description of the experience."
            + "\n\nCommand syntax for review: new\nAlternatively, you can also type:\n\tFor quick review: new quick"
            + "\n\tFor full review: new long ";
    public static final String DELETE_HELP_MESSAGE = "Delete will allow you to remove an entry you input previously\n\n"
            + "Command syntax: delete <title of review>";
    public static final String VIEW_HELP_MESSAGE = "View will allow you to view the details of a review entry you"
            + " made.\nYou can view the title, ratings, date and the full description of your experience.\n\n"
            + "Command Syntax: view <title of review>";
    public static final String RECOMMENDATION_HELP_MESSAGE = "Add will allow you to add a new recommendation.\n"
            + "\nDetails to include in the recommendation:\n\tTitle of recommendation\n\tCategory of experience"
            + "\n\tPrice range of recommendation\n\tHow did you know about this recommendation\n"
            + "\nCommand syntax for recommendation: add <title of recommendation>";

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
    public static final String PRICE_PROMPT = "Please enter price range of recommendation (separated by - ): ";
    public static final String DESCRIPTION_PROMPT = "Please enter description of the experience: ";
    public static final String RECOBY_PROMPT = "How did you know about this recommendation";
    public static final String LOCATION_PROMPT = "Where is this located at? ( NA if not applicable)";
    public static final String ADD_SUCCESS = " has been saved to your list.";
    public static final String MISSING_RECO_TITLE = "Please specify title of recommendation";


    // Sort
    public static final String CURRENT_SORT_METHOD = "Your current sort method is: ";
    public static final String SORT_METHOD_PROMPT = "Use sort [method] to change sorting method";
    public static final String INVALID_SORT_METHOD = " is not valid sorting method, please try again.";
    public static final String SORT_METHOD_SUCCESS = "Success! Your preferred sorting method has been saved: ";

    // Delete
    public static final String MISSING_DELETE_TITLE = "Please specify title of review to be deleted";
    public static final String INVALID_DELETE_TITLE = "Specified review does not exist!";
    public static final String DELETE_SUCCESS = " has been deleted.";

    // View
    public static final String INVALID_VIEW_TITLE = "Specified review does not exist!";
    public static final String MISSING_VIEW_TITLE = "Please specify title of review you would like to view";

    //Edit
    public static final String MISSING_EDIT_TITLE = "Please specify title of review you would like to edit";
}
