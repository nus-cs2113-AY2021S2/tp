package seedu.duke;

import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {

        printWelcomeMessage();

        String input;
        Scanner in = new Scanner(System.in);
        input = in.nextLine();

        boolean isBye = false;
        while (!isBye) {
            switch (input.toLowerCase()) {
            case "bye":
                isBye = true;
                printByeMessage();
                break;
            default:
                System.out.println(input + "\n");
                input = in.nextLine();
                break;
            }
        }



    }

    private static void printByeMessage() {
        System.out.println("Bye. Hope to see you again soon!\n");
    }

    private static void printWelcomeMessage() {
        System.out.println("Hello! I'm FridgeFriend!");
        System.out.println("What can I do for you?\n");
    }
}