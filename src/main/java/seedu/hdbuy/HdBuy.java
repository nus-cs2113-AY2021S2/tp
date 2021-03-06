package seedu.hdbuy;

import java.util.HashMap;
import java.util.Scanner;

import seedu.hdbuy.api.ApiRepository;
import seedu.hdbuy.data.Unit;

public class HdBuy {
    /**
     * Main entry-point for the java.duke.Duke application.
     */
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);

        Scanner in = new Scanner(System.in);

        HashMap<Integer, Unit> units = ApiRepository.fetchByLocation(in.nextLine());
//        HashMap<Integer, Unit> units = ApiRepository.fetchByType(in.nextLine());
    }
}
