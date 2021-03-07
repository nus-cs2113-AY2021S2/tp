package seedu.duke;

import seedu.duke.ui.Ui;

import java.util.Scanner;

public class Duke {
    private Ui ui;

    /**
     * Main entry-point for the java.duke.Duke application.
     */
    public static void main(String[] args) {
        /*
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("What is your name?");

        Scanner in = new Scanner(System.in);
        System.out.println("Hello " + in.nextLine());
         */
        new Duke().run();
    }

    /** Runner for the FINUX Application */
    private void run() {
        start();
        commandLooper();
        end();
    }

    private void start() {
        this.ui = new Ui();
        ui.printWelcomeMessage();
    }

    private void end() {
        ui.printGoodByeMessage();
    }

    private void commandLooper() {
        String rawInput;
        do {
            rawInput = ui.getUserInput();
            System.out.println("You have entered: " + rawInput);
        } while(!rawInput.equals("exit"));
    }
}
