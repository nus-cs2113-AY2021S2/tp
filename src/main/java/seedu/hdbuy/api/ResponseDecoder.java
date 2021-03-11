package seedu.hdbuy.api;

import seedu.hdbuy.data.Unit;
import seedu.hdbuy.data.exception.EmptyResponseException;
import seedu.hdbuy.data.exception.GatewayException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

public class ResponseDecoder {

    /**
     * Converts response body into units mapped by a unique ID from hashcode.
     *
     * @param inputStream Response body.
     * @return Units mapped by a unique ID.
     * @throws EmptyResponseException When no units are retrieved.
     * @throws GatewayException       When there is an error connecting to database.
     */
    public static HashMap<Integer, Unit> decodeResponse(InputStream inputStream) throws EmptyResponseException, GatewayException {
        BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
        try {
            String response = in.readLine();
            in.close();
            return UnitsGenerator.getUnits(response);
        } catch (IOException ioException) {
            throw new GatewayException();
        } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            throw new EmptyResponseException();
        }
    }
}