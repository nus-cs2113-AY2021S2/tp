package seedu.hdbuy;

import java.util.HashMap;
import java.util.Scanner;

import seedu.hdbuy.api.ApiRepository;
import seedu.hdbuy.data.QueryKey;
import seedu.hdbuy.data.Unit;

public class HdBuy {
    /**
     * Main entry-point for the java.duke.Duke application.
     */
    public static void main(String[] args) {
        System.out.println("Current parameters: location = bedok, type = 3 room, lease = 95 years\n");

//        Scanner in = new Scanner(System.in);

        HashMap<QueryKey,String> inputs = new HashMap<>();
        inputs.put(QueryKey.LOCATION, "bedok");
        inputs.put(QueryKey.TYPE, "3 room");
        inputs.put(QueryKey.LEASE_REMAINING, "95");
        HashMap<Integer, Unit> units = ApiRepository.fetchUnits(inputs);
    }
}
