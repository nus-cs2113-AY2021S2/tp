package seedu.duke;

import seedu.duke.ui.UI;

public class Duke {
    public static void main(String[] args) {
        UI.printGreetings();
        UI.printHelpPrompt();
        exit();
    }

<<<<<<< HEAD
        Scanner in = new Scanner(System.in);
        System.out.println("Hello " + in.nextLine());
        
=======
    private static void exit() {
        UI.printExitMessage();
        System.exit(0);
>>>>>>> a496cf6648346b99d9f86ce88a8ffb3516e64fd4
    }
}
