package seedu.duke;

import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        while (!input.equals("bye")) {
            input = in.nextLine();
            if (input.equals("go")) {
                System.out.println("STARTING BLOCK:");
                String from = in.nextLine().toUpperCase();
                System.out.println("DESTINATION BLOCK:");
                String to = in.nextLine().toUpperCase();
                Router router = new Router();
                router.execute(from,to);
                System.out.println("");
            }
        }
    }
}
