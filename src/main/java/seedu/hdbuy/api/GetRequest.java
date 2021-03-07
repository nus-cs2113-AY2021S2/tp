package seedu.hdbuy.api;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.HashMap;

import seedu.hdbuy.data.Unit;
import seedu.hdbuy.data.exception.EmptyResponseException;
import seedu.hdbuy.data.exception.GatewayException;

public class GetRequest {

    private static URL url;
    private static HttpURLConnection httpURLConnection;
    private static final String urlString =
        "https://data.gov.sg/api/action/datastore_search" +
        "?resource_id=42ff9cfe-abe5-4b54-beda-c88f9bb438ee&q=";

    public static HashMap<Integer, Unit> getResponse(String query) throws EmptyResponseException {
        try {
            url = new URL(urlString + query);
            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.connect();
            return ResponseDecoder.decodeResponse(httpURLConnection.getInputStream());
        } catch (GatewayException | IOException exception) {
            System.out.println(exception.getMessage());
        }
        return null;
    }
}
