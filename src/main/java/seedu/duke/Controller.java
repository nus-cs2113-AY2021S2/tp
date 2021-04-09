package seedu.duke;

public class Controller {

	 Ui ui = new Ui();
	 Parser parser = new Parser();
	public void controllerForCommandsOnly(String userCommand, Deliveryman deliveryman){
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

	public void controllerForCommandsAndArguments(String userCommand, String userArguments, Deliveryman deliveryman){
		switch (userCommand){
		case "edit":
			String inputProfileData = parser.parseInput("edit", userArguments,deliveryman);
			deliveryman.updateProfile(inputProfileData);
			break;
		case "view":
			ui.processViewDelivery(userArguments, deliveryman, parser);
			break;
		case "complete":
			ui.processCompleteDelivery(userArguments, deliveryman, parser);
			break;
		default:
			System.out.println("Please enter a valid command!");
		}
	}
}
