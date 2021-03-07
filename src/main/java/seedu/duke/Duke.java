package seedu.duke;

import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {

        welcomeMessage();

        String input;
        Scanner in = new Scanner(System.in);
        input = in.nextLine();

        boolean isBye = false;
        while (!isBye) {
            switch (input) {
            case "bye":
                isBye = true;
                byeMessage();
            default:
                System.out.println(input + "\n");
                input = in.nextLine();
            }
        }



    }

    private static void byeMessage() {
        System.out.println("Bye. Hope to see you again soon!\n");
    }

    private static void welcomeMessage() {
        System.out.println("Hello! I'm FridgeFriend!");
        System.out.println("What can I do for you?\n");
    }
}