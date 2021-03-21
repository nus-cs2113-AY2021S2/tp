package seedu.duke;


import java.util.ArrayList;
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
                    "'profile': Displays your profile\n" +
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
     * Prints list of deliveries present in delivery list
     */
    public void showDeliveryList() {
        System.out.println("No. || Delivery ID || Status || Address || Recipient");
        int i = 1;
        for (Delivery delivery : DeliveryList.deliveries) {
            System.out.println(i + ". " + delivery);
            i++;
        }
    }

    public void showRecords(ArrayList<Delivery> records) {
        System.out.println("Congratulations on completing the following deliveries:");
        System.out.println(" Number | ID | Location | Earned Amount ");
        int i = 1;
        double total = 0;
        for (Delivery delivery : records) {
            total += delivery.getDeliveryFee();
            System.out.println(i + " | "
                    + delivery.getDeliveryID() + " | "
                    + delivery.getAddress() + " | " + delivery.getDeliveryFee());
        }
        System.out.println("Total Earnings: " + total);
    }

    /**
     * Shows details about a single delivery order
     * @param deliveryNumber is the index of the delivery in the ArrayList that is to be displayed
     */
    public void showDeliveryDetails(int deliveryNumber) {
        Delivery delivery = DeliveryList.deliveries.get(deliveryNumber);
        System.out.println(delivery);
        int i = 1;
        for (Item item : delivery.getItems()) {
            System.out.println(i + ": \n" + item);
            i++;
        }
    }

    /**
     * Displays to a user that a delivery has been completed
     * @param deliveryNumber is the index of the delivery to be marked as completed
     */
    public void showCompletedDelivery(int deliveryNumber) {
        Delivery delivery = DeliveryList.deliveries.get(deliveryNumber);
        System.out.println("The following delivery has been marked as completed:");
        System.out.println(delivery);
    }

    public void showProfile(Deliveryman deliveryman) {
        System.out.println(deliveryman);
    }

    /**
     * Method backbone for menu selection
     * Parser is only called for commands that require argument parsing
     * @param deliveryman is the currently loaded profile
     */
    public void showLoopingMenuUntilExit(Deliveryman deliveryman) {
        Parser parser = new Parser();
        Scanner sc = new Scanner(System.in);
        String userInput;
        String userCommand;
        String userArguments;
        int deliveryNumber;
        do {
            promptUserInput();
            userInput = sc.nextLine();
            userCommand = parser.parseCommand(userInput);
            userArguments = parser.parseArguments(userInput);
            switch (userCommand) {
                case "help":
                    showHelpMessage();
                    break;
                case "profile":
                    showProfile(deliveryman);
                    break;
                case "edit":
                case "editprofile":
                    // todo: extract the below as a method
                    String inputProfileData = parser.parseInput("edit", userArguments,deliveryman);
                    deliveryman.updateProfile(inputProfileData);
                    break;
                case "start":
                    DeliveryList.load();
                    break;
                case "list":
                    showDeliveryList();
                    break;
                case "view":
                case "viewdelivery":
                    deliveryNumber = Integer.parseInt(parser.parseInput("viewdelivery", userArguments, deliveryman));
                    // todo: exception handling (delivery numbers that are out of range)
                    showDeliveryDetails(deliveryNumber);
                    break;
                case "complete":
                    deliveryNumber = Integer.parseInt(parser.parseInput("complete", userArguments, deliveryman));
                    // todo: exception handling (numbers that are already complete/out of range) !important
                    Delivery.completeDelivery(deliveryman, deliveryNumber);
                    showCompletedDelivery(deliveryNumber);
                    break;
                case "record":
                    showRecords(deliveryman.getRecords());
                case "bye":
                    break;
                default:
                    System.out.println("Incorrect entry"); // raise exception
            }
        } while (!userCommand.equalsIgnoreCase("bye"));
    }


}
