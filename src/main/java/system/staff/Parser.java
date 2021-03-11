package system.staff;

import java.io.IOException;
import java.util.Scanner;

import static system.staff.UI.printLine;
import static system.staff.UI.staffHeader;

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

        case ("print"):
            staffHeader();
            printLine();
            Staff.print();
            break;

        case ("list"):
            staffHeader();
            printLine();
            if (line.split(" ")[1].equals("nurses")) {
                Staff.listNurse();
            } else if (line.split(" ")[1].equals("doctors")) {
                Staff.listDoctor();
            } else {

            }
            break;

        case ("delete"):
            Staff.delete(line);
            break;

        default:
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
