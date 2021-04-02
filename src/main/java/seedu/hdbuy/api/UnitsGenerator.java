package seedu.hdbuy.api;

import java.util.ArrayList;

import seedu.hdbuy.common.Unit;
import seedu.hdbuy.data.SearchedUnits;

public class UnitsGenerator {

    /**
     * Sifts through response string to get details on units and generate each of them.
     *
     * @param response Response from database containing raw information on units.
     */
    public static void getUnits(String response) {
        ArrayList<Unit> units = new ArrayList<>();
        String records = response.substring(response.indexOf("records") - 1);
        String trimmed = records.substring(records.indexOf("[") + 1, records.indexOf("]"));
        String[] unitContents = trimmed.split("},");
        for (String unitContent : unitContents) {
            unitContent = unitContent.replaceAll("\\{", "");
            unitContent = unitContent.replaceAll("}", "");
            unitContent = unitContent.replaceAll("\"", "");
            String[] unitDetails = unitContent.split(",");
            Unit unit = getUnit(unitDetails);
            SearchedUnits.addToResult(unit);
        }
    }

    private static Unit getUnit(String[] details) {
        String location = "";
        String type = "";
        int price = 0;
        String lease = "";
        String address = "";
        String block = "";
        int leaseValue = 0;
        for (String detail : details) {
            String[] keyValue = detail.split(":");
            String key = keyValue[0].trim();
            String value = keyValue[1];

            if (key.equals("town")) {
                location = value.trim();
            }

            if (key.equals("flat_type")) {
                type = value.trim();
            }

            if (key.equals("resale_price")) {
                price = Integer.parseInt(value.trim());
            }

            if (key.equals("remaining_lease")) {
                lease = value;
                String[] times = value.split(" ");
                int years = Integer.parseInt(times[1]);
                leaseValue = years * 12;
                if (times.length > 3) {
                    int months = Integer.parseInt(times[3]);
                    leaseValue += months;
                }
            }

            if (key.equals("block")) {
                block = value.trim();
            }

            if (key.equals("street_name")) {
                address = value.trim();
            }
        }
        address = block + " " + address;
        return new Unit(location, type, price, leaseValue, lease, address, address.hashCode());
    }
}