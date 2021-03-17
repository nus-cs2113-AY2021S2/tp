package seedu.staff;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import static seedu.staff.UI.printLine;
import static seedu.staff.UI.staffHeader;


public class Parser {

    public static void run() throws IOException {
        Storage.fileHandling();
        System.out.println("Type something");
        Scanner in = new Scanner(System.in);
        while (true) {
            String line;
            line = in.nextLine();
            if (commandHandler(line) == 0) {
                break;
            }
        }
    }

    public static int commandHandler(String line) throws IOException {

        switch (line.split(" ")[0]) {
        case ("add"):
            Staff.add(line);
            break;

        case ("list"):
            staffHeader();
            printLine();
            String[] string = Arrays.copyOfRange(line.split(" "), 1, 2);
            Staff.list(string);
            break;

        case ("delete"):
            Staff.delete(line);
            break;
        case ("help"):
            UI.printStaffHelpList();
            break;

        case ("find"):
            try {
                Staff.find(line.split(" ")[1]);
            } catch (IndexOutOfBoundsException e ) {
                System.out.println("No input error");
            }
            break;

        case ("bye"):
            Storage.writeToFile();
            return 0;
        }

    return 1;
    }


    protected static String[] addFunctionParser(String line) {
        int length = line.split(" ").length;
        String[] input = new String[4];
        String[] array = line.split(" ");
        for (int i = 1; i<length; i++) {
            try {
                if (i <= 4) {
                    input[i-1] = array[i];
                } else {
                    input[3] = input[3] + " " + array[i];
                }

            } catch (IndexOutOfBoundsException e){
                input[i-1] = " ";
            }
        }
        return input;
    }
}
