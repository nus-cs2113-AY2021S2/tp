package seedu.duke;

import java.util.Scanner;

public class Ui {
    private Scanner userInputScanner;

    public Ui() {
        userInputScanner = new Scanner(System.in);
    }

    public String readInput() {
        return userInputScanner.nextLine();
    }

    public void closeScanner() {
        userInputScanner.close();
    }

    public void printString(String printstr) {
        System.out.println(printstr);
    }

    /*public void printPatients(HashMap<String,Patient> patients) {
        //to be implemented
    }*/

}
