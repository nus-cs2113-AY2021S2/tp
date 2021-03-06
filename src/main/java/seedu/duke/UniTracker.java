package seedu.duke;

import java.util.Scanner;

public class UniTracker {
    /**
     * Main entry-point for the java.duke.Duke application.
     */
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);

        runMainMenu();
    }

    public static void printMainMenu() {
        System.out.println("Main Menu:\n" +
                "[1] Module Information\n" +
                "[2] CAP Simulator/Calculator\n" +
                "[3] Task Manager\n" +
                "[4] External Links");
    }

    public static void runMainMenu() {

        Scanner in = new Scanner(System.in);
        while (true) {
            printMainMenu();
            String command = in.nextLine();
            try {
                int commandInt = Integer.parseInt(command);

                if (commandInt == 5) {
                    break;
                }

                switch (commandInt) {
                case 1:
                    //moduleInfo
                    break;
                case 2:
                    //helpGraduation
                    break;
                case 3:
                    //manageTask
                    break;
                case 4:
                    //externalLinks
                    break;
                default:
                    System.out.println("Please enter a valid integer from the menu.");
                }

            } catch (NumberFormatException n) {
                System.out.println("Please enter a valid integer.");
            }
        }


    }
}
