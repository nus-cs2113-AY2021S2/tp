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

    /**
     * Shows help message with accepted commands
     */
    public void showHelpMessage() {
        printDivider();
        System.out.println(HELP_MESSAGE);
        printDivider();
    }

    public void promptUserInput() {
        printDivider();
        System.out.println("How can Diliveri help you today?");
        printDivider();
    }

    public void showLoopingMenuUntilExit() {
        Parser parser = new Parser();
        Scanner sc = new Scanner(System.in);
        String userInput;
        String userCommand;

        promptUserInput();
        do {
            userInput = sc.nextLine();
            userCommand = userInput.split(" ")[0];
            // consider putting the above into Parser? e.g. parser.parseCommand(userInput)
            switch (userCommand) {
                case "help":
                    showHelpMessage();
                    break;
                case "view":
                    // view profile
                    break;
                case "editprofile":
                    // edit profile
                    break;
                case "start":
                    // load delivery assignment
                    break;
                case "list":
                    // show delivery list
                    break;
                case "viewdelivery":
                    // show selected delivery list - need parser to get selected item
                    break;
                case "complete":
                    // mark delivery as completed - use parser to get selected item
                    break;
                default:
                    System.out.println("Incorrect entry"); // raise exception
            }
            promptUserInput();


        } while (!userCommand.equalsIgnoreCase("bye"));
    }


}
