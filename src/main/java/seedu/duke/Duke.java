package seedu.duke;

import java.util.Scanner;


public class Duke {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (true){
            String input = in.nextLine();
            if (input.equals("go")){
                System.out.println("STARTING BLOCK:");
                String from = in.nextLine();
                System.out.println("DESTINATION BLOCK:");
                String to = in.nextLine();
                Router router = new Router();
                router.execute(from,to);
                System.out.println("");
            }
            else if (input.equals("bye")){
                break;
            }
        }
    }
}
