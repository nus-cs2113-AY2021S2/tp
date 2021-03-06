package seedu.duke;

import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {

        System.out.println("Hello! I'm FridgeFriend!");
        System.out.println("What can I do for you?\n");

        String input;
        Scanner in = new Scanner(System.in);
        input = in.nextLine();
        while (!input.equals("bye")){
            System.out.println(input + "\n");
            input = in.nextLine();
        }

        System.out.println("Bye. Hope to see you again soon!\n");

    }
}