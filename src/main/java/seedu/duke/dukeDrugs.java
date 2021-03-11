package seedu.duke;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class dukeDrugs {

    /**
     * Main entry-point for the java.duke.dukeDrugs application.
     */
    protected Storage storage;
    protected DrugActions drugActions;
    protected ArrayList<DrugInstance> drugInstances;
    public dukeDrugs(String filePath) {
        storage = new Storage(filePath);
        try {
            drugInstances = storage.uploadDrugs();
            drugActions = new DrugActions();
        } catch (FileNotFoundException e) {
            drugInstances = storage.createNewFile();
        }
    }
    public static void main(String[] args) {
        String pathOfFile = new File("").getAbsolutePath();
        dukeDrugs duke = new dukeDrugs(pathOfFile + "/drugInstances.txt");
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("What is your name?");

        Scanner in = new Scanner(System.in);
        System.out.println("Hello " + in.nextLine());

        duke.run();
    }

    public void run() {
        Scanner myObj = new Scanner(System.in);
        String command = myObj.nextLine();
        while (!command.equals("bye")) {
            if (command.equals("list")) {
                drugActions.printList();
            } else if (command.contains("add")) {
                drugActions.addDrugs(command);
            } else if (command.contains("delete")) {
                drugActions.deleteDrugs(command);
            } else {
                System.out.println("There is no such action! Please only enter the following: ");
                System.out.println("1) add <...>\r\n2) delete<...>\r\n3) list\r\n4) bye");
            }
            command = myObj.nextLine();
        }
        storage.exitProgram();
    }

}
