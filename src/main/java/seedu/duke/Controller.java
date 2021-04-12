package seedu.duke;

public class Controller {
    Ui ui = new Ui();
    Parser parser = new Parser();

    public void controllerForCommandsOnly(String userCommand, Deliveryman deliveryman) {
        switch (userCommand) {
        case "help":
            ui.showHelpMessage();
            break;
        case "profile":
            ui.showProfile(deliveryman);
            break;
        case "edit":
            System.out.println("Please use the format: n/name v/vehicle model l/license plate w/weight");
            System.out.println("i.e. edit n/Obi-Wan v/BMW X-Wing l/SJU7606F w/5");
            break;
        case "start":
            DeliveryList.load();
            break;
        case "list":
            ui.showDeliveryList();
            break;
        case "record":
            ui.showRecords(deliveryman.getRecords());
            break;
        case "route":
        case "deliveryroute":
            ui.processDeliveryRoute();
            break;
        case "bye":
            ui.showFarewellScreen();
            break;
        default:
            System.out.println("Please enter a valid command!");
        }
    }

    /**
     * primary controller for handling the user commands and arguments - passed from the Ui class.
     *
     * @param userCommand   refers to the command input by the user that requires further processing
     * @param userArguments refers to the arguments following the main command
     * @param deliveryman   object to attribute possible following actions to
     */
    public void controllerForCommandsAndArguments(String userCommand, String userArguments, Deliveryman deliveryman) {
        assert userArguments != null : "!! Argument is null";
        switch (userCommand) {
        case "edit":
            String inputProfileData = parser.parseInput("edit", userArguments);
            deliveryman.updateProfile(inputProfileData);
            break;
        case "view":
            ui.processViewDelivery(userArguments, parser);
            break;
        case "complete":
            ui.processCompleteDelivery(userArguments, deliveryman, parser);
            break;
        default:
            System.out.println("Please enter a valid command!");
        }
    }
}
