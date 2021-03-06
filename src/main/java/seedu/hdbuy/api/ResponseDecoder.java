package seedu.hdbuy.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import seedu.hdbuy.data.Unit;

public class ResponseDecoder {

    public static HashMap<Integer, Unit> decodeResponse(InputStream inputStream) {

        BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
        try {
            String response = in.readLine();
            in.close();
            if (response != null && !response.isEmpty()) {
                return getUnits(response);
            } else {
                throw new IOException("Empty response");
            }
        } catch (IOException ioException) {
            System.out.println(ioException.getMessage());
        }
        return null;
    }

    private static HashMap<Integer, Unit> getUnits(String response) {
        HashMap<Integer, Unit> map = new HashMap<>();
        String records = response.substring(response.indexOf("records") - 1);
        String trimmed = records.substring(records.indexOf("[") + 1, records.indexOf("]"));
        String[] unitContents = trimmed.split("},");
        for (String unitContent : unitContents) {
            unitContent = unitContent.replaceAll("\\{", "");
            unitContent = unitContent.replaceAll("\\}", "");
            unitContent = unitContent.replaceAll("\"", "");
            String[] unitDetails = unitContent.split(",");
            Unit unit = getUnit(unitDetails);
            map.put(unit.getId(), unit);
            System.out.println(unit.toString());
        }
        return map;
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
