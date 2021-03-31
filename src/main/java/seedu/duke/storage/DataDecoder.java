package seedu.duke.storage;

public class DataDecoder {

    public String[] decodeData(String encodedData) {
        return encodedData.split("/");
    }
}
