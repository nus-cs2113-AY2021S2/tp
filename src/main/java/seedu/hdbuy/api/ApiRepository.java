package seedu.hdbuy.api;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import seedu.hdbuy.data.QueryKey;
import seedu.hdbuy.data.Unit;
import seedu.hdbuy.data.exception.EmptyResponseException;

public class ApiRepository {

    public static HashMap<Integer, Unit> fetchUnits(HashMap<QueryKey,String> inputs) {
        String query = QueryFormatter.formQuery(inputs);
        try {
            return GetRequest.getResponse(query);
        } catch (EmptyResponseException emptyResponseException) {
            System.out.println(emptyResponseException.getMessage());
            return new HashMap<Integer, Unit>();
        }
    }
}
