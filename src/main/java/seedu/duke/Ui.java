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

    public void showDeliveryDetails(int deliveryNumber) {
        Delivery delivery = DeliveryList.deliveries.get(deliveryNumber);
        System.out.println(delivery);
        int i = 1;
        for (Item item : delivery.getItems()) {
            System.out.println(i + ": \n" + item);
            i++;
        }

    }

    public void showProfile(Deliveryman deliveryman) {
        System.out.println(deliveryman);
    }

    /**
     * Method backbone for menu selection
     * Parser is only called for commands that require argument parsing
     * @param deliveryman
     * @param dataManager
     */
    public void showLoopingMenuUntilExit(Deliveryman deliveryman, DataManager dataManager) {
        Parser parser = new Parser();
        Scanner sc = new Scanner(System.in);
        String userInput;
        String userCommand;
        String userArguments;
        int deliveryNumber;
        do {
            //Shifted this line down so we can do without the if statement in line 142
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
                    String inputProfileData = parser.parseInput("edit", userArguments,deliveryman);
                    if(inputProfileData != "fail"){
                        String[] splitInputProfileData = inputProfileData.split(" \\| ");
                        System.out.println("Based on your input:");
                        System.out.printf(" Name: %s\n Vehicle Model: %s\n License plate: %s\n",
                                splitInputProfileData[0],
                                splitInputProfileData[1],
                                splitInputProfileData[2]
                        );
                        deliveryman.editProfile(
                                splitInputProfileData[0],
                                splitInputProfileData[1],
                                splitInputProfileData[2]
                        );
                        dataManager.saveProfile(deliveryman);
                    }
                    break;
                case "start":
                    DeliveryList.loadDeliveryList();
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
                    // todo: exception handling (numbers that are already complete/out of range)
                    DeliveryList.deliveries.get(deliveryNumber).setDeliveryAsComplete();
                    break;
                case "bye":
                    break;
                default:
                    System.out.println("Incorrect entry"); // raise exception
            }
//            Look at comment in line 100
//            if (!userCommand.equalsIgnoreCase("bye")) {
//                promptUserInput();
//            }
        } while (!userCommand.equalsIgnoreCase("bye"));
    }


}
