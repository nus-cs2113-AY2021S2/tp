package seedu.duke;

import java.util.Scanner;

public class Menu {
	/**
	 * Method backbone for menu selection
	 * Parser is only called for commands that require argument parsing
	 * @param deliveryman is the currently loaded profile
	 */
	public void showLoopingMenuUntilExit(Deliveryman deliveryman) {
		Parser parser = new Parser();
		Ui ui = new Ui();
		Scanner sc = new Scanner(System.in);
		String userInput, userCommand, userArguments;
		Controller controller =  new Controller();
		do {
			ui.promptUserInput();
			userInput = sc.nextLine();
			if (userInput.isBlank()){
				userInput = "INVALID";
			}
			userCommand = parser.parseCommand(userInput);
			userArguments = parser.parseArguments(userInput);
			if (!userArguments.isEmpty()){
				controller.controllerForCommandsAndArguments(userCommand, userArguments, deliveryman);
			} else{
				controller.controllerForCommandsOnly(userCommand,deliveryman);
			}
		} while (!userCommand.equalsIgnoreCase("bye"));
	}
}
