package seedu.duke.storage;

public interface DataDecoder {

    default String[] decodeData(String encodedData) {
        return encodedData.split("/");
    }
}
