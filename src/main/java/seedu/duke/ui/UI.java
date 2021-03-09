package seedu.duke.ui;

import java.util.ArrayList;
import java.util.Scanner;

public class UI {

    public void printMessage(String message) {
        System.out.println(message);
    }

    public ArrayList<Integer> readIntegers() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> listOfIntegers = new ArrayList<>();
        while (scanner.hasNextInt()) {
            listOfIntegers.add(scanner.nextInt());
        }
        return listOfIntegers;
    }
}
