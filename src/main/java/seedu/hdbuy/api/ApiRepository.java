package seedu.hdbuy.api;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import seedu.hdbuy.data.Unit;

public class ApiRepository {

    public static HashMap<Integer, Unit> fetchByLocation(String location) {
        String query = String.format("{\"town\":\"%s\"}&limit=50", location);
        return GetRequest.getResponse(query);
    }

    public static HashMap<Integer, Unit> fetchByType(String type) {
        String query = String.format("{\"flat_type\":\"%s\"}&limit=50", type);
        return GetRequest.getResponse(query);
    }

}
