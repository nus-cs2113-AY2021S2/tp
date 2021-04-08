package seedu.duke;

import seedu.logic.command.Command;
import seedu.logic.parser.StartMenuParser;
import seedu.ui.UI;

public class HealthVault {
    private UI ui;
    private StartMenuParser parser;

    private HealthVault() {
        ui = new UI();
        parser = new StartMenuParser();
    }

    /**
     * Calls for the running of a new Duke instance.
     *
     * @param args Runtime arguments are unused
     */
    public static void main(String[] args) {
        new HealthVault().run();
    }

    public void run() {
        UI.printWelcome();
        UI.printStartMenu();
        boolean isExit = false;
        while (!isExit) {
            try {
                String userInput = ui.getInput("Start Menu");
                UI.printEmptyLine();
                Command c = parser.startMenuParse(userInput);
                c.execute();
                isExit = c.isExit();
                if (isExit) {
                    ui.printGoodbye();
                }
            } catch (NullPointerException e) {
                //Command C can return as null if an error is triggered in parser
                //Null Pointer Exception may hence occur, the catch statement is to ensure it does not exit the loop.
            }
        }
    }
}