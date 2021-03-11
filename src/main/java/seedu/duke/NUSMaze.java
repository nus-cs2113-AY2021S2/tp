package seedu.duke;

import ManagerClasses.UIManager;

import java.util.Scanner;

public class NUSMaze {
    public static void main(String[] args) {
        UIManager.showLogo();
        UIManager.showGreetMessage();
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        while (true) {
            if (input.equals("go")) {
                System.out.println("STARTING BLOCK:");
                String from = in.nextLine().toUpperCase();
                System.out.println("DESTINATION BLOCK:");
                String to = in.nextLine().toUpperCase();
                Router router = new Router();
                router.execute(from,to);
                System.out.println("");
            }
            else if (input.equals("bye")){
                UIManager.showByeMessage();
                break;
            }
        }
    }
}
