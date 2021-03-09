package seedu.duke;

import java.util.Scanner;


public class NUSMaze {
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);

        Scanner in = new Scanner(System.in);
        while (true){
            String input = in.nextLine();
            if (input.equals("go")){
                System.out.println("STARTING BLOCK:");
                String from = in.nextLine();
                System.out.println("DESTINATION BLOCK:");
                String to = in.nextLine();
                Routing map = new Routing();
                map.printShortestDistance(from,to);
                System.out.println("");
            }
            else if (input.equals("bye")){
                break;
            }
        }
    }








}
