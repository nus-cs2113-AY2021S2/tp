package seedu.duke;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class drugsDuke {

    /**
     * Main entry-point for the java.duke.drugsDuke application.
     */
    protected DrugStorage drugStorage;
    protected DrugAction drugAction;
    protected ArrayList<drugInstance> drugInstances;
    public drugsDuke(String filePath) {
        drugStorage = new DrugStorage(filePath);
        try {
            drugInstances = drugStorage.uploadDrugs();
            drugAction = new DrugAction();
        } catch (FileNotFoundException e) {
            drugInstances = drugStorage.createNewFile();
        }
    }
    public static void main(String[] args) {
        String pathOfFile = new File("").getAbsolutePath();
        drugsDuke drugsDuke = new drugsDuke(pathOfFile + "/drugInstances.txt");
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("What is your name?");

        Scanner in = new Scanner(System.in);
        System.out.println("Hello " + in.nextLine());

        drugsDuke.run();
    }

    public void run() {
        Scanner myObj = new Scanner(System.in);
        String command = myObj.nextLine();
        while (!command.equals("bye")) {
            if (command.equals("list")) {
                drugAction.printList();
            } else if (command.contains("add")) {
                drugAction.addDrugs(command);
            } else if (command.contains("delete")) {
                drugAction.deleteDrugs(command);
            } else {
                System.out.println("There is no such action! Please only enter the following: ");
                System.out.println("1) add <...>\r\n2) delete<...>\r\n3) list\r\n4) bye");
            }
            command = myObj.nextLine();
        }
        drugStorage.exitProgram();
    }

}
