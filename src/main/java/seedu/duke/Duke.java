package seedu.duke;

import seedu.duke.ui.UI;

public class Duke {
    public static void main(String[] args) {
        UI.printGreetings();
        UI.printHelpPrompt();
        exit();
    }

    private static void exit() {
        UI.printExitMessage();
        System.exit(0);
        
    }
}
