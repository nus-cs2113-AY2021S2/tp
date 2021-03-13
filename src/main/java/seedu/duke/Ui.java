package seedu.duke;


import java.util.Scanner;

/**
 * Handles general user interaction aspects of Diliveri, including
 *
 * @author Manika Hennedige
 * @version 1
 * @since 13-03-2021
 */
public class Ui {
    protected static final String DIVIDER = "-------------------------------------";
    // this is done because the HELP_MESSAGE is being printed in 2 places (welcome and help)
    protected static final String HELP_MESSAGE =
            "The following are several accepted commands by Diliveri:\n\n" +
                    "'help': Displays this help message\n" +
                    "'view': Displays your profile\n" +
                    "'editprofile': Allows you to edit your profile details\n" +
                    "'start': Loads up an allocated delivery assignment into the delivery list\n" +
                    "'list': Displays the list of deliveries in your assignment\n" +
                    "'viewdelivery <number>': Displays details of the selected delivery\n" +
                    "'complete <number>': Marks the selected delivery as completed";

    /**
     * Empty constructor for the Ui object
     */
    public Ui() {}

    /**
     * This method is only callable from within the Ui class
     */
    protected void printDivider() {
        System.out.println(DIVIDER);
    }


    /**
     * Prints welcome screen
     */
    public void showWelcomeScreen() {
        printDivider();
        System.out.println("Welcome to Diliveri");
        System.out.println(HELP_MESSAGE);
        printDivider();
    }

    public void showFarewellScreen() {
        printDivider();
        System.out.println("Safe travels! Goodbye!");
        printDivider();
    }

    /**
     * Shows help message with accepted commands
     */
    public void showHelpMessage() {
        printDivider();
        System.out.println(HELP_MESSAGE);
        printDivider();
    }

    /**
     * Asks for user input
     */
    public void promptUserInput() {
        printDivider();
        System.out.println("How can Diliveri help you today?");
        printDivider();
    }

    /**
     * Method backbone for menu selection
     * Parser is only called for commands that require argument parsing
     */
    public void showLoopingMenuUntilExit() {
        Parser parser = new Parser();
        Scanner sc = new Scanner(System.in);
        String userInput;
        String userCommand;
        String userArguments;
        promptUserInput();
        do {
            userInput = sc.nextLine();
            userCommand = parser.parseCommand(userInput);
            userArguments = parser.parseArguments(userInput);
            switch (userCommand) {
                case "help":
                    showHelpMessage(); // relocate this to inside parser?
                    break;
                case "profile":
                    // view profile
                    break;
                case "edit":
                case "editprofile":
                    parser.parseInput("edit", userArguments);
                    // parser needs to validate the arguments are entered properly
                    break;
                case "start":
                    // load delivery assignment
                    break;
                case "list":
                    parser.parseInput("list", userArguments);
                    // show delivery list
                    break;
                case "view":
                case "viewdelivery":
                    parser.parseInput("viewdelivery", userArguments);
                    // show selected delivery list - need parser to get and check selected item
                    break;
                case "complete":
                    parser.parseInput("complete", userArguments);
                    // mark delivery as completed - use parser to get and check selected item
                    break;
                case "bye":
                    showFarewellScreen();
                    break;
                default:
                    System.out.println("Incorrect entry"); // raise exception
            }
            promptUserInput();


        } while (!userCommand.equalsIgnoreCase("bye"));
    }


}
